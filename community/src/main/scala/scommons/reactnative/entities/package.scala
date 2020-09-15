package scommons.reactnative

package object entities {

  @inline
  def decodeHTML(str: String): String = {
    entities.raw.Entities.decodeHTML(str)
  }
}
