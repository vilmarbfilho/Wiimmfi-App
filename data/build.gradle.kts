plugins {
    id("com.android.library")
    kotlin("android")
}

apply(from = "$rootDir/config/detekt/detekt.gradle")

android {
    compileSdkVersion(AppConfig.compileSdk)

    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)

        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(":domain"))

    implementation(Libs.coroutines)

    implementation(Libs.kotlin)
    implementation(Libs.coreKtx)
    implementation(Libs.jsoup)
    implementation(Libs.firebaseCrashlytics)
    implementation(Libs.firebaseRemoteConfig)

    testImplementation(TestLibs.junit)

    androidTestImplementation(TestLibs.junitExt)
    androidTestImplementation(TestLibs.espressoCore)
}