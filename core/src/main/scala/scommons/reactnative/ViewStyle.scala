package scommons.reactnative

import scommons.reactnative.ViewStyle._

import scala.scalajs.js

/** @see https://facebook.github.io/react-native/docs/view-style-props
  * @see https://facebook.github.io/react-native/docs/flexbox
  */
trait ViewStyle extends Style {

  val alignContent: js.UndefOr[AlignContent] = js.undefined
  val alignItems: js.UndefOr[AlignItems] = js.undefined
  val alignSelf: js.UndefOr[AlignSelf] = js.undefined
  val flex: js.UndefOr[Int] = js.undefined
  val flexBasis: js.UndefOr[Int] = js.undefined
  val flexDirection: js.UndefOr[FlexDirection] = js.undefined
  val flexGrow: js.UndefOr[Double] = js.undefined
  val flexShrink: js.UndefOr[Double] = js.undefined
  val flexWrap: js.UndefOr[FlexWrap] = js.undefined
  val justifyContent: js.UndefOr[JustifyContent] = js.undefined
}

object ViewStyle {

  trait AlignItems extends js.Object
  
  object AlignItems {
    /** default */
    val stretch: AlignItems = "stretch".asInstanceOf[AlignItems]
    val `flex-start`: AlignItems = "flex-start".asInstanceOf[AlignItems]
    val `flex-end`: AlignItems = "flex-end".asInstanceOf[AlignItems]
    val center: AlignItems = "center".asInstanceOf[AlignItems]
    val baseline: AlignItems = "baseline".asInstanceOf[AlignItems]
  }

  trait AlignSelf extends js.Object

  object AlignSelf {
    /** default */
    val auto: AlignSelf = "auto".asInstanceOf[AlignSelf]
    val stretch: AlignSelf = "stretch".asInstanceOf[AlignSelf]
    val center: AlignSelf = "center".asInstanceOf[AlignSelf]
    val `flex-start`: AlignSelf = "flex-start".asInstanceOf[AlignSelf]
    val `flex-end`: AlignSelf = "flex-end".asInstanceOf[AlignSelf]
  }

  trait FlexDirection extends js.Object

  object FlexDirection {
    /** default */
    val column: FlexDirection = "column".asInstanceOf[FlexDirection]
    val row: FlexDirection = "row".asInstanceOf[FlexDirection]
    val `row-reverse`: FlexDirection = "row-reverse".asInstanceOf[FlexDirection]
    val `column-reverse`: FlexDirection = "column-reverse".asInstanceOf[FlexDirection]
  }

  trait FlexWrap extends js.Object

  object FlexWrap {
    /** default */
    val nowrap: FlexWrap = "nowrap".asInstanceOf[FlexWrap]
    val wrap: FlexWrap = "wrap".asInstanceOf[FlexWrap]
  }

  trait JustifyContent extends js.Object

  object JustifyContent {
    /** default */
    val `flex-start`: JustifyContent = "flex-start".asInstanceOf[JustifyContent]
    val `flex-end`: JustifyContent = "flex-end".asInstanceOf[JustifyContent]
    val center: JustifyContent = "center".asInstanceOf[JustifyContent]
    val `space-between`: JustifyContent = "space-between".asInstanceOf[JustifyContent]
    val `space-around`: JustifyContent = "space-around".asInstanceOf[JustifyContent]
    val `space-evenly`: JustifyContent = "space-evenly".asInstanceOf[JustifyContent]
  }

  trait AlignContent extends js.Object

  object AlignContent {
    /** default */
    val `flex-start`: AlignContent = "flex-start".asInstanceOf[AlignContent]
    val `flex-end`: AlignContent = "flex-end".asInstanceOf[AlignContent]
    val stretch: AlignContent = "stretch".asInstanceOf[AlignContent]
    val center: AlignContent = "center".asInstanceOf[AlignContent]
    val `space-between`: AlignContent = "space-between".asInstanceOf[AlignContent]
    val `space-around`: AlignContent = "space-around".asInstanceOf[AlignContent]
  }

}
