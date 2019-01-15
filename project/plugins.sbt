//resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"
resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.20")

//use patched versions by now, to make scoverage work with scalajs-bundler
addSbtPlugin(("org.scommons.patched" % "sbt-scalajs-bundler" % "0.9.0-SNAPSHOT").force())
//dependencyOverrides ++= Set(
//  "org.scommons.patched" % "sbt-scalajs-bundler" % "0.9.0-SNAPSHOT"
//)

addSbtPlugin(("org.scommons.sbt" % "sbt-scommons-plugin" % "0.1.0-SNAPSHOT").changing())
