object Versions {
    const val gradle = "4.0.1"
    const val kotlin = "1.4.0"
    const val appcompat = "1.2.0"
    const val junit = "4.12"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    const val coreKtx = "androidx.core:core-ktx:1.3.1"
    const val material = "com.google.android.material:material:1.2.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.1"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:2.3.0"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:2.3.0"

    const val jsoup = "org.jsoup:jsoup:1.13.1"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:1.1.2"

    const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
}