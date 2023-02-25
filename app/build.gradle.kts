plugins {
    application
}

repositories {
    mavenCentral()
    flatDir {
        dirs("libs")
    }
}

dependencies {
    implementation(":controlsfx-8.40.14")
    implementation(":jfoenix-8.0.10")
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit Jupiter test framework
            useJUnitJupiter("5.7.2")
        }
    }
}

application {
    // Define the main class for the application.
    mainClass.set("carsFX.Principale")
}
