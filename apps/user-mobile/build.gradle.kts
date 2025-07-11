plugins {
  id("com.android.application") version "8.0.2"
  id("org.jetbrains.kotlin.android") version "1.9.0"
}

android {
  namespace = "com.naughtybell.app"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.naughtybell.app"
    minSdk = 23
    targetSdk = 34
    versionCode = 1
    versionName = "0.1.0"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.0"
  }
}

dependencies {
  implementation("androidx.core:core-ktx:1.12.0")
  implementation("androidx.activity:activity-compose:1.8.2")
  implementation("androidx.compose.ui:ui:1.5.0")
  implementation("androidx.compose.ui:ui-tooling-preview:1.5.0")
  implementation("androidx.compose.material3:material3:1.1.2")
  debugImplementation("androidx.compose.ui:ui-tooling:1.5.0")
} 