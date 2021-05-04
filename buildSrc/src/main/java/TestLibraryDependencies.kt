private object TestLibraryVersion {
    const val JUNIT = "4.12"
    const val MOCKK = "1.10.5"
    const val ASSERTJ = "3.18.1"
    const val CORE_TESTING = "2.1.0"
    const val JUPITER = "5.7.0"
    const val COROUTINE_TEST = "1.3.3"
    const val COROUTINE_CORE = "1.4.1"
    const val ESPRESSO = "3.3.0"
    const val OKHTTP = "5.0.0-alpha.2"
    const val FRAGMENT = "1.3.3"
    const val CORE = "1.3.0"
    const val DAGGER = "2.35.1"
}

object TestLibraryDependency {
    const val JUNIT = "junit:junit:${TestLibraryVersion.JUNIT}"
    const val MOCKK = "io.mockk:mockk:${TestLibraryVersion.MOCKK}"
    const val ASSERTJ = "org.assertj:assertj-core:${TestLibraryVersion.ASSERTJ}"
    const val CORE_TESTING = "androidx.arch.core:core-testing:${TestLibraryVersion.CORE_TESTING}"
    const val JUPITER_PARAMS =
        "org.junit.jupiter:junit-jupiter-params:${TestLibraryVersion.JUPITER}"
    const val JUPITER_API = "org.junit.jupiter:junit-jupiter-api:${TestLibraryVersion.JUPITER}"
    const val JUPITER_ENGINE =
        "org.junit.jupiter:junit-jupiter-engine:${TestLibraryVersion.JUPITER}"
    const val COROUTINE_TEST =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${TestLibraryVersion.COROUTINE_TEST}"
    const val COROUTINE_CORE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${TestLibraryVersion.COROUTINE_CORE}"

    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${TestLibraryVersion.ESPRESSO}"
    const val ESPRESSO_CONTRIB =
        "androidx.test.espresso:espresso-contrib${TestLibraryVersion.ESPRESSO}"
    const val ESPRESSO_IDLING_RESOURCE =
        "androidx.test.espresso:espresso-idling-resource:${TestLibraryVersion.ESPRESSO}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${TestLibraryVersion.OKHTTP}"
    const val FRAGMENT_TEST = "androidx.fragment:fragment-testing:${TestLibraryVersion.FRAGMENT}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${TestLibraryVersion.FRAGMENT}"
    const val CORE = "androidx.test:core:${TestLibraryVersion.CORE}"
    const val TEST_RULES = "androidx.test:rules:${TestLibraryVersion.CORE}"
    const val RUNNER = "androidx.test:runner:${TestLibraryVersion.CORE}"
    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${TestLibraryVersion.DAGGER}"
    const val DAGGER_PROCESSOR =
        "com.google.dagger:dagger-android-processor:${TestLibraryVersion.DAGGER}"
}