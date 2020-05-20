package definitions

import common.{Libs, TestLibs}
import sbt.Keys._
import sbt._
import scoverage.ScoverageKeys.coverageExcludedPackages

import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

object Expo extends ScalaJsModule {

  override val id: String = "scommons-expo"

  override val base: File = file("expo")

  override def definition: Project = super.definition
    .settings(
      description := "Scala.js facades for Expo Components and Api",

      requireJsDomEnv in Test := false,
      
      coverageExcludedPackages := "scommons.expo.*raw"
    )

  override val internalDependencies: Seq[ClasspathDep[ProjectReference]] = Seq(
    ReactNativeCore.definition
  )

  override val superRepoProjectsDependencies: Seq[(String, String, Option[String])] = Nil

  override val runtimeDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Nil)

  override val testDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq(
    TestLibs.scalaTestJs.value,
    TestLibs.scalaMockJs.value
  ).map(_ % "test"))
}
