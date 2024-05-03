plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.animationapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.animationapp"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures{
        viewBinding = true
        dataBinding = true
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
    buildToolsVersion = "34.0.0"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //noinspection UseTomlInstead
    implementation("com.airbnb.android:lottie:4.1.0")
    //noinspection UseTomlInstead

    implementation(platform("io.github.jan-tennert.supabase:bom:2.1.0"))
    //noinspection UseTomlInstead

    implementation("io.github.jan-tennert.supabase:postgrest-kt")
    //noinspection UseTomlInstead

    implementation("io.github.jan-tennert.supabase:gotrue-kt")
    //noinspection UseTomlInstead

    implementation("io.github.jan-tennert.supabase:storage-kt")

    //noinspection UseTomlInstead
    implementation("io.github.jan-tennert.supabase:realtime-kt")
    implementation("io.ktor:ktor-client-okhttp:2.3.7")
    implementation("com.google.android.gms:play-services-auth:20.7.0")
    implementation ("com.yandex.android:maps.mobile:4.4.0-full")
    implementation("io.ktor:ktor-client-logging:2.3.8")
}