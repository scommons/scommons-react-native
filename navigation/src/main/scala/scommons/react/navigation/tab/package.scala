package scommons.react.navigation

import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._
import scommons.react._

import scala.scalajs.js

package object tab {

  type TabScreenOptions = tab.raw.TabScreenOptions
  type TabBarIconParams = tab.raw.TabBarIconParams
  type TabBarLabelParams = tab.raw.TabBarLabelParams
  
  def createBottomTabNavigator(): tab.raw.TabNavigator =
    tab.raw.ReactNavigationBottomTabs.createBottomTabNavigator()
  
  object TabNavigatorVirtualDOMAttributes {

    import VirtualDOMAttributes.Type._

    type TabBarIconFn = js.Function1[TabBarIconParams, ReactElement]
    
    case class TabBarIconAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: TabBarIconFn): Attribute[TabBarIconFn] = Attribute(name, value, AS_IS)
    }
    
    type TabBarLabelFn = js.Function1[TabBarLabelParams, ReactElement]
    
    case class TabBarLabelAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: String): Attribute[String] = Attribute(name, value, AS_IS)
      def :=(value: TabBarLabelFn): Attribute[TabBarLabelFn] = Attribute(name, value, AS_IS)
    }
    
    type TabBarButtonFn = js.Function1[js.Dynamic, ReactElement]
    
    case class TabBarButtonAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: TabBarButtonFn): Attribute[TabBarButtonFn] = Attribute(name, value, AS_IS)
    }
    
    case class TabBarOptionsAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: TabBarOptions): Attribute[TabBarOptions] = Attribute(name, value, AS_IS)
    }
  }

  implicit class TabNavigatorVirtualDOMAttributes(attributes: VirtualDOMAttributes) {

    import TabNavigatorVirtualDOMAttributes._

    lazy val tabLazy = BooleanAttributeSpec("lazy")
    lazy val unmountOnBlur = BooleanAttributeSpec("unmountOnBlur")
    
    lazy val tabBarIcon = TabBarIconAttributeSpec("tabBarIcon")
    lazy val tabBarLabel = TabBarLabelAttributeSpec("tabBarLabel")
    lazy val tabBarButton = TabBarButtonAttributeSpec("tabBarButton")
    lazy val tabBarAccessibilityLabel = StringAttributeSpec("tabBarAccessibilityLabel")
    
    lazy val tabBarOptions = TabBarOptionsAttributeSpec("tabBarOptions")
  }

}
