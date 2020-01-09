package definitions

import common.Libs
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

  override val testDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Nil)
}
