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

      npmDevDependencies in Compile ++= Seq(
        "file-loader" -> "1.1.4"
      )
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
