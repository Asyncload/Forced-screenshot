// 包名：必须和文件夹结构一致
package com.example.forcescreenshot;

// 导入系统窗口类，控制界面显示、截图权限
import android.view.Window;
import android.view.WindowManager;

// Xposed 框架提供的API，用来“劫持”系统方法
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

// 模块主入口，实现Xposed接口
public class XposedInit implements IXposedHookLoadPackage {

    /**
     * 手机上每打开一个APP，都会触发这个方法
     * @param lpparam 包含当前APP的信息：包名、类加载器等
     */
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {

        // ==========================
        // 钩子1：劫持 setFlags 方法
        // 很多APP用它设置“禁止截图”
        // ==========================
        XposedHelpers.findAndHookMethod(
                Window.class,            // 要劫持的类：窗口类
                "setFlags",              // 要劫持的方法名
                int.class, int.class,    // 方法的两个参数类型
                new XC_MethodHook() {    // 劫持后的逻辑

                    // 在系统执行原方法之前运行
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {

                        // 拿到系统原本要设置的标记
                        int flags = (int) param.args[0];
                        int mask  = (int) param.args[1];

                        // 重点：移除“安全标记”（禁止截图的标记）
                        flags &= ~WindowManager.LayoutParams.FLAG_SECURE;
                        mask  &= ~WindowManager.LayoutParams.FLAG_SECURE;

                        // 把修改后的标记还给系统
                        param.args[0] = flags;
                        param.args[1] = mask;
                    }
                }
        );

        // ==========================
        // 钩子2：劫持 addFlags 方法
        // 有些APP用这个添加禁止截图
        // ==========================
        XposedHelpers.findAndHookMethod(
                Window.class,            // 同样是窗口类
                "addFlags",              // 方法名
                int.class,               // 参数类型
                new XC_MethodHook() {

                    @Override
                    protected void beforeHookedMethod(Param param) {

                        // 拿到要添加的标记
                        int flags = (int) param.args[0];

                        // 同样去掉禁止截图标记
                        flags &= ~WindowManager.LayoutParams.FLAG_SECURE;

                        param.args[0] = flags;
                    }
                }
        );
    }
}
