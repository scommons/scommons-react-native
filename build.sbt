import definitions._
import scommons.sbtplugin.project.CommonModule
import scommons.sbtplugin.project.CommonModule.ideExcludedDirectories

lazy val `scommons-react-native` = (project in file("."))
  .settings(CommonModule.settings: _*)
  .settings(ReactNativeModule.settings: _*)
  .settings(
    publish / skip := true,
    publish := ((): Unit),
    publishLocal := ((): Unit),
    publishM2 := ((): Unit)
  )
  .settings(
    ideExcludedDirectories += baseDirectory.value / "docs" / "_site"
  )
  .aggregate(
  `scommons-react-native-core`,
  `scommons-react-native-test`,
  `scommons-react-native-community`,
  `scommons-react-navigation`,
  `scommons-expo`,
  `scommons-react-native-ui`,
  `scommons-react-native-showcase`
)

lazy val `scommons-react-native-core` = ReactNativeCore.definition
lazy val `scommons-react-native-test` = ReactNativeTest.definition
lazy val `scommons-react-native-community` = ReactNativeCommunity.definition
lazy val `scommons-react-navigation` = ReactNavigation.definition
lazy val `scommons-expo` = Expo.definition
lazy val `scommons-react-native-ui` = ReactNativeUi.definition
lazy val `scommons-react-native-showcase` = ReactNativeShowcase.definition
