package showcase

import scommons.react.test._
import scommons.reactnative.Style._
import scommons.reactnative.TextInput._
import scommons.reactnative._
import showcase.TextInputDemo.styles

class TextInputDemoSpec extends TestSpec with TestRendererUtils {

  it should "call onChangeText" in {
    //given
    val onChangeText = mockFunction[String, Unit]
    val props = TextInputDemoProps(onChangeText = onChangeText)
    val comp = testRender(<(TextInputDemo())(^.wrapped := props)())
    val text = "new text"
    
    //then
    onChangeText.expects(*).onCall { resultText: String =>
      resultText shouldBe text
      ()
    }
    
    //when
    comp.props.onChangeText(text)
  }
  
  it should "render component" in {
    //given
    val props = TextInputDemoProps(_ => ())
    val component = <(TextInputDemo())(^.wrapped := props)()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <("TextInput")(
        ^.rnStyle := styles.input,
        ^.value := "Some text",
        ^("allowFontScaling") := true,
        ^("autoCapitalize") := AutoCapitalize.none.asInstanceOf[String],
        ^("autoCompleteType") := AutoCompleteType.off.asInstanceOf[String],
        ^("autoCorrect") := true,
        ^("autoFocus") := false,
        ^("placeholderTextColor") := Color.red,
        ^("selectionColor") := Color.blue,
        ^("secureTextEntry") := true,
        ^("keyboardType") := KeyboardType.`email-address`.asInstanceOf[String]
      )()
    )
  }
  
  it should "provide KeyboardType enum" in {
    //when & then
    KeyboardType.default shouldBe "default"
    KeyboardType.`number-pad` shouldBe "number-pad"
    KeyboardType.`decimal-pad` shouldBe "decimal-pad"
    KeyboardType.numeric shouldBe "numeric"
    KeyboardType.`email-address` shouldBe "email-address"
    KeyboardType.`phone-pad` shouldBe "phone-pad"
    //iOS Only
    KeyboardType.`ascii-capable` shouldBe "ascii-capable"
    KeyboardType.`numbers-and-punctuation` shouldBe "numbers-and-punctuation"
    KeyboardType.url shouldBe "url"
    KeyboardType.`name-phone-pad` shouldBe "name-phone-pad"
    KeyboardType.twitter shouldBe "twitter"
    KeyboardType.`web-search` shouldBe "web-search"
    //Android Only
    KeyboardType.`visible-password` shouldBe "visible-password"
  }
  
  it should "provide AutoCapitalize enum" in {
    //when & then
    AutoCapitalize.sentences shouldBe "sentences"
    AutoCapitalize.words shouldBe "words"
    AutoCapitalize.characters shouldBe "characters"
    AutoCapitalize.none shouldBe "none"
  }

  ////////////////////////////////////////////////////////////////////////////////
  // android

  it should "provide AutoCompleteType enum" in {
    //when & then
    AutoCompleteType.off shouldBe "off"
    AutoCompleteType.username shouldBe "username"
    AutoCompleteType.password shouldBe "password"
    AutoCompleteType.email shouldBe "email"
    AutoCompleteType.name shouldBe "name"
    AutoCompleteType.tel shouldBe "tel"
    AutoCompleteType.`street-address` shouldBe "street-address"
    AutoCompleteType.`postal-code` shouldBe "postal-code"
    AutoCompleteType.`cc-number` shouldBe "cc-number"
    AutoCompleteType.`cc-csc` shouldBe "cc-csc"
    AutoCompleteType.`cc-exp` shouldBe "cc-exp"
    AutoCompleteType.`cc-exp-month` shouldBe "cc-exp-month"
    AutoCompleteType.`cc-exp-year` shouldBe "cc-exp-year"
  }
}
