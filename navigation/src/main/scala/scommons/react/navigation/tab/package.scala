package scommons.react.navigation

import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

package object tab {

  type TabScreenOptions = tab.raw.TabScreenOptions
  
  def createBottomTabNavigator(): tab.raw.TabNavigator =
    tab.raw.ReactNavigationBottomTabs.createBottomTabNavigator()
  
  object TabNavigatorVirtualDOMAttributes {

    import VirtualDOMAttributes.Type._

    case class TabBarOptionsAttributeSpec(name: String) extends AttributeSpec {
      def :=(value: TabBarOptions): Attribute[TabBarOptions] = Attribute(name, value, AS_IS)
    }
  }

  implicit class TabNavigatorVirtualDOMAttributes(attributes: VirtualDOMAttributes) {

    import TabNavigatorVirtualDOMAttributes._

    lazy val tabLazy = BooleanAttributeSpec("lazy")
    lazy val tabBarOptions = TabBarOptionsAttributeSpec("tabBarOptions")
  }

}
