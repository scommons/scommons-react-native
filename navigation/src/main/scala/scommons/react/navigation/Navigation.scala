package scommons.react.navigation

import io.github.shogowada.scalajs.reactjs.React.Props

import scala.scalajs.js

class Navigation(val navigation: raw.Navigation, val route: raw.Route) {

  def navigate(name: String): Unit = navigation.navigate(name)
  
  def navigate(name: String, params: Map[String, String]): Unit = {
    navigation.navigate(name, js.Dictionary(params.toSeq: _*))
  }
  
  def goBack(): Unit = navigation.goBack()
  
  def getParams: Map[String, String] = {
    val params = route.params
    if (js.isUndefined(params) || params == null) Map.empty
    else {
      params.asInstanceOf[js.Dictionary[String]].toMap
    }
  }
  
  def setParams(params: Map[String, String]): Unit = {
    navigation.setParams(js.Dictionary(params.toSeq: _*))
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
