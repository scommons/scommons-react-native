
[![Build Status](https://travis-ci.org/scommons/scommons-react-native.svg?branch=master)](https://travis-ci.org/scommons/scommons-react-native)
[![Coverage Status](https://coveralls.io/repos/github/scommons/scommons-react-native/badge.svg?branch=master)](https://coveralls.io/github/scommons/scommons-react-native?branch=master)
[![scala-index](https://index.scala-lang.org/scommons/scommons-react-native/scommons-react-native-core/latest.svg)](https://index.scala-lang.org/scommons/scommons-react-native/scommons-react-native-core)
[![Scala.js](https://www.scala-js.org/assets/badges/scalajs-0.6.17.svg)](https://www.scala-js.org)

## Scala Commons React Native
Scala.js facades for core [react-native](https://facebook.github.io/react-native/docs/getting-started) utilities and components.

It uses excellent [scalajs-reactjs](https://github.com/shogowada/scalajs-reactjs) binding/facade library.

### How to add it to your project

```scala
val scommonsReactNativeVer = "1.0.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.scommons.react-native" %%% "scommons-react-native-core" % scommonsReactNativeVer,
  "org.scommons.react-native" %%% "scommons-react-navigation" % scommonsReactNativeVer,
  
  "org.scommons.react-native" %%% "scommons-react-native-test" % scommonsReactNativeVer % "test"
)
```

Latest `SNAPSHOT` version is published to [Sonatype Repo](https://oss.sonatype.org/content/repositories/snapshots/org/scommons/), just make sure you added
the proper dependency resolver to your `build.sbt` settings:
```scala
resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
```

### How to use it

Note: Almost all examples are from an excellent book [React Native in Action](https://github.com/dabit3/react-native-in-action)

* Demo Application
  * [live expo link](https://expo.io/@viktorpodzigun/showcase) => [How to Build and Run](showcase/README.md)
  * [app](showcase/src/main/scala/showcase/app/ShowcaseApp.scala)

* react-native
  * [Components](https://facebook.github.io/react-native/docs/activityindicator):
    * [Image](showcase/src/main/scala/showcase/ImageDemo.scala) => [tests](showcase/src/test/scala/showcase/ImageDemoSpec.scala)
    * [ScrollView](showcase/src/main/scala/showcase/ScrollViewDemo.scala) => [tests](showcase/src/test/scala/showcase/ScrollViewDemoSpec.scala)
    * [TextInput](showcase/src/main/scala/showcase/TextInputDemo.scala) => [tests](showcase/src/test/scala/showcase/TextInputDemoSpec.scala)
    * [TouchableHighlight](showcase/src/main/scala/showcase/TouchableHighlightDemo.scala) => [tests](showcase/src/test/scala/showcase/TouchableHighlightDemoSpec.scala)
  * [APIs](https://facebook.github.io/react-native/docs/accessibilityinfo):
    * [Platform](showcase/src/main/scala/showcase/PlatformDemo.scala) => [tests](showcase/src/test/scala/showcase/PlatformDemoSpec.scala)
    * [Style](showcase/src/main/scala/showcase/StyleDemo.scala) => [tests](showcase/src/test/scala/showcase/StyleDemoSpec.scala)
    * [TextStyle](showcase/src/main/scala/showcase/TextStyleDemo.scala) => [tests](showcase/src/test/scala/showcase/TextStyleDemoSpec.scala)
    * [ViewStyle](showcase/src/main/scala/showcase/ViewStyleDemo.scala) => [tests](showcase/src/test/scala/showcase/ViewStyleDemoSpec.scala)

* react-navigation
  * [Components](https://reactnavigation.org/docs/en/hello-react-navigation.html)
    * [AppContainer](showcase/src/main/scala/showcase/navigation/ReactNavigationDemo.scala) => [tests](showcase/src/test/scala/showcase/navigation/ReactNavigationDemoSpec.scala)
    * [StackNavigator](showcase/src/main/scala/showcase/navigation/ReactNavigationStackDemo.scala) => [tests](showcase/src/test/scala/showcase/navigation/ReactNavigationStackDemoSpec.scala)
  * [APIs](https://reactnavigation.org/docs/en/navigation-prop.html)
    * [Navigation](navigation/src/main/scala/scommons/react/navigation/Navigation.scala) => [tests](navigation/src/test/scala/scommons/react/navigation/NavigationSpec.scala)

* Example Components:
  * Styling
    * [Border Style](showcase/src/main/scala/showcase/app/style/BorderStyleDemo.scala) => [tests](showcase/src/test/scala/showcase/app/style/BorderStyleDemoSpec.scala)
    * [Border Radius](showcase/src/main/scala/showcase/app/style/BorderRadiusDemo.scala) => [tests](showcase/src/test/scala/showcase/app/style/BorderRadiusDemoSpec.scala)
    * [Margin](showcase/src/main/scala/showcase/app/style/MarginStyleDemo.scala) => [tests](showcase/src/test/scala/showcase/app/style/MarginStyleDemoSpec.scala)
    * [Padding](showcase/src/main/scala/showcase/app/style/PaddingStyleDemo.scala) => [tests](showcase/src/test/scala/showcase/app/style/PaddingStyleDemoSpec.scala)
    * [Position](showcase/src/main/scala/showcase/app/style/PositionStyleDemo.scala) => [tests](showcase/src/test/scala/showcase/app/style/PositionStyleDemoSpec.scala)
    * [TextStyle](showcase/src/main/scala/showcase/app/style/TextStyleDemo.scala) => [tests](showcase/src/test/scala/showcase/app/style/TextStyleDemoSpec.scala)
    * [ProfileCard (with Images)](showcase/src/main/scala/showcase/app/style/ProfileCard.scala) => [tests](showcase/src/test/scala/showcase/app/style/ProfileCardSpec.scala)

You can find more examples [here](https://github.com/scommons/scommons-examples-mobile)

### How to Build

To build and run all the tests use the following command:
```bash
sbt test
```

## Documentation

You can find more documentation [here](https://scommons.org)
