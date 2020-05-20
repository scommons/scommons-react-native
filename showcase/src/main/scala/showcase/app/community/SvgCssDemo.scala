package showcase.app.community

import scommons.react._
import scommons.reactnative._
import scommons.reactnative.svg._

/** @see https://github.com/react-native-community/react-native-svg#css-support-1
  */
object SvgCssDemo extends FunctionComponent[Unit] {

  private[community] val xml =
    """<svg viewBox="0 0 32 32">
      |  <style>
      |    .red {
      |      fill: #ff0000;
      |    }
      |  </style>
      |  <rect class="red" x="0" y="0" width="32" height="32" />
      |</svg>
      |""".stripMargin
  
  protected def render(props: Props): ReactElement = {
    <.View()(
      <.SvgCss(^.xml := xml, ^.width := 32, ^.height := 32)()
    )
  }
}
