package scommons.reactnative

sealed trait Platform

object Platform {
  
  def OS: Platform = raw.Platform.OS match {
    case "ios" => ios
    case "android" => android
  }
  
  def select[T](f: Platform => T): T = f(OS)
  
  case object ios extends Platform
  case object android extends Platform
}
