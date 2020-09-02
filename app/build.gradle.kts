plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)

        applicationId = "br.com.vlabs.wiimmfiapp"
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin)
    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)

    testImplementation(TestLibs.junit)

    androidTestImplementation(TestLibs.junitExt)
    androidTestImplementation(TestLibs.espressoCore)
}