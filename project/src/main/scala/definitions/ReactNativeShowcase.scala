package definitions

import sbt.Keys._
import sbt._
import scommons.sbtplugin.ScommonsPlugin.autoImport._
import scoverage.ScoverageKeys.coverageExcludedPackages

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

      // we substitute references to react-native modules with our custom mocks during test
      scommonsNodeJsTestLibs := Seq("scommons.reactnative.aliases.js")
    )

  override val internalDependencies: Seq[ClasspathDep[ProjectReference]] = Seq(
    ReactNativeUi.definition,
    ReactNativeTest.definition % "test"
  )

  override val superRepoProjectsDependencies: Seq[(String, String, Option[String])] = Nil

  override val runtimeDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Nil)

  override val testDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Nil)
}
