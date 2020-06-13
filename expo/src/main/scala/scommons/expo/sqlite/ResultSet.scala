package scommons.expo.sqlite

import scala.scalajs.js

class ResultSet(underlying: raw.SQLiteResultSet) {

  lazy val insertId: Option[Int] = underlying.insertId.toOption
  lazy val rowsAffected: Int = underlying.rowsAffected.getOrElse(0)
  lazy val rows: List[js.Object] = underlying.rows.map(_._array.toList).getOrElse(Nil)
}
