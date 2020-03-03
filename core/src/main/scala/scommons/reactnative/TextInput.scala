package scommons.reactnative

import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

import scala.scalajs.js

/** @see https://facebook.github.io/react-native/docs/textinput
  */
object TextInput {

  trait TextInputAttributes {

    import TextInputAttributes._

    lazy val allowFontScaling = BooleanAttributeSpec("allowFontScaling")
    lazy val autoCapitalize = AutoCapitalizeAttribute("autoCapitalize")
    lazy val autoCompleteType = AutoCompleteTypeAttribute("autoCompleteType")
    lazy val autoCorrect = BooleanAttributeSpec("autoCorrect")
    lazy val autoFocus = BooleanAttributeSpec("autoFocus")
    lazy val placeholderTextColor = StringAttributeSpec("placeholderTextColor")
    lazy val selectionColor = StringAttributeSpec("selectionColor")
    lazy val secureTextEntry = BooleanAttributeSpec("secureTextEntry")
    lazy val keyboardType = KeyboardTypeAttribute("keyboardType")

    lazy val onChangeText = OnChangeTextEventAttribute("onChangeText")
  }

  object TextInputAttributes {

    import VirtualDOMAttributes.Type._
    
    case class KeyboardTypeAttribute(name: String) extends AttributeSpec {
      def :=(value: KeyboardType): Attribute[KeyboardType] = Attribute(name, value, AS_IS)
    }
    
    case class AutoCapitalizeAttribute(name: String) extends AttributeSpec {
      def :=(value: AutoCapitalize): Attribute[AutoCapitalize] = Attribute(name, value, AS_IS)
    }
    
    case class AutoCompleteTypeAttribute(name: String) extends AttributeSpec {
      def :=(value: AutoCompleteType): Attribute[AutoCompleteType] = Attribute(name, value, AS_IS)
    }
    
    type OnChangeTextEvent = js.Function1[String, Unit]

    case class OnChangeTextEventAttribute(name: String) extends AttributeSpec {
      def :=(onEvent: OnChangeTextEvent): Attribute[OnChangeTextEvent] = Attribute(name, onEvent, AS_IS)
    }

  }

  /** @see https://lefkowitz.me/visual-guide-to-react-native-textinput-keyboardtype-options/
    */
  trait KeyboardType extends js.Object

  object KeyboardType {
    /** default */
    val default: KeyboardType = "default".asInstanceOf[KeyboardType]
    val `number-pad`: KeyboardType = "number-pad".asInstanceOf[KeyboardType]
    val `decimal-pad`: KeyboardType = "decimal-pad".asInstanceOf[KeyboardType]
    val numeric: KeyboardType = "numeric".asInstanceOf[KeyboardType]
    val `email-address`: KeyboardType = "email-address".asInstanceOf[KeyboardType]
    val `phone-pad`: KeyboardType = "phone-pad".asInstanceOf[KeyboardType]
    /** iOS Only */ val `ascii-capable`: KeyboardType = "ascii-capable".asInstanceOf[KeyboardType]
    /** iOS Only */ val `numbers-and-punctuation`: KeyboardType = "numbers-and-punctuation".asInstanceOf[KeyboardType]
    /** iOS Only */ val url: KeyboardType = "url".asInstanceOf[KeyboardType]
    /** iOS Only */ val `name-phone-pad`: KeyboardType = "name-phone-pad".asInstanceOf[KeyboardType]
    /** iOS Only */ val twitter: KeyboardType = "twitter".asInstanceOf[KeyboardType]
    /** iOS Only */ val `web-search`: KeyboardType = "web-search".asInstanceOf[KeyboardType]
    /** Android Only */ val `visible-password`: KeyboardType = "visible-password".asInstanceOf[KeyboardType]
  }

  trait AutoCapitalize extends js.Object

  object AutoCapitalize {
    /** default */
    val sentences: AutoCapitalize = "sentences".asInstanceOf[AutoCapitalize]
    val words: AutoCapitalize = "words".asInstanceOf[AutoCapitalize]
    val characters: AutoCapitalize = "characters".asInstanceOf[AutoCapitalize]
    val none: AutoCapitalize = "none".asInstanceOf[AutoCapitalize]
  }

  ////////////////////////////////////////////////////////////////////////////////
  // android

  trait AutoCompleteType extends js.Object

  object AutoCompleteType {
    val off: AutoCompleteType = "off".asInstanceOf[AutoCompleteType]
    val username: AutoCompleteType = "username".asInstanceOf[AutoCompleteType]
    val password: AutoCompleteType = "password".asInstanceOf[AutoCompleteType]
    val email: AutoCompleteType = "email".asInstanceOf[AutoCompleteType]
    val name: AutoCompleteType = "name".asInstanceOf[AutoCompleteType]
    val tel: AutoCompleteType = "tel".asInstanceOf[AutoCompleteType]
    val `street-address`: AutoCompleteType = "street-address".asInstanceOf[AutoCompleteType]
    val `postal-code`: AutoCompleteType = "postal-code".asInstanceOf[AutoCompleteType]
    val `cc-number`: AutoCompleteType = "cc-number".asInstanceOf[AutoCompleteType]
    val `cc-csc`: AutoCompleteType = "cc-csc".asInstanceOf[AutoCompleteType]
    val `cc-exp`: AutoCompleteType = "cc-exp".asInstanceOf[AutoCompleteType]
    val `cc-exp-month`: AutoCompleteType = "cc-exp-month".asInstanceOf[AutoCompleteType]
    val `cc-exp-year`: AutoCompleteType = "cc-exp-year".asInstanceOf[AutoCompleteType]
  }

}
