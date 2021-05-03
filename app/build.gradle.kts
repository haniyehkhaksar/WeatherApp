plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
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
    kapt(LibraryDependency.LIFECYCLE_EXTENSIONS)
    implementation("androidx.recyclerview:recyclerview:1.2.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.multidex:multidex:2.0.1")

    // Glide for images
    implementation(LibraryDependency.GLIDE)
    kapt(LibraryDependency.GLIDE_COMPILER)

    // Dagger 2
    implementation(LibraryDependency.DAGGER)
    implementation(LibraryDependency.DAGGER_ANDROID)
    implementation(LibraryDependency.DAGGER_ANDROID_X)
    kapt(LibraryDependency.DAGGER_COMPILER)
    kapt(LibraryDependency.DAGGER_PROCESSOR)

    // Test
    testImplementation("io.mockk:mockk:1.10.5")
    testImplementation("org.assertj:assertj-core:3.18.1")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.3")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")

    //instrumented tests
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:3.3.0")
    androidTestImplementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    androidTestImplementation("org.assertj:assertj-core:3.18.1")
    androidTestImplementation("androidx.fragment:fragment-testing:1.3.3")
    androidTestImplementation("androidx.fragment:fragment-ktx:1.3.3")
    androidTestImplementation("androidx.test:core:1.3.0")
    //    androidTestImplementation("io.mockk:mockk-android:1.10.5")
    implementation("androidx.test.espresso:espresso-idling-resource:3.3.0")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.3")
    androidTestImplementation("androidx.test:rules:1.3.0")
    androidTestImplementation("androidx.test:runner:1.3.0")

    //shared preference
    implementation("androidx.preference:preference-ktx:1.1.1")

}

