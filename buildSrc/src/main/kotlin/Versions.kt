import kotlin.String

/**
 * Generated by https://github.com/jmfayard/buildSrcVersions
 *
 * Find which updates are available by running
 *     `$ ./gradlew buildSrcVersions`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version.
 */
object Versions {
  const val annotation: String = "1.1.0"

  const val appcompat: String = "1.1.0"

  const val constraintlayout: String = "1.1.3"

  const val androidx_lifecycle: String = "2.0.0" // available: "2.1.0"

  const val recyclerview: String = "1.0.0"

  const val aapt2: String = "3.5.1-5435860"

  const val com_android_tools_build_gradle: String = "3.5.1"

  const val lint_gradle: String = "26.5.1"

  const val android_maven_gradle_plugin: String = "1.4.1" // available: "2.1"

  const val gson: String = "2.8.5" // available: "2.8.6"

  const val com_jakewharton_rxbinding3: String = "3.0.0"

  const val timber: String = "4.7.1"

  const val gradle_bintray_plugin: String = "1.8.4"

  const val ktlint: String = "0.34.2"

  const val com_squareup_retrofit2: String = "2.6.1" // available: "2.6.2"

  const val buildsrcversions: String = "0.4.2"

  const val rxandroid: String = "2.1.1"

  const val rxjava: String = "2.2.12" // available: "2.2.13"

  const val junit: String = "4.12"

  const val dokka_android_gradle_plugin: String = "0.9.18"

  const val org_jetbrains_kotlin: String = "1.3.50"

  const val org_koin: String = "2.0.1"

  /**
   *
   * See issue 19: How to update Gradle itself?
   * https://github.com/jmfayard/buildSrcVersions/issues/19
   */
  const val gradleLatestVersion: String = "5.6.2"

  const val gradleCurrentVersion: String = "5.6.2"
}