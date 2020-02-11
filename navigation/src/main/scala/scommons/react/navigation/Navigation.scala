package scommons.react.navigation

import io.github.shogowada.scalajs.reactjs.React.Props

import scala.scalajs.js

class Navigation(val navigation: raw.Navigation, val route: raw.Route) {

  def navigate(name: String): Unit = navigation.navigate(name)
  
  def navigate[T](name: String, params: T): Unit = {
    navigation.navigate(name, params.asInstanceOf[js.Any])
  }
  
  def goBack(): Unit = navigation.goBack()
  
  def getParams[T]: T = {
    route.params.asInstanceOf[T]
  }
  
  def setParams[T](params: T): Unit = {
    navigation.setParams(params.asInstanceOf[js.Any])
  }

  def setOptions(options: js.Object): Unit = {
    navigation.setOptions(options)
  }
}

object Navigation {

  def apply(props: Props[_]): Navigation = {
    new Navigation(
      props.native.navigation.asInstanceOf[raw.Navigation],
      props.native.route.asInstanceOf[raw.Route]
    )
  }
}
