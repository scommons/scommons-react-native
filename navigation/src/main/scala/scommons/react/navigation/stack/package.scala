package scommons.react.navigation

import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._
import scommons.react.ReactClass

import scala.scalajs.js

package object stack {

  type ScreenOptions = stack.raw.ScreenOptions
  
  def createStackNavigator(): stack.raw.StackNavigator =
    stack.raw.ReactNavigationStack.createStackNavigator()
  
  object StackNavigatorVirtualDOMAttributes {

    import VirtualDOMAttributes.Type._

    case class ScreenComponentAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: ReactClass): Attribute[ReactClass] = Attribute(name, value, AS_IS)
    }
    
    type DynamicScreenOptions = js.Function1[NavigationProps, ScreenOptions]
    
    case class ScreenOptionsAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: ScreenOptions): Attribute[ScreenOptions] = Attribute(name, value, AS_IS)
      def :=(value: DynamicScreenOptions): Attribute[DynamicScreenOptions] = Attribute(name, value, AS_IS)
    }
    case class ScreenParamsAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: js.Object): Attribute[js.Object] = Attribute(name, value, AS_IS)
    }
  }

  implicit class StackNavigatorVirtualDOMAttributes(attributes: VirtualDOMAttributes) {

    import StackNavigatorVirtualDOMAttributes._

    //Navigator
    lazy val initialRouteName = StringAttributeSpec("initialRouteName")
    lazy val screenOptions = ScreenOptionsAttributeSpec("screenOptions")
    
    //Screen
    lazy val component = ScreenComponentAttributeSpec("component")
    lazy val options = ScreenOptionsAttributeSpec("options")
    lazy val initialParams = ScreenParamsAttributeSpec("initialParams")
  }

}
