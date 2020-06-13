package scommons.expo.sqlite

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

class Database(db: raw.SQLiteDatabase) {

  def transaction(callback: Transaction => Unit): Future[Unit] = {
    val p = Promise[Unit]()
    
    db.transaction({ tx =>
      callback(new Transaction(tx))
    }, { error =>
      p.failure(js.JavaScriptException(error))
    }, { () =>
      p.success(())
    })
    
    p.future
  }
}
