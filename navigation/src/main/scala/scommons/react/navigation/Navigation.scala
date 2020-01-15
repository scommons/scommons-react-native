package scommons.react.navigation

import io.github.shogowada.scalajs.reactjs.React.Props

import scala.scalajs.js

class Navigation(val native: raw.Navigation) {

  def navigate(routeName: String): Unit = native.navigate(routeName)
  
  def navigate[T](routeName: String, params: T): Unit = {
    native.navigate(routeName, params.asInstanceOf[js.Any])
  }
  
  def goBack(): Unit = native.goBack()
  
  def getParams[T]: T = {
    native.state.params.asInstanceOf[T]
  }
}

object Navigation {

  def apply(props: Props[_]): Navigation = {
    new Navigation(props.native.navigation.asInstanceOf[raw.Navigation])
  }
}
