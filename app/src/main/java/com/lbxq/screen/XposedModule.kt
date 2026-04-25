package com.lbxq.screen

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.callbacks.XC_LoadPackage

class XposedModule : IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        // 检测抖音启动
        if (lpparam.packageName == "com.ss.android.ugc.aweme") {
            XposedBridge.log("📱 模块捕获到抖音启动！包名：${lpparam.packageName}")
        }
    }
}
