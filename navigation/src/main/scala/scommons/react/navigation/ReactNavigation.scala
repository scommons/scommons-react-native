package scommons.react.navigation

import io.github.shogowada.statictags.Attribute
import scommons.react._
import scommons.reactnative._

import scala.scalajs.js

trait ReactNavigation {

  protected def native: raw.ReactNavigation

  def getFocusedRouteNameFromRoute(route: raw.Route): Option[String] = {
    val routeName = native.getFocusedRouteNameFromRoute(route)
    if (js.isUndefined(routeName) || routeName == null) None
    else Some(routeName.asInstanceOf[String])
  }

  @inline
  def useIsFocused(): Boolean = native.useIsFocused()
  
  @inline
  def useTheme(): Theme = native.useTheme()

  def themeStyle(light: Style, dark: Style)(implicit theme: Theme): Attribute[js.Any] = {
    val style =
      if (theme.dark) {
        ^.rnStyle := js.Array(light, dark)
      }
      else {
        ^.rnStyle := light
      }
    
    style.asInstanceOf[Attribute[js.Any]]
  }
  
  def themeTextStyle(implicit theme: Theme): TextStyle = themeStyles.getOrElse(theme, {
    val style = new TextStyle {
      override val color = theme.colors.text
    }
    themeStyles = themeStyles.updated(theme, style)
    style
  })
  
  private var themeStyles: Map[Theme, TextStyle] = Map.empty[Theme, TextStyle]
}
