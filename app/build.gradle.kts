import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "me.vikas.experimentLab"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "me.vikas.experimentLab"
        minSdk = 24
        targetSdk = 36
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
        compose = true
    }

    renameApkFile()
    println("We Are Practicing PR . . .")

}

dependencies {

    implementation(project(":feature-coroutine"))
    implementation(project(":feature-flow"))

    // Core Dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    // Unit Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}

fun renameApkFile(){
    try {
        tasks.register("renameApk") {
            dependsOn("assembleDebug")
            doLast {
                println("Rename APK task Executed.")
                val apkDir = layout.buildDirectory.dir("outputs/apk/debug").get().asFile

                val apk = apkDir.listFiles()?.firstOrNull {
                    it.extension == "apk"
                }

                println("APK null or not = ${(apk == null)}")

                if (apk != null) {
                    val appName = "Experiment_Lab"
                    val buildType = "debug"
                    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
                    val timestamp = LocalDateTime.now().format(formatter)
                    val newFileName = "${appName}_${timestamp}_$buildType.apk"
                    val newFile = File(apk.parentFile, newFileName)
                    apk.renameTo(newFile)
                    println("Renamed to ${newFile.name}")
                } else {
                    println("Apk Not Found.")
                }

            }
        }
    }catch (ex : Exception){
        println()
    }
}