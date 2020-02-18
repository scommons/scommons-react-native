
## scommons-react-native-showcase
Example usages of react-native components/modules written in Scala.js.

Almost all examples are from a great book [React Native in Action](https://github.com/dabit3/react-native-in-action)

![Screenshots](../docs/images/screenshots.png)

### How to run it in your device

* [live expo link](https://expo.io/@viktorpodzigun/showcase)
* [mobile browser](https://scommons.org/scommons-react-native/showcase.html)
* [web emulator](https://scommons.org/scommons-react-native/showcase.browser.html)

#### How to Build/Run Showcase App locally using Expo

First, build the application with the following command:
```bash
sbt "project scommons-react-native-showcase" fastOptJS
```

To run the application locally, use the following command:
```bash
cd showcase
expo start --ios
expo start --web
expo start --android
```

To build web-assets, use the following command:
```bash
cd showcase
expo build:web --no-pwa
```
