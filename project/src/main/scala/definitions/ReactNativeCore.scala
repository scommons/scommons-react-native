package definitions

import common.Libs
import sbt.Keys._
import sbt._
import scoverage.ScoverageKeys.coverageExcludedPackages

import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

object ReactNativeCore extends ScalaJsModule {

  override val id: String = "scommons-react-native-core"

  override val base: File = file("core")

  override def definition: Project = super.definition
    .settings(
      description := "Scala.js facades for React Native (react-native) utilities and components",
      coverageExcludedPackages := "scommons.reactnative",

      npmResolutions in Test := Map(
        "react" -> "16.6.3",
        "react-dom" -> "16.6.3",
        "react-test-renderer" -> "16.6.3"
      )
    )

  override val internalDependencies: Seq[ClasspathDep[ProjectReference]] = Seq(
    ReactNativeTest.definition % "test"
  )

  override val superRepoProjectsDependencies: Seq[(String, String, Option[String])] = Seq(
    ("scommons-react", "scommons-react-core", None)
  )

  override val runtimeDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq(
    Libs.scommonsReactCore.value
  ))

  override val testDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Nil)
}
