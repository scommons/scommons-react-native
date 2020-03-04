package scommons.reactnative.app

import org.scalatest.BeforeAndAfterAll
import scommons.react.test.TestSpec
import scommons.react.test.raw.TestRenderer
import scommons.react.test.util.TestRendererUtils

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
    val logger = mockFunction[String, Unit]
    TaskLogger.logger = logger
    val props = TaskLoggerProps("Test status")
    
    //then
    logger.expects("Test status")

    //when
    testRender(<(TaskLogger())(^.wrapped := props)())
  }
  
  it should "log updated status" in {
    //given
    val logger = mockFunction[String, Unit]
    TaskLogger.logger = logger
    logger.expects("Initial status")
    
    val renderer = createTestRenderer(<(TaskLogger())(
      ^.wrapped := TaskLoggerProps("Initial status")
    )())
    
    //then
    logger.expects("Updated status")

    //when
    TestRenderer.act { () =>
      renderer.update(<(TaskLogger())(
        ^.wrapped := TaskLoggerProps("Updated status")
      )())
    }
  }

  it should "not log status if it's not changed" in {
    //given
    val logger = mockFunction[String, Unit]
    TaskLogger.logger = logger
    
    //then
    logger.expects("Test status").once()
    
    val renderer = createTestRenderer(<(TaskLogger())(
      ^.wrapped := TaskLoggerProps("Test status")
    )())
    
    //when
    TestRenderer.act { () =>
      renderer.update(<(TaskLogger())(
        ^.wrapped := TaskLoggerProps("Test status")
      )())
    }
  }
}
