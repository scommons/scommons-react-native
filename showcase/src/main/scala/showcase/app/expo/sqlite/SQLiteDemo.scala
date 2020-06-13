package showcase.app.expo.sqlite

import scommons.expo.sqlite._
import scommons.react._
import scommons.react.hooks._
import scommons.reactnative._

import scala.collection.mutable
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.control.NonFatal

/** @see https://docs.expo.io/versions/latest/sdk/sqlite/
  * @see https://www.w3.org/TR/webdatabase/
  * @see https://github.com/nolanlawson/node-websql/
  */
object SQLiteDemo extends FunctionComponent[Unit] {

  protected def render(props: Props): ReactElement = {
    val (messages, setMessages) = useState(Seq.empty[String])
    
    useEffect({ () =>
      SQLite.openDatabase("scommons_showcase.db").foreach { db =>
        val msgLog = new mutable.ListBuffer[String]
        
        def println(msg: String): Unit = {
          msgLog += msg
          //Console.println(msg)
        }
        println(s"DB is opened")
        
        def onSuccess(tx: Transaction): Unit = {
          tx.executeSql("select * from emails", Nil, { (_, res) =>
            println(s"select: rows: ${res.rows.size}")
          }, { (_, error) =>
            println(s"select error: $error")
            true //rollback
          })
        }
        
        db.transaction { tx =>
          //tx.executeSql("DROP TABLE IF EXISTS emails")
          tx.executeSql(
            """create table if not exists emails (
              |  id              integer primary key,
              |  email           text not null,
              |  created_at      timestamp without time zone default current_timestamp,
              |  UNIQUE (email)
              |)
              |""".stripMargin
          )
          tx.executeSql(
            "insert into emails (email) values (?)",
            Seq("email1@test.com"),
            { (tx, _) =>
              onSuccess(tx)
            }, { (tx, error) =>
              println(s"insert error: $error")
              onSuccess(tx)
              false //do not rollback
            }
          )
        }.map { _ =>
          println(s"tx is completed")
        }.recover {
          case NonFatal(error) => println(s"tx error: $error")
        }.foreach { _ =>
          setMessages(msgLog.toList)
        }
      }
      ()
    }, Nil)
    
    <.View()(
      <.Text()("DB log:"),
      <.Text()(""),
      messages.map { msg =>
        <.Text()(msg)
      }
    )
  }
}
