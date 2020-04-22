
module.exports = {
  
  Asset: {
    fromModule: function (module) {
      return {
        name: "test",
        type: "asset",
        hash: "test.asset",
        uri: "test/asset/uri",
        localUri: "local/test/asset/uri",
        width: 50,
        height: 50,
        
        downloadAsync: function () {
          return Promise.resolve([undefined])
        }
      }
    },
    
    loadAsync: function (modules) {
      return Promise.resolve([undefined])
    }
  }
}
