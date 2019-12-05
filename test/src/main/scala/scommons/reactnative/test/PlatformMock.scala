package scommons.reactnative.test

import scommons.reactnative._
import scommons.reactnative.raw.{Platform => NativePlatform}

import scala.scalajs.js

object PlatformMock {

  def use(p: Platform): Unit = {
    NativePlatform.asInstanceOf[js.Dynamic].updateDynamic("OS")(s"$p")
  }
}
