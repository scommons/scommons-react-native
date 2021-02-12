package definitions

import common.Libs
import sbt.Keys._
import sbt._
import scommons.sbtplugin.ScommonsPlugin.autoImport._
import scoverage.ScoverageKeys.coverageExcludedPackages

object ReactNativeUi extends ScalaJsModule {

  override val id: String = "scommons-react-native-ui"

  override val base: File = file("ui")

  override def definition: Project = super.definition
    .settings(
      description := "Scala.js facades and APIs for common react-native UI",

      coverageExcludedPackages :=
        "scommons.reactnative.app.BaseStateAndRouteController",

      // we substitute references to react-native modules with our custom mocks during test
      scommonsNodeJsTestLibs := Seq("scommons.reactnative.aliases.js")
    )

  override val internalDependencies: Seq[ClasspathDep[ProjectReference]] = Seq(
    ReactNativeCore.definition,
    ReactNativeCommunity.definition,
    ReactNavigation.definition,
    Expo.definition,
    ReactNativeTest.definition % "test"
  )

  override val superRepoProjectsDependencies: Seq[(String, String, Option[String])] = Seq(
    ("scommons-react", "scommons-react-redux", None)
  )

  override val runtimeDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq(
    Libs.scommonsApiXhr.value,
    Libs.scommonsReactRedux.value
  ))

  override val testDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Nil)
}
