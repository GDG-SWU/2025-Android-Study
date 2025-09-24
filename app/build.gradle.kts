plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //id("kotlin-android-extensions") //Kotlin Extensions를 사용하기 위해 추가
}

android {
    namespace = "com.example.a2025_android_study"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.a2025_android_study"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    //ViewBinding을 사용하기 위해 넣어야 하는 코드
    buildFeatures {
        viewBinding = true
    }

    //DataBinding을 사용하기 위해 넣어야 하는 코드
    //buildFeatures {
    //    dataBinding = true
    //}
}

dependencies {

    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.core:core:1.12.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}