package definitions

import common.TestLibs
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt._
import scommons.sbtplugin.ScommonsPlugin.autoImport._
import scoverage.ScoverageKeys.coverageExcludedPackages

import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

object ReactNativeShowcase extends ScalaJsModule {

  override val id = "scommons-react-native-showcase"

  override val base: File = file("showcase")

  override def definition: Project = super.definition
    .settings(
      skip in publish := true,
      publish := ((): Unit),
      publishLocal := ((): Unit),
      publishM2 := ((): Unit),

      coverageExcludedPackages :=
        "showcase.app.ShowcaseApp" +
          ";showcase.app.ShowcaseActions" +
          ";showcase.api.task.DemoTaskApi",

      scalaJSUseMainModuleInitializer := false,
      webpackBundlingMode := BundlingMode.LibraryOnly(),

      scommonsResourcesFileFilter := scommonsResourcesFileFilter.value || "*.ttf",

      webpackConfigFile in Test := Some(
        baseDirectory.value / "src" / "test" / "resources" / "test.webpack.config.js"
      )
    )

  override val internalDependencies: Seq[ClasspathDep[ProjectReference]] = Seq(
    ReactNativeUi.definition,
    Expo.definition,
    ReactNativeTest.definition % "test"
  )

  override val superRepoProjectsDependencies: Seq[(String, String, Option[String])] = Seq(
    ("scommons-react", "scommons-react-test-dom", Some("test"))
  )

  override val runtimeDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Nil)

  override val testDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq(
    TestLibs.scommonsReactTestDom.value
  ).map(_ % "test"))
}
