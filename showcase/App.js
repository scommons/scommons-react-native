import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { SplashScreen } from 'expo';

import {ShowcaseApp} from './target/scala-2.12/scalajs-bundler/main/scommons-react-native-showcase-fastopt';

SplashScreen.preventAutoHide()

const App = new ShowcaseApp(() => {
  console.log("App is ready!")
  SplashScreen.hide()
}).apply()

export default () => {
  
  return <App />
}
