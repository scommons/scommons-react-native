package definitions

import org.scalajs.sbtplugin.ScalaJSPlugin
import sbt._
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin
import scommons.sbtplugin.project.CommonMobileModule

trait ScalaJsModule extends ReactNativeModule {

  override def definition: Project = {
    super.definition
      .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
      .settings(CommonMobileModule.settings: _*)
  }
}
