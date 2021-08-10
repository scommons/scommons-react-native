package scommons.reactnative.app

import org.scalatest.BeforeAndAfterAll
import scommons.react.test._

class TaskLoggerSpec extends TestSpec
  with TestRendererUtils
  with BeforeAndAfterAll {

  private var currentLogger: String => Unit = _
  
  override protected def beforeAll(): Unit = {
    currentLogger = TaskLogger.logger
  }
  
  override protected def afterAll(): Unit = {
    TaskLogger.logger = currentLogger
  }
  
  it should "not log status if it's empty" in {
    //given
    val logger = mockFunction[String, Unit]
    TaskLogger.logger = logger
    val props = TaskLoggerProps("")
    
    //then
    logger.expects(*).never()

    //when
    testRender(<(TaskLogger())(^.wrapped := props)())
  }
  
  it should "log status if it's non-empty" in {
    //given
    var resultText: String = null
    TaskLogger.logger = { text =>
      resultText = text
    }
    val props = TaskLoggerProps("Test status")
    
    //when
    testRender(<(TaskLogger())(^.wrapped := props)())

    //then
    resultText shouldBe "Test status"
  }
  
  it should "log updated status" in {
    //given
    var initialText: String = null
    TaskLogger.logger = { text =>
      initialText = text
    }
    val renderer = createTestRenderer(<(TaskLogger())(
      ^.wrapped := TaskLoggerProps("Initial status")
    )())
    initialText shouldBe "Initial status"

    var resultText: String = null
    TaskLogger.logger = { text =>
      resultText = text
    }

    //when
    TestRenderer.act { () =>
      renderer.update(<(TaskLogger())(
        ^.wrapped := TaskLoggerProps("Updated status")
      )())
    }
    
    //then
    resultText shouldBe "Updated status"
  }

  it should "not log status if it's not changed" in {
    //given
    var initialText: String = null
    TaskLogger.logger = { text =>
      initialText = text
    }
    val renderer = createTestRenderer(<(TaskLogger())(
      ^.wrapped := TaskLoggerProps("Test status")
    )())
    initialText shouldBe "Test status"

    var resultText: String = null
    TaskLogger.logger = { text =>
      resultText = text
    }
    
    //when
    TestRenderer.act { () =>
      renderer.update(<(TaskLogger())(
        ^.wrapped := TaskLoggerProps("Test status")
      )())
    }
    
    //then
    resultText shouldBe null
  }
}
