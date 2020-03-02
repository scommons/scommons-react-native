import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

import {ShowcaseApp} from './target/scala-2.12/scalajs-bundler/main/scommons-react-native-showcase-fastopt';

const App = ShowcaseApp.apply()

export default () => {
  
  return <App />
}
