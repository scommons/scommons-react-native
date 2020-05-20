package definitions

import common.{Libs, TestLibs}
import sbt.Keys._
import sbt._
import scoverage.ScoverageKeys.coverageExcludedPackages

import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

object ReactNativeUi extends ScalaJsModule {

  override val id: String = "scommons-react-native-ui"

  override val base: File = file("ui")

  override def definition: Project = super.definition
    .settings(
      description := "Scala.js facades and APIs for common react-native UI",

      coverageExcludedPackages :=
        "scommons.reactnative.app.BaseStateAndRouteController",

      webpackConfigFile in Test := Some(
        baseDirectory.value / "src" / "test" / "resources" / "test.webpack.config.js"
      )
    )

  override val internalDependencies: Seq[ClasspathDep[ProjectReference]] = Seq(
    ReactNativeCore.definition,
    ReactNativeCommunity.definition,
    ReactNavigation.definition,
    Expo.definition,
    ReactNativeTest.definition % "test"
  )

  override val superRepoProjectsDependencies: Seq[(String, String, Option[String])] = Seq(
    ("scommons-api", "scommons-api-dom", None),
    ("scommons-react", "scommons-react-redux", None),

    ("scommons-react", "scommons-react-test-dom", Some("test"))
  )

  override val runtimeDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq(
    Libs.scommonsApiDom.value,
    Libs.scommonsReactRedux.value
  ))

  override val testDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq(
    TestLibs.scommonsReactTestDom.value
  ).map(_ % "test"))
}
