pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // 把Xposed仓库加在这里，全局生效
        maven { url = uri("https://api.xposed.info/") }
    }
}

rootProject.name = "ScreenModule"
include(":app")
