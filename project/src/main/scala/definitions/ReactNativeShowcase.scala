package definitions

import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt._
import scommons.sbtplugin.project.CommonModule.ideExcludedDirectories

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

      scalaJSUseMainModuleInitializer := false,
      webpackBundlingMode := BundlingMode.LibraryOnly(),

      webpackConfigFile in Test := Some(
        baseDirectory.value / "src" / "test" / "resources" / "test.webpack.config.js"
      ),

      ideExcludedDirectories ++= {
        val base = baseDirectory.value
        List(
          base / ".expo"
        )
      }
    )

  override val internalDependencies: Seq[ClasspathDep[ProjectReference]] = Seq(
    ReactNativeCore.definition,
    ReactNativeTest.definition % "test"
  )

  override val superRepoProjectsDependencies: Seq[(String, String, Option[String])] = Nil

  override val runtimeDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Nil)

  override val testDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Nil)
}
