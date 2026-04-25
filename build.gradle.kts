// app/build.gradle.kts
plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = 34
    defaultConfig {
        applicationId = "com.lbxq.screen"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
    }
    buildTypes { release { isMinifyEnabled = false } }
    compileOptions { sourceCompatibility = JavaVersion.VERSION_17 }
    kotlinOptions { jvmTarget = "17" }
}

dependencies {
    implementation("org.lsposed.api:api:1.9.1")  // 官方最新依赖
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}
