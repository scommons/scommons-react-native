package common

import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt._
import scommons.sbtplugin.project.CommonLibs

object Libs extends CommonLibs {

  val scommonsReactVersion = "0.1.0-SNAPSHOT"

  lazy val scommonsReactCore = Def.setting("org.scommons.react" %%% "scommons-react-core" % scommonsReactVersion)
}
