package scommons.react

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements._
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

import scala.scalajs.js

package object navigation extends ReactNavigation {

  type NavigationProps = navigation.raw.NavigationProps
  type NavigatorScreenOptions = navigation.raw.NavigatorScreenOptions
  
  protected lazy val native: navigation.raw.ReactNavigation = navigation.raw.ReactNavigation
  
  implicit class ReactNavigationVirtualDOMElements(elements: VirtualDOMElements) {
    lazy val NavigationContainer: ReactClassElementSpec = elements(native.NavigationContainer)
  }

  object NavigatorVirtualDOMAttributes {

    import VirtualDOMAttributes.Type._

    case class ScreenComponentAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: ReactClass): Attribute[ReactClass] = Attribute(name, value, AS_IS)
    }

    type DynamicScreenOptions = js.Function1[NavigationProps, NavigatorScreenOptions]

    case class ScreenOptionsAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: NavigatorScreenOptions): Attribute[NavigatorScreenOptions] = Attribute(name, value, AS_IS)
      def :=(value: DynamicScreenOptions): Attribute[DynamicScreenOptions] = Attribute(name, value, AS_IS)
    }
    case class ScreenParamsAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: js.Object): Attribute[js.Object] = Attribute(name, value, AS_IS)
    }
  }

  implicit class NavigatorVirtualDOMAttributes(attributes: VirtualDOMAttributes) {

    import NavigatorVirtualDOMAttributes._

    //Navigator
    lazy val initialRouteName = StringAttributeSpec("initialRouteName")
    lazy val screenOptions = ScreenOptionsAttributeSpec("screenOptions")

    //Screen
    lazy val component = ScreenComponentAttributeSpec("component")
    lazy val options = ScreenOptionsAttributeSpec("options")
    lazy val initialParams = ScreenParamsAttributeSpec("initialParams")
  }

}
