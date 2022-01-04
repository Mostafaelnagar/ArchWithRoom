object Libraries {

  // Support
  const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
  const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
  const val androidSupport = "androidx.legacy:legacy-support-v4:${Versions.supportVersion}"

  // Kotlin
  const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

  // Java
  const val javaInject = "javax.inject:javax.inject:${Versions.javaInject}"

  // Arch Components
  const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
  const val lifeData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
  const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
  const val viewModelState =
    "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
  const val paging_version = "androidx.paging:paging-runtime:${Versions.paging_version}"

  // Kotlin Coroutines
  const val coroutinesCore =
    "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
  const val coroutinesAndroid =
    "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"

  //ROOM
  const val room = "androidx.room:room-runtime:${Versions.room}"
  const val room_compile = "androidx.room:room-compiler:${Versions.room}"
  // Kotlin Extensions and Coroutines support for Room
  const val room_ktx = "androidx.room:room-ktx:${Versions.room}"

  // Networking
  const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
  const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
  const val gson = "com.google.code.gson:gson:${Versions.gson}"
  const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
  const val chuckLogging = "com.readystatesoftware.chuck:library:${Versions.chuckLogging}"

  // UI
  const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
  const val navigationFragment =
    "androidx.navigation:navigation-fragment-ktx:${Versions.androidNavigation}"
  const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.androidNavigation}"
  const val loadingAnimations = "com.github.ybq:Android-SpinKit:${Versions.loadingAnimations}"
  const val alerter = "com.github.tapadoo:alerter:${Versions.alerter}"
  const val coil = "io.coil-kt:coil:${Versions.coil}"

  // Utils
  const val localization =
    "com.zeugmasolutions.localehelper:locale-helper-android:${Versions.localization}"
  const val multidex = "androidx.multidex:multidex:${Versions.multidex}"

  // Hilt
  const val hilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
  const val hiltDaggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
}