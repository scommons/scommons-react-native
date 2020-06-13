package scommons.expo.sqlite

import scala.concurrent.{Future, Promise}
import scala.util.Try

trait SQLite {

  def openDatabase(name: String): Future[Database] = {
    val p = Promise[Database]()
    
    Try {
      new Database(raw.SQLite.openDatabase(name))
    }.fold(
      error => p.failure(error),
      res => p.success(res)
    )
    
    p.future
  }
}

object SQLite extends SQLite
