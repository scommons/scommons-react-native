package scommons.react

import scommons.react.navigation.raw.ReactNavigation

package object navigation {

  def createAppContainer(comp: ReactClass): ReactClass =
    ReactNavigation.createAppContainer(comp)
}
