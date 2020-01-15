package definitions

import common.{Libs, TestLibs}
import sbt.Keys._
import sbt._
import scoverage.ScoverageKeys.coverageExcludedPackages

import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

object ReactNavigation extends ScalaJsModule {

  override val id: String = "scommons-react-navigation"

  override val base: File = file("navigation")

  override def definition: Project = super.definition
    .settings(
      description := "Scala.js facades for react-navigation Components and Api",

      requireJsDomEnv in Test := false,
      
      coverageExcludedPackages :=
        "scommons.react.navigation.raw" +
        ";scommons.react.navigation.stack.raw" +
        ";scommons.react.navigation.stack.*Config"
    )

  override val internalDependencies: Seq[ClasspathDep[ProjectReference]] = Nil

  override val superRepoProjectsDependencies: Seq[(String, String, Option[String])] = Seq(
    ("scommons-react", "scommons-react-core", None)
  )

  override val runtimeDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq(
    Libs.scommonsReactCore.value
  ))

  override val testDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq(
    TestLibs.scalaTestJs.value,
    TestLibs.scalaMockJs.value
  ).map(_ % "test"))
}
