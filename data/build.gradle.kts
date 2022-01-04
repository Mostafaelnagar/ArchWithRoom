plugins {
  id(Config.Plugins.androidLibrary)
  id(Config.Plugins.kotlinAndroid)
  id(Config.Plugins.kotlinKapt)
}

android {
  compileSdk = Config.AppConfig.compileSdkVersion

  defaultConfig {
    minSdk = Config.AppConfig.minSdkVersion
    targetSdk = Config.AppConfig.compileSdkVersion
  }

  buildTypes {
    getByName("release") {
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
    }
  }
}

dependencies {

  // Kotlin Coroutines
  implementation(Libraries.coroutinesCore)
  implementation(Libraries.coroutinesAndroid)

  // Networking
  implementation(Libraries.retrofit)
  implementation(Libraries.gson)

  implementation(Libraries.javaInject)
  //Room
  implementation(Libraries.room)
  kapt(Libraries.room_compile)
  implementation(Libraries.room_ktx)

  // Project Modules
  implementation(project(Config.Modules.domain))
}