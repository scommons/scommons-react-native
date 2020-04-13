package scommons.react.navigation.tab

import org.scalatest.{FlatSpec, Matchers}
import scommons.react.navigation.tab.TabBarOptions._

class TabBarOptionsSpec extends FlatSpec with Matchers {

  it should "provide LabelPosition enum" in {
    //when & then
    LabelPosition.`beside-icon` shouldBe "beside-icon"
    LabelPosition.`below-icon` shouldBe "below-icon"
  }
}
