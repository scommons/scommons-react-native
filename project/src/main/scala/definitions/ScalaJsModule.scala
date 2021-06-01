package definitions

import org.scalajs.sbtplugin.ScalaJSPlugin
import sbt.Keys._
import sbt._
import scommons.sbtplugin.project.CommonMobileModule

import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

trait ScalaJsModule extends ReactNativeModule {

  override def definition: Project = {
    super.definition
      .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
      .settings(CommonMobileModule.settings: _*)
      .settings(
        version in webpack := "4.29.0"
      )
  }
}
