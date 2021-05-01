plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
//    id("name.remal.check-dependency-updates")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
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
        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
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
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        val options = this as? org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options?.jvmTarget = JavaVersion.VERSION_1_8.toString()
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
    implementation(LibraryDependency.COROUTINE_ADAPTER)

    // Parsing the JSON format
    implementation(LibraryDependency.GSON)

    // OkHTTP
    implementation(LibraryDependency.OKHTTP)
    implementation(LibraryDependency.LOGGING_INTERCEPTOR)


//    // Firebase
//    implementation 'com.google.firebase:firebase-auth:19.3.1'
//    implementation 'com.google.android.gms:play-services-auth:18.0.0'
//    implementation 'com.google.firebase:firebase-firestore-ktx:21.4.3'

    // Arch components
    // ViewModel and LiveData
    implementation(LibraryDependency.LIFECYCLE_LIVEDATA_KTX)
    implementation(LibraryDependency.LIFECYCLE_VIEW_MODEL_KTX)

    // glide for images
    implementation(LibraryDependency.GLIDE)
    kapt(LibraryDependency.GLIDE_COMPILER)

    // Dagger 2
    implementation(LibraryDependency.DAGGER)
    implementation(LibraryDependency.DAGGER_ANDROID)
    implementation(LibraryDependency.DAGGER_ANDROID_X)
    kapt(LibraryDependency.DAGGER_COMPILER)
    kapt(LibraryDependency.DAGGER_PROCESSOR)

    // Test
    testImplementation(TestLibraryDependency.JUNIT)


}

