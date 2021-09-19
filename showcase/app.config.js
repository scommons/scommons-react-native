
export default ({ config }) => {
  if (process.env.EXPO_ENV === 'production') {
    //production config
    return {
      ...config,
      entryPoint: "./App.js",
    };
  } else {
    //development config
    return config;
  }
};
