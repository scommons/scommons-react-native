import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import * as SplashScreen from 'expo-splash-screen';

import {ShowcaseApp} from './target/scala-2.13/scalajs-bundler/main/scommons-react-native-showcase-fastopt';

SplashScreen.preventAutoHideAsync();

const App = new ShowcaseApp(() => {
  console.log("App is ready!")
  SplashScreen.hideAsync();
}).apply()

export default () => {
  
  return <App />
}
