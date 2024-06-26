import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

group = "com.zhelenskiy.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)

            packageName = "file-associations-demo"
            packageVersion = "1.0.0"

            macOS.fileAssociation(
                mimeType = "text/kotlin",
                extension = "kott",
                description = "Kotlin Source File0",
                iconFile = project.file("Kotlin_icon_big.icns"),
            )

            windows.fileAssociation(
                mimeType = "text/kotlin",
                extension = "kott",
                description = "Kotlin Source File0",
                iconFile = project.file("Kotlin_icon_big.ico"),
            )

            linux.fileAssociation(
                mimeType = "text/kotlin",
                extension = "kott",
                description = "Kotlin Source File0",
                iconFile = project.file("Kotlin_icon_big.png"),
            )

            fileAssociation(
                mimeType = "text/kotlin",
                extension = "kot",
                description = "Kotlin Source File1",
                macOSIconFile = project.file("Kotlin_icon_big.icns"),
                windowsIconFile = project.file("Kotlin_icon_big.ico"),
                linuxIconFile = project.file("Kotlin_icon_big.png"),
            )

            fileAssociation(
                mimeType = "text/kotlin",
                extension = "kottt",
                description = "Kotlin Source File2",
            )
        }
    }
}
