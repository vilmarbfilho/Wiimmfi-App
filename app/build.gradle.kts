plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
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

    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(Libs.coroutines)

    implementation(Libs.kotlin)
    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)
    implementation(Libs.coordinatorLayout)
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)
    implementation(Libs.recyclerView)

    implementation(Libs.koinCore)
    implementation(Libs.koinExt)
    implementation(Libs.koinScope)
    implementation(Libs.koinViewModel)
    implementation(Libs.koinFragment)

    implementation(Libs.lifecycleViewModel)
    implementation(Libs.lifecycleLivedataKtx)

    implementation(Libs.customTabs)

    implementation(Libs.firebaseAnalytics)
    implementation(Libs.firebaseCrashlytics)
    implementation(Libs.firebaseRemoteConfig)

    testImplementation(TestLibs.junit)
    testImplementation(TestLibs.koinTest)

    androidTestImplementation(TestLibs.junitExt)
    androidTestImplementation(TestLibs.espressoCore)
}