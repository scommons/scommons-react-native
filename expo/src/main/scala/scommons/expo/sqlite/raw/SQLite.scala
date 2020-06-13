package scommons.expo.sqlite.raw

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/** @see https://docs.expo.io/versions/latest/sdk/sqlite/
  * @see https://www.w3.org/TR/webdatabase/
  * @see https://github.com/nolanlawson/node-websql/
  */
@js.native
@JSImport("expo-sqlite", JSImport.Namespace)
object SQLite extends js.Object {
  
  def openDatabase(name: String): SQLiteDatabase = js.native
}

@js.native
trait SQLiteDatabase extends js.Object {

  def transaction(callback: js.Function1[SQLiteTransaction, Unit],
                  error: js.Function1[js.Error, Unit],
                  success: js.Function0[Unit]): Unit = js.native
}

@js.native
trait SQLiteTransaction extends js.Object {

  def executeSql(sqlStatement: String,
                 arguments: js.Array[js.Any],
                 success: js.Function2[SQLiteTransaction, SQLiteResultSet, Unit],
                 error: js.Function2[SQLiteTransaction, js.Error, Boolean]): Unit = js.native
}

@js.native
trait SQLiteResultSet extends js.Object {

  val insertId: js.UndefOr[Int]
  val rowsAffected: js.UndefOr[Int]
  val rows: js.UndefOr[SQLiteResultSetRows]
}

@js.native
trait SQLiteResultSetRows extends js.Object {

  val _array: js.Array[js.Object]
}
