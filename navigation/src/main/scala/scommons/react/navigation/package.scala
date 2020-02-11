package scommons.react

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements.ReactClassElementSpec
import io.github.shogowada.scalajs.reactjs.VirtualDOM._

package object navigation {

  type NavigationProps = navigation.raw.NavigationProps
  
  implicit class ReactNavigationVirtualDOMElements(elements: VirtualDOMElements) {
    lazy val NavigationContainer: ReactClassElementSpec = elements(navigation.raw.NavigationContainer)
  }

}
