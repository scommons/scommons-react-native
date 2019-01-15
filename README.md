
[![Build Status](https://travis-ci.org/scommons/scommons-react-native.svg?branch=master)](https://travis-ci.org/scommons/scommons-react-native)
[![Coverage Status](https://coveralls.io/repos/github/scommons/scommons-react-native/badge.svg?branch=master)](https://coveralls.io/github/scommons/scommons-react-native?branch=master)
[![Scala.js](https://www.scala-js.org/assets/badges/scalajs-0.6.17.svg)](https://www.scala-js.org)

## Scala Commons React Native
Scala.js facades for core React Native (react-native) utilities and components.

It uses excellent [scalajs-reactjs](https://github.com/shogowada/scalajs-reactjs) binding/facade library.


### How to add it to your project

Current version is under active development, but you already can try it:
```scala
val scommonsReactNativeVer = "0.1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.scommons.react-native" %%% "scommons-react-native-core" % scommonsReactNativeVer,
  "org.scommons.react-native" %%% "scommons-react-native-test" % scommonsReactNativeVer % "test"
)
```

Latest `SNAPSHOT` version is published to [Sonatype Repo](https://oss.sonatype.org/content/repositories/snapshots/org/scommons/), just make sure you added
the proper dependency resolver to your `build.sbt` settings:
```scala
resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
```

### How to Build

To build and run all the tests use the following command:
```bash
sbt clean test
```

## Documentation

You can find more documentation [here](https://scommons.org)
