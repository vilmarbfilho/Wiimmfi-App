object Versions {
    const val gradle = "4.0.1"
    const val kotlin = "1.4.0"
    const val appcompat = "1.2.0"
    const val junit = "4.12"
    const val koin_version = "2.1.6"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.2.1"

    const val coreKtx = "androidx.core:core-ktx:1.3.1"
    const val material = "com.google.android.material:material:1.2.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.1"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:2.3.0"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:2.3.0"

    const val jsoup = "org.jsoup:jsoup:1.13.1"

    const val koinCore = "org.koin:koin-core:${Versions.koin_version}"
    const val koinExt = "org.koin:koin-core-ext:${Versions.koin_version}"
    const val koinScope = "org.koin:koin-androidx-scope:${Versions.koin_version}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin_version}"
    const val koinFragment = "org.koin:koin-androidx-fragment:${Versions.koin_version}" //Fragment Factory (unstable version)
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:1.1.2"

    const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"

    const val koinTest = "org.koin:koin-test:${Versions.koin_version}"
}