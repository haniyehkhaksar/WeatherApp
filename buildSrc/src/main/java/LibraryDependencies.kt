private object LibraryVersion {
    const val APP_COMPACT = "1.3.0-rc01"
    const val CONSTRAINT_LAYOUT = "2.1.0-beta01"
    const val CORE_KTX = "1.6.0-alpha02"
    const val HILT = "2.37"
    const val FRAGMENT_KTX = "1.3.3"
    const val LIFECYCLE = "2.2.0"
    const val LIFECYCLE_VIEW_MODEL_KTX = "2.4.0-alpha01"
    const val LEGACY_SUPPORT = "1.0.0"
    const val MATERIAL = "1.4.0-alpha02"
    const val NAVIGATION = "2.3.5"
    const val COROUTINE = "1.5.0-RC"
    const val RETROFIT2 = "2.9.0"
    const val COROUTINE_ADAPTER = "0.9.2"
    const val GSON = "2.8.6"
    const val OKHTTP = "5.0.0-alpha.2"
    const val GLIDE = "4.12.0"
    const val RECYCLER_VIEW = "1.2.0"
    const val CARD_VIEW = "1.0.0"
    const val MULTIDEX = "2.0.1"
}

object LibraryDependency {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${CoreVersion.KOTLIN}"
    const val SUPPORT_CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${LibraryVersion.CONSTRAINT_LAYOUT}"
    const val APP_COMPACT = "androidx.appcompat:appcompat:${LibraryVersion.APP_COMPACT}"
    const val CORE_KTX = "androidx.core:core-ktx:${LibraryVersion.CORE_KTX}"

    //Dagger
    const val HILT = "com.google.dagger:hilt-android:${LibraryVersion.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-compiler:${LibraryVersion.HILT}"

    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${LibraryVersion.FRAGMENT_KTX}"
    const val LIFECYCLE_EXTENSIONS = "android.arch.lifecycle:extensions:${LibraryVersion.LIFECYCLE}"
    const val LIFECYCLE_VIEW_MODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${LibraryVersion.LIFECYCLE_VIEW_MODEL_KTX}"
    const val LIFECYCLE_LIVEDATA_KTX =
        "androidx.lifecycle:lifecycle-livedata-ktx:${LibraryVersion.LIFECYCLE_VIEW_MODEL_KTX}"
    const val LEGACY_SUPPORT = "androidx.legacy:legacy-support-v4:${LibraryVersion.LEGACY_SUPPORT}"

    const val MATERIAL = "com.google.android.material:material:${LibraryVersion.MATERIAL}"

    const val NAVIGATION_FRAGMENT_KTX =
        "androidx.navigation:navigation-fragment-ktx:${LibraryVersion.NAVIGATION}"
    const val NAVIGATION_UI_KTX =
        "androidx.navigation:navigation-ui-ktx:${LibraryVersion.NAVIGATION}"

    const val COROUTINE_CORE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibraryVersion.COROUTINE}"
    const val COROUTINE_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibraryVersion.COROUTINE}"

    const val RETROFIT2 = "com.squareup.retrofit2:retrofit:${LibraryVersion.RETROFIT2}"
    const val RETROFIT2_CONVERTOR_GSON =
        "com.squareup.retrofit2:converter-gson:${LibraryVersion.RETROFIT2}"
    const val COROUTINE_ADAPTER =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${LibraryVersion.COROUTINE_ADAPTER}"

    const val GSON = "com.google.code.gson:gson:${LibraryVersion.GSON}"

    const val OKHTTP = "com.squareup.okhttp3:okhttp:${LibraryVersion.OKHTTP}"
    const val LOGGING_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${LibraryVersion.OKHTTP}"

    const val GLIDE = "com.github.bumptech.glide:glide:${LibraryVersion.GLIDE}"
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${LibraryVersion.GLIDE}"

    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${LibraryVersion.RECYCLER_VIEW}"
    const val CARD_VIEW = "androidx.cardview:cardview:${LibraryVersion.CARD_VIEW}"
    const val MULTIDEX = "androidx.multidex:multidex:${LibraryVersion.MULTIDEX}"
}
