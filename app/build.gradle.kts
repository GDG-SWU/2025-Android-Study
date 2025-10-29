plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
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

    buildFeatures{
        viewBinding = true
    }
    buildFeatures{
        dataBinding = true
    }
}

dependencies {

<<<<<<< HEAD
    implementation ("androidx.core:core-ktx:1.12.0") // 둘 중 하나만 남김
    implementation ("androidx.core:core:1.12.0")    // 아래쪽 블록에만 있던 내용
=======
    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.core:core:1.12.0")
>>>>>>> 6b7099508abe1323f4e8d93ef651b7594d098007
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    implementation("androidx.databinding:databinding-runtime:8.13.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    implementation("androidx.fragment:fragment-ktx:1.6.2")
}