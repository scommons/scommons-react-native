package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements.ReactClassElementSpec
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

/** @see https://github.com/react-native-community/react-native-svg
  */
package object svg {

  implicit class SvgVirtualDOMElements(elements: VirtualDOMElements) {
    lazy val SvgXml: ReactClassElementSpec = elements(svg.raw.SvgXml)
  }

  implicit class SvgVirtualDOMAttributes(attributes: VirtualDOMAttributes) {

    lazy val xml = StringAttributeSpec("xml")
  }
}
