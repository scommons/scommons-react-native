package scommons.reactnative

import scommons.reactnative.Style._

import scala.scalajs.js
import scala.scalajs.js.|

/** @see https://facebook.github.io/react-native/docs/view-style-props
  * @see https://facebook.github.io/react-native/docs/text-style-props
  * @see https://facebook.github.io/react-native/docs/layout-props
  */
trait Style extends js.Object {
  
  val borderBottomRightRadius: js.UndefOr[Int] = js.undefined
  val borderBottomWidth: js.UndefOr[Int] = js.undefined
  val borderColor: js.UndefOr[String] = js.undefined
  val borderLeftColor: js.UndefOr[String] = js.undefined
  val borderLeftWidth: js.UndefOr[Int] = js.undefined
  val borderRadius: js.UndefOr[Int] = js.undefined
  val borderRightWidth: js.UndefOr[Int] = js.undefined
  val borderStyle: js.UndefOr[BorderStyle] = js.undefined
  val borderTopColor: js.UndefOr[String] = js.undefined
  val borderTopLeftRadius: js.UndefOr[Int] = js.undefined
  val borderTopRightRadius: js.UndefOr[Int] = js.undefined
  val borderTopWidth: js.UndefOr[Int] = js.undefined
  val borderWidth: js.UndefOr[Int] = js.undefined
  
  val margin: js.UndefOr[String | Int] = js.undefined
  val marginBottom: js.UndefOr[String | Int] = js.undefined
  val marginEnd: js.UndefOr[String | Int] = js.undefined
  val marginHorizontal: js.UndefOr[String | Int] = js.undefined
  val marginLeft: js.UndefOr[String | Int] = js.undefined
  val marginRight: js.UndefOr[String | Int] = js.undefined
  val marginStart: js.UndefOr[String | Int] = js.undefined
  val marginTop: js.UndefOr[String | Int] = js.undefined
  val marginVertical: js.UndefOr[String | Int] = js.undefined
  
  val padding: js.UndefOr[String | Int] = js.undefined
  val paddingBottom: js.UndefOr[String | Int] = js.undefined
  val paddingEnd: js.UndefOr[String | Int] = js.undefined
  val paddingHorizontal: js.UndefOr[String | Int] = js.undefined
  val paddingLeft: js.UndefOr[String | Int] = js.undefined
  val paddingRight: js.UndefOr[String | Int] = js.undefined
  val paddingStart: js.UndefOr[String | Int] = js.undefined
  val paddingTop: js.UndefOr[String | Int] = js.undefined
  val paddingVertical: js.UndefOr[String | Int] = js.undefined
  
  val shadowColor: js.UndefOr[String] = js.undefined
  val shadowOffset: js.UndefOr[ShadowOffset] = js.undefined
  val shadowOpacity: js.UndefOr[Double] = js.undefined
  val shadowRadius: js.UndefOr[Int] = js.undefined
  
  val backgroundColor: js.UndefOr[String] = js.undefined
  val color: js.UndefOr[String] = js.undefined
  
  val position: js.UndefOr[Position] = js.undefined
  val width: js.UndefOr[String | Int] = js.undefined
  val height: js.UndefOr[String | Int] = js.undefined
  val left: js.UndefOr[String | Int] = js.undefined
  val right: js.UndefOr[String | Int] = js.undefined
  val top: js.UndefOr[String | Int] = js.undefined
  val bottom: js.UndefOr[String | Int] = js.undefined
  
  val elevation: js.UndefOr[Int] = js.undefined
}

object Style {

  trait BorderStyle extends js.Object

  object BorderStyle {
    /** default */
    val solid: BorderStyle = "solid".asInstanceOf[BorderStyle]
    val dotted: BorderStyle = "dotted".asInstanceOf[BorderStyle]
    val dashed: BorderStyle = "dashed".asInstanceOf[BorderStyle]
  }

  trait Position extends js.Object

  object Position {
    /** default */
    val relative: Position = "relative".asInstanceOf[Position]
    val absolute: Position = "absolute".asInstanceOf[Position]
  }

  trait ShadowOffset extends js.Object {

    val width: js.UndefOr[Int] = js.undefined
    val height: js.UndefOr[Int] = js.undefined
  }

  /** @see https://facebook.github.io/react-native/docs/colors
    */
  object Color {
    val transparent = "transparent" //rgba(0,0,0,0)
    
    val aliceblue = "aliceblue" // (#f0f8ff)
    val antiquewhite = "antiquewhite" // (#faebd7)
    val aqua = "aqua" // (#00ffff)
    val aquamarine = "aquamarine" // (#7fffd4)
    val azure = "azure" // (#f0ffff)
    val beige = "beige" // (#f5f5dc)
    val bisque = "bisque" // (#ffe4c4)
    val black = "black" // (#000000)
    val blanchedalmond = "blanchedalmond" // (#ffebcd)
    val blue = "blue" // (#0000ff)
    val blueviolet = "blueviolet" // (#8a2be2)
    val brown = "brown" // (#a52a2a)
    val burlywood = "burlywood" // (#deb887)
    val cadetblue = "cadetblue" // (#5f9ea0)
    val chartreuse = "chartreuse" // (#7fff00)
    val chocolate = "chocolate" // (#d2691e)
    val coral = "coral" // (#ff7f50)
    val cornflowerblue = "cornflowerblue" // (#6495ed)
    val cornsilk = "cornsilk" // (#fff8dc)
    val crimson = "crimson" // (#dc143c)
    val cyan = "cyan" // (#00ffff)
    val darkblue = "darkblue" // (#00008b)
    val darkcyan = "darkcyan" // (#008b8b)
    val darkgoldenrod = "darkgoldenrod" // (#b8860b)
    val darkgray = "darkgray" // (#a9a9a9)
    val darkgreen = "darkgreen" // (#006400)
    val darkgrey = "darkgrey" // (#a9a9a9)
    val darkkhaki = "darkkhaki" // (#bdb76b)
    val darkmagenta = "darkmagenta" // (#8b008b)
    val darkolivegreen = "darkolivegreen" // (#556b2f)
    val darkorange = "darkorange" // (#ff8c00)
    val darkorchid = "darkorchid" // (#9932cc)
    val darkred = "darkred" // (#8b0000)
    val darksalmon = "darksalmon" // (#e9967a)
    val darkseagreen = "darkseagreen" // (#8fbc8f)
    val darkslateblue = "darkslateblue" // (#483d8b)
    val darkslategrey = "darkslategrey" // (#2f4f4f)
    val darkturquoise = "darkturquoise" // (#00ced1)
    val darkviolet = "darkviolet" // (#9400d3)
    val deeppink = "deeppink" // (#ff1493)
    val deepskyblue = "deepskyblue" // (#00bfff)
    val dimgray = "dimgray" // (#696969)
    val dimgrey = "dimgrey" // (#696969)
    val dodgerblue = "dodgerblue" // (#1e90ff)
    val firebrick = "firebrick" // (#b22222)
    val floralwhite = "floralwhite" // (#fffaf0)
    val forestgreen = "forestgreen" // (#228b22)
    val fuchsia = "fuchsia" // (#ff00ff)
    val gainsboro = "gainsboro" // (#dcdcdc)
    val ghostwhite = "ghostwhite" // (#f8f8ff)
    val gold = "gold" // (#ffd700)
    val goldenrod = "goldenrod" // (#daa520)
    val gray = "gray" // (#808080)
    val green = "green" // (#008000)
    val greenyellow = "greenyellow" // (#adff2f)
    val grey = "grey" // (#808080)
    val honeydew = "honeydew" // (#f0fff0)
    val hotpink = "hotpink" // (#ff69b4)
    val indianred = "indianred" // (#cd5c5c)
    val indigo = "indigo" // (#4b0082)
    val ivory = "ivory" // (#fffff0)
    val khaki = "khaki" // (#f0e68c)
    val lavender = "lavender" // (#e6e6fa)
    val lavenderblush = "lavenderblush" // (#fff0f5)
    val lawngreen = "lawngreen" // (#7cfc00)
    val lemonchiffon = "lemonchiffon" // (#fffacd)
    val lightblue = "lightblue" // (#add8e6)
    val lightcoral = "lightcoral" // (#f08080)
    val lightcyan = "lightcyan" // (#e0ffff)
    val lightgoldenrodyellow = "lightgoldenrodyellow" // (#fafad2)
    val lightgray = "lightgray" // (#d3d3d3)
    val lightgreen = "lightgreen" // (#90ee90)
    val lightgrey = "lightgrey" // (#d3d3d3)
    val lightpink = "lightpink" // (#ffb6c1)
    val lightsalmon = "lightsalmon" // (#ffa07a)
    val lightseagreen = "lightseagreen" // (#20b2aa)
    val lightskyblue = "lightskyblue" // (#87cefa)
    val lightslategrey = "lightslategrey" // (#778899)
    val lightsteelblue = "lightsteelblue" // (#b0c4de)
    val lightyellow = "lightyellow" // (#ffffe0)
    val lime = "lime" // (#00ff00)
    val limegreen = "limegreen" // (#32cd32)
    val linen = "linen" // (#faf0e6)
    val magenta = "magenta" // (#ff00ff)
    val maroon = "maroon" // (#800000)
    val mediumaquamarine = "mediumaquamarine" // (#66cdaa)
    val mediumblue = "mediumblue" // (#0000cd)
    val mediumorchid = "mediumorchid" // (#ba55d3)
    val mediumpurple = "mediumpurple" // (#9370db)
    val mediumseagreen = "mediumseagreen" // (#3cb371)
    val mediumslateblue = "mediumslateblue" // (#7b68ee)
    val mediumspringgreen = "mediumspringgreen" // (#00fa9a)
    val mediumturquoise = "mediumturquoise" // (#48d1cc)
    val mediumvioletred = "mediumvioletred" // (#c71585)
    val midnightblue = "midnightblue" // (#191970)
    val mintcream = "mintcream" // (#f5fffa)
    val mistyrose = "mistyrose" // (#ffe4e1)
    val moccasin = "moccasin" // (#ffe4b5)
    val navajowhite = "navajowhite" // (#ffdead)
    val navy = "navy" // (#000080)
    val oldlace = "oldlace" // (#fdf5e6)
    val olive = "olive" // (#808000)
    val olivedrab = "olivedrab" // (#6b8e23)
    val orange = "orange" // (#ffa500)
    val orangered = "orangered" // (#ff4500)
    val orchid = "orchid" // (#da70d6)
    val palegoldenrod = "palegoldenrod" // (#eee8aa)
    val palegreen = "palegreen" // (#98fb98)
    val paleturquoise = "paleturquoise" // (#afeeee)
    val palevioletred = "palevioletred" // (#db7093)
    val papayawhip = "papayawhip" // (#ffefd5)
    val peachpuff = "peachpuff" // (#ffdab9)
    val peru = "peru" // (#cd853f)
    val pink = "pink" // (#ffc0cb)
    val plum = "plum" // (#dda0dd)
    val powderblue = "powderblue" // (#b0e0e6)
    val purple = "purple" // (#800080)
    val rebeccapurple = "rebeccapurple" // (#663399)
    val red = "red" // (#ff0000)
    val rosybrown = "rosybrown" // (#bc8f8f)
    val royalblue = "royalblue" // (#4169e1)
    val saddlebrown = "saddlebrown" // (#8b4513)
    val salmon = "salmon" // (#fa8072)
    val sandybrown = "sandybrown" // (#f4a460)
    val seagreen = "seagreen" // (#2e8b57)
    val seashell = "seashell" // (#fff5ee)
    val sienna = "sienna" // (#a0522d)
    val silver = "silver" // (#c0c0c0)
    val skyblue = "skyblue" // (#87ceeb)
    val slateblue = "slateblue" // (#6a5acd)
    val slategray = "slategray" // (#708090)
    val snow = "snow" // (#fffafa)
    val springgreen = "springgreen" // (#00ff7f)
    val steelblue = "steelblue" // (#4682b4)
    val tan = "tan" // (#d2b48c)
    val teal = "teal" // (#008080)
    val thistle = "thistle" // (#d8bfd8)
    val tomato = "tomato" // (#ff6347)
    val turquoise = "turquoise" // (#40e0d0)
    val violet = "violet" // (#ee82ee)
    val wheat = "wheat" // (#f5deb3)
    val white = "white" // (#ffffff)
    val whitesmoke = "whitesmoke" // (#f5f5f5)
    val yellow = "yellow" // (#ffff00)
    val yellowgreen = "yellowgreen" // (#9acd32)
  }
}
