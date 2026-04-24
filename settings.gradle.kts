pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    // 关闭强制仓库限制，彻底解决冲突报错
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        maven("https://api.xposed.info")
    }
}
rootProject.name = "ScreenModule"
include(":app")
