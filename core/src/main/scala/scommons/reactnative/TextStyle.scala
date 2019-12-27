package scommons.reactnative

import scommons.reactnative.AndroidTextStyle._
import scommons.reactnative.IOSTextStyle._
import scommons.reactnative.Style._
import scommons.reactnative.TextStyle._

import scala.scalajs.js

/** @see https://facebook.github.io/react-native/docs/text-style-props
  */
trait TextStyle extends Style {

  val fontFamily: js.UndefOr[String] = js.undefined
  val fontSize: js.UndefOr[Int] = js.undefined // default to 14
  val fontStyle: js.UndefOr[FontStyle] = js.undefined
  val fontWeight: js.UndefOr[FontWeight] = js.undefined
  val lineHeight: js.UndefOr[Int] = js.undefined
  val textAlign: js.UndefOr[TextAlign] = js.undefined
  val textDecorationLine: js.UndefOr[TextDecorationLine] = js.undefined
  val textShadowColor: js.UndefOr[String] = js.undefined
  val textShadowOffset: js.UndefOr[ShadowOffset] = js.undefined
  val textShadowRadius: js.UndefOr[Int] = js.undefined
}

object TextStyle {

  trait FontStyle extends js.Object

  object FontStyle {
    /** default */
    val normal: FontStyle = "normal".asInstanceOf[FontStyle]
    val italic: FontStyle = "italic".asInstanceOf[FontStyle]
  }

  trait FontWeight extends js.Object

  object FontWeight {
    /** default, 400 */
    val normal: FontWeight = "normal".asInstanceOf[FontWeight]
    val bold: FontWeight = "bold".asInstanceOf[FontWeight]
    val `100`: FontWeight = "100".asInstanceOf[FontWeight]
    val `200`: FontWeight = "200".asInstanceOf[FontWeight]
    val `300`: FontWeight = "300".asInstanceOf[FontWeight]
    val `400`: FontWeight = "400".asInstanceOf[FontWeight]
    val `500`: FontWeight = "500".asInstanceOf[FontWeight]
    val `600`: FontWeight = "600".asInstanceOf[FontWeight]
    val `700`: FontWeight = "700".asInstanceOf[FontWeight]
    val `800`: FontWeight = "800".asInstanceOf[FontWeight]
    val `900`: FontWeight = "900".asInstanceOf[FontWeight]
  }

  trait TextAlign extends js.Object

  object TextAlign {
    /** default */
    val auto: TextAlign = "auto".asInstanceOf[TextAlign]
    val center: TextAlign = "center".asInstanceOf[TextAlign]
    val right: TextAlign = "right".asInstanceOf[TextAlign]
    val left: TextAlign = "left".asInstanceOf[TextAlign]
    /** iOS only */
    val justify: TextAlign = "justify".asInstanceOf[TextAlign]
  }

  trait TextDecorationLine extends js.Object

  object TextDecorationLine {
    /** default */
    val none: TextDecorationLine = "none".asInstanceOf[TextDecorationLine]
    val underline: TextDecorationLine = "underline".asInstanceOf[TextDecorationLine]
    val `line-through`: TextDecorationLine = "line-through".asInstanceOf[TextDecorationLine]
    val `underline line-through`: TextDecorationLine = "underline line-through".asInstanceOf[TextDecorationLine]
  }

}

////////////////////////////////////////////////////////////////////////////////
// android

trait AndroidTextStyle extends TextStyle {
  
  val textAlignVertical: js.UndefOr[TextAlignVertical] = js.undefined
}

object AndroidTextStyle {

  trait TextAlignVertical extends js.Object

  object TextAlignVertical {
    /** default */
    val auto: TextAlignVertical = "auto".asInstanceOf[TextAlignVertical]
    val top: TextAlignVertical = "top".asInstanceOf[TextAlignVertical]
    val bottom: TextAlignVertical = "bottom".asInstanceOf[TextAlignVertical]
    val center: TextAlignVertical = "center".asInstanceOf[TextAlignVertical]
  }

}

////////////////////////////////////////////////////////////////////////////////
// ios

trait IOSTextStyle extends TextStyle {
  
  val letterSpacing: js.UndefOr[Int] = js.undefined
  val textDecorationColor: js.UndefOr[String] = js.undefined
  val textDecorationStyle: js.UndefOr[TextDecorationStyle] = js.undefined
  val writingDirection: js.UndefOr[WritingDirection] = js.undefined
}

object IOSTextStyle {

  trait TextDecorationStyle extends js.Object

  object TextDecorationStyle {
    /** default */
    val solid: TextDecorationStyle = "solid".asInstanceOf[TextDecorationStyle]
    val double: TextDecorationStyle = "double".asInstanceOf[TextDecorationStyle]
    val dotted: TextDecorationStyle = "dotted".asInstanceOf[TextDecorationStyle]
    val dashed: TextDecorationStyle = "dashed".asInstanceOf[TextDecorationStyle]
  }

  trait WritingDirection extends js.Object

  object WritingDirection {
    /** default */
    val auto: WritingDirection = "auto".asInstanceOf[WritingDirection]
    val ltr: WritingDirection = "ltr".asInstanceOf[WritingDirection]
    val rtl: WritingDirection = "rtl".asInstanceOf[WritingDirection]
  }

}
