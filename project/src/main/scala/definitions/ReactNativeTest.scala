package definitions

import common.{Libs, TestLibs}
import sbt.Keys._
import sbt._
import scoverage.ScoverageKeys.coverageExcludedPackages

import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

object ReactNativeTest extends ScalaJsModule {

  override val id: String = "scommons-react-native-test"

  override val base: File = file("test")

  override def definition: Project = super.definition
    .settings(
      description := "Core Scala.js, React Native (react-native) testing utilities",
      coverageExcludedPackages := "scommons.reactnative.test.raw",

      npmDependencies in Compile ++= Seq(
        "react" -> "16.6.3",
        "react-dom" -> "16.6.3"
      ),
      npmResolutions in Compile := Map(
        "react" -> "16.6.3",
        "react-dom" -> "16.6.3"
      ),
      
      npmResolutions in Test := Map(
        "react" -> "16.6.3",
        "react-dom" -> "16.6.3",
        "react-test-renderer" -> "16.6.3"
      ),
      npmDependencies in Test ++= Seq(
        "react-test-renderer" -> "16.6.3"
      ),

      version in webpack := "3.5.5"
    )

  override val internalDependencies: Seq[ClasspathDep[ProjectReference]] = Nil

  override val superRepoProjectsDependencies: Seq[(String, String, Option[String])] = Seq(
    ("scommons-react", "scommons-react-core", None),
    ("scommons-react", "scommons-react-test", None)
  )

  override val runtimeDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq(
    Libs.scommonsReactCore.value,
    TestLibs.scommonsReactTest.value
  ))

  override val testDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Nil)
}
