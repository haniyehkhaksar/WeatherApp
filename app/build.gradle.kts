plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
    buildToolsVersion(AndroidConfig.BUILD_TOOLS_VERSION)
    defaultConfig {
        applicationId = AndroidConfig.APP_ID
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME
        testInstrumentationRunner = "io.github.haniyehkhaksar.weatherapp.utils.TestRunner"
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
    }
    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            isDebuggable = BuildTypeDebug.isDebuggable
        }
    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }

    kotlinOptions {
        val options = this as? org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options?.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    kapt {
        correctErrorTypes = true
    }

}

dependencies {
    implementation(LibraryDependency.KOTLIN)

    // Support libraries
    implementation(LibraryDependency.APP_COMPACT)
    implementation(LibraryDependency.LEGACY_SUPPORT)
    implementation(LibraryDependency.MATERIAL)

    // Android KTX
    implementation(LibraryDependency.CORE_KTX)

    // UI
    implementation(LibraryDependency.SUPPORT_CONSTRAINT_LAYOUT)
    implementation(LibraryDependency.FRAGMENT_KTX)


    // Navigation
    implementation(LibraryDependency.NAVIGATION_FRAGMENT_KTX)
    implementation(LibraryDependency.NAVIGATION_UI_KTX)

    // Coroutines for getting off the UI thread
    implementation(LibraryDependency.COROUTINE_CORE)
    implementation(LibraryDependency.COROUTINE_ANDROID)

    // Retrofit for networking
    implementation(LibraryDependency.RETROFIT2)
    implementation(LibraryDependency.RETROFIT2_CONVERTOR_GSON)

    // Parsing the JSON format
    implementation(LibraryDependency.GSON)

    // OkHTTP
    implementation(LibraryDependency.OKHTTP)
    implementation(LibraryDependency.LOGGING_INTERCEPTOR)

    // Arch components
    // ViewModel and LiveData
    implementation(LibraryDependency.LIFECYCLE_LIVEDATA_KTX)
    implementation(LibraryDependency.LIFECYCLE_VIEW_MODEL_KTX)
    kapt(LibraryDependency.LIFECYCLE_EXTENSIONS)
    //View
    implementation(LibraryDependency.RECYCLER_VIEW)
    implementation(LibraryDependency.CARD_VIEW)
    //Multidex
    implementation(LibraryDependency.MULTIDEX)

    // Glide for images
    implementation(LibraryDependency.GLIDE)
    kapt(LibraryDependency.GLIDE_COMPILER)

    // Dagger 2
    kapt(LibraryDependency.HILT_COMPILER)
    implementation(LibraryDependency.HILT)

    // Test
    testImplementation(TestLibraryDependency.MOCKK)
    testImplementation(TestLibraryDependency.ASSERTJ)
    testImplementation(TestLibraryDependency.CORE_TESTING)
    testImplementation(TestLibraryDependency.JUPITER_PARAMS)
    testImplementation(TestLibraryDependency.JUPITER_API)
    testRuntimeOnly(TestLibraryDependency.JUPITER_ENGINE)
    testImplementation(TestLibraryDependency.COROUTINE_TEST)
    testImplementation(TestLibraryDependency.COROUTINE_CORE)

    //instrumented tests
    androidTestImplementation(TestLibraryDependency.ESPRESSO_CORE)
    implementation(TestLibraryDependency.ESPRESSO_IDLING_RESOURCE)
    androidTestImplementation(TestLibraryDependency.OKHTTP)
    androidTestImplementation(TestLibraryDependency.ASSERTJ)
    androidTestImplementation(TestLibraryDependency.FRAGMENT_TEST)
    androidTestImplementation(TestLibraryDependency.FRAGMENT_KTX)
    androidTestImplementation(TestLibraryDependency.CORE)

    androidTestImplementation(TestLibraryDependency.CORE_TESTING)
    androidTestImplementation(TestLibraryDependency.COROUTINE_TEST)
    androidTestImplementation(TestLibraryDependency.TEST_RULES)
    androidTestImplementation(TestLibraryDependency.RUNNER)

    // For instrumentation tests
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.37")
    kaptAndroidTest("com.google.dagger:hilt-compiler:2.37")

    // For local unit tests
    testImplementation("com.google.dagger:hilt-android-testing:2.37")
    kaptTest("com.google.dagger:hilt-compiler:2.37")


}

