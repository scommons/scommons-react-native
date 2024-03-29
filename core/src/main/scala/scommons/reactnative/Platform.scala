package scommons.reactnative

sealed trait Platform

/** @see https://facebook.github.io/react-native/docs/platform-specific-code
  */
object Platform {
  
  def OS: Platform = raw.Platform.OS match {
    case "ios" => ios
    case "android" => android
    case "web" => web
  }
  
  def select[T](f: Platform => T): T = f(OS)
  
  case object ios extends Platform
  case object android extends Platform
  case object web extends Platform
}
