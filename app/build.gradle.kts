plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.chatapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.chatapp"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }

    packaging {
        resources {
            resources.excludes.add("META-INF/NOTICE.md")
            resources.excludes.add("META-INF/LICENSE.md")
            resources.excludes.add("META-INF/INDEX.LIST")
            resources.excludes.add("META-INF/DEPENDENCIES")
            resources.excludes.add("META-INF/io.netty.versions.properties")

            /*pickFirsts += ['META-INF/LICENSE.txt']
            excludes += ['META-INF/NOTICE.md', 'META-INF/LICENSE.md', 'META-INF/INDEX.LIST', 'META-INF/DEPENDENCIES', 'META-INF/io.netty.versions.properties']*/
        }
        //resources.excludes.add("META-INF/*")
    }


}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.activity)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.camera.core)
    implementation(libs.camera.lifecycle)
    implementation(libs.camera.view)
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-messaging")
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation(libs.google.auth.library.oauth2.http)
    implementation("com.google.firebase:firebase-analytics:21.3.0")


    // Customs
    implementation("com.makeramen:roundedimageview:2.3.0")
}