import definitions._
import scommons.sbtplugin.project.CommonModule

lazy val `scommons-react-native` = (project in file("."))
  .settings(CommonModule.settings: _*)
  .settings(ReactNativeModule.settings: _*)
  .settings(
    skip in publish := true,
    publish := (),
    publishM2 := ()
  )
  .settings(
    ideaExcludeFolders += s"${baseDirectory.value}/docs/_site"
  )
  .aggregate(
  `scommons-react-native-core`,
  `scommons-react-native-test`
)

lazy val `scommons-react-native-core` = ReactNativeCore.definition
lazy val `scommons-react-native-test` = ReactNativeTest.definition
