package common

import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._
import sbt._
import scommons.sbtplugin.project.CommonLibs

object Libs extends CommonLibs {

  val scommonsApiVersion = "0.7.0"
  val scommonsReactVersion = "1.0.0-SNAPSHOT"
  val scommonsNodejsVersion = "0.7.0"
  val scommonsWebSqlVersion = "0.7.1"

  lazy val scommonsApiXhr = Def.setting("org.scommons.api" %%% "scommons-api-xhr" % scommonsApiVersion)
  lazy val scommonsReactCore = Def.setting("org.scommons.react" %%% "scommons-react-core" % scommonsReactVersion)
  lazy val scommonsReactRedux = Def.setting("org.scommons.react" %%% "scommons-react-redux" % scommonsReactVersion)
  lazy val scommonsWebSqlCore = Def.setting("org.scommons.websql" %%% "scommons-websql-core" % scommonsWebSqlVersion)
}
