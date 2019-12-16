package scommons.reactnative

import scala.scalajs.js

trait TextStyle extends Style {

  val fontFamily: js.UndefOr[String] = js.undefined
  val fontSize: js.UndefOr[Int] = js.undefined // default to 14
  val fontStyle: js.UndefOr[String] = js.undefined // normal (default), or italic
  val fontWeight: js.UndefOr[String] = js.undefined // normal (default, 400), bold, 100, 200 ... 900
  val lineHeight: js.UndefOr[Int] = js.undefined
  val textAlign: js.UndefOr[String] = js.undefined // 'auto', 'center', 'right', 'left', and 'justify' (iOS only)
  val textDecorationLine: js.UndefOr[String] = js.undefined // 'none', 'underline', 'line-through', and 'underline line-through'
  val textShadowColor: js.UndefOr[String] = js.undefined
  val textShadowOffset: js.UndefOr[Style.ShadowOffset] = js.undefined
  val textShadowRadius: js.UndefOr[Int] = js.undefined
}

trait AndroidTextStyle extends TextStyle {
  
  val textAlignVertical: js.UndefOr[String] = js.undefined
}

trait IOSTextStyle extends TextStyle {
  
  val letterSpacing: js.UndefOr[Int] = js.undefined
  val textDecorationColor: js.UndefOr[String] = js.undefined
  val textDecorationStyle: js.UndefOr[String] = js.undefined // 'solid', 'double', 'dotted', and 'dashed'
  val writingDirection: js.UndefOr[String] = js.undefined
}
