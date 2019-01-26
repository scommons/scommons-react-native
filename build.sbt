import definitions._
import scommons.sbtplugin.project.CommonModule
import scommons.sbtplugin.project.CommonModule.ideExcludedDirectories

lazy val `scommons-react-native` = (project in file("."))
  .settings(CommonModule.settings: _*)
  .settings(ReactNativeModule.settings: _*)
  .settings(
    skip in publish := true,
    publish := (),
    publishM2 := (),
    publishLocal := ()
  )
  .settings(
    ideExcludedDirectories += baseDirectory.value / "docs" / "_site"
  )
  .aggregate(
  `scommons-react-native-core`,
  `scommons-react-native-test`,
  `scommons-react-native-showcase`
)

lazy val `scommons-react-native-core` = ReactNativeCore.definition
lazy val `scommons-react-native-test` = ReactNativeTest.definition
lazy val `scommons-react-native-showcase` = ReactNativeShowcase.definition
