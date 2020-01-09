package showcase

import scommons.react.test.TestSpec
import scommons.react.test.util.ShallowRendererUtils
import scommons.reactnative.Style._
import scommons.reactnative.TextInput._
import scommons.reactnative._
import showcase.TextInputDemo.styles

class TextInputDemoSpec extends TestSpec with ShallowRendererUtils {

  it should "call onChangeText" in {
    //given
    val onChangeText = mockFunction[String, Unit]
    val props = TextInputDemoProps(onChangeText = onChangeText)
    val comp = shallowRender(<(TextInputDemo())(^.wrapped := props)())
    val text = "new text"
    
    //then
    onChangeText.expects(text)
    
    //when
    comp.props.onChangeText(text)
  }
  
  it should "render component" in {
    //given
    val props = TextInputDemoProps(_ => ())
    val component = <(TextInputDemo())(^.wrapped := props)()
    
    //when
    val result = shallowRender(component)
    
    //then
    assertNativeComponent(result,
      <("TextInput")(
        ^.rnStyle := styles.input,
        ^.value := "Some text",
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
}
