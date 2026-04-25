// app/src/main/java/com/lbxq/screen/XposedModule.kt
package com.lbxq.screen

import org.lsposed.hiddenapibypass.XC_LoadPackage
import org.lsposed.hiddenapibypass.XposedBridge

class XposedModule : XC_LoadPackage.LoadPackageCallback {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        XposedBridge.log("ScreenModule loaded for ${lpparam.packageName}")
        // 在此添加具体的Hook逻辑
    }
}
