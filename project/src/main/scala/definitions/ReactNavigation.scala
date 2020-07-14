package definitions

import common.TestLibs
import sbt.Keys._
import sbt._
import scoverage.ScoverageKeys.coverageExcludedPackages

object ReactNavigation extends ScalaJsModule {

  override val id: String = "scommons-react-navigation"

  override val base: File = file("navigation")

  override def definition: Project = super.definition
    .settings(
      description := "Scala.js facades for react-navigation Components and Api",

      coverageExcludedPackages :=
        "scommons.react.navigation.*raw" +
          ";scommons.react.navigation.tab.TabBarOptions"
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
