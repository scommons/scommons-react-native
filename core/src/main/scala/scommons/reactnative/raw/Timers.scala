package scommons.reactnative.raw

import scala.scalajs.js

/**
  * https://facebook.github.io/react-native/docs/timers
  */
@js.native
trait Timers extends js.Object {

  /**
    * Schedules repeated execution of callback every delay milliseconds.
    * Returns a Timeout for use with clearInterval().
    */
  def setInterval(callback: js.Function0[Any], delay: Double): Timeout = js.native

  /**
    * Schedules execution of a one-time callback after delay milliseconds.
    * Returns a Timeout for use with clearTimeout().
    */
  def setTimeout(callback: js.Function0[Any], delay: Double): Timeout = js.native

  /**
    * Cancels a Timeout object created by setInterval().
    */
  def clearInterval(timeout: Timeout): Unit = js.native

  /**
    * Cancels a Timeout object created by setTimeout().
    */
  def clearTimeout(timeout: Timeout): Unit = js.native
}

@js.native
trait Timeout extends js.Object
