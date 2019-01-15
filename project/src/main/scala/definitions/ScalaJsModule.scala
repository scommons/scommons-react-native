package definitions

import org.scalajs.sbtplugin.ScalaJSPlugin
import sbt._
import scommons.sbtplugin.project.CommonClientModule

import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin

trait ScalaJsModule extends ReactNativeModule {

  override def definition: Project = {
    super.definition
      .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
      .settings(CommonClientModule.settings: _*)
  }
}
