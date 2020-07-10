package scommons.expo.sqlite.raw

import scommons.websql.raw.WebSQLDatabase

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/** @see https://docs.expo.io/versions/latest/sdk/sqlite/
  * @see https://www.w3.org/TR/webdatabase/
  * @see https://github.com/nolanlawson/node-websql/
  */
@js.native
@JSImport("expo-sqlite", JSImport.Namespace)
object SQLite extends js.Object {
  
  def openDatabase(name: String): WebSQLDatabase = js.native
}
