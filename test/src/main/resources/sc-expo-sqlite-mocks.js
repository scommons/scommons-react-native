
module.exports = {
  
  openDatabase: function (name) {
    return {
      transaction: function (callback, error, success) {
        const tx = {
          executeSql: function (sqlStatement, arguments, success, error) {
            if (success) {
              success(tx, {
                insertId: 0,
                rowsAffected: 0,
                rows: {
                  _array: []
                }
              })
            }
          }
        }
        
        callback(tx)
        success()
      }
    }
  }
}
