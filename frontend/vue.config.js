const path = require("path");


module.exports = {
 
  devServer: {
    proxy : 'http://localhost:8787'
  },
  indexPath: '../templates/index.html',
  outputDir: path.resolve(__dirname, "../backend/src/main/resources/static"),

  lintOnSave: false,
  chainWebpack: config =>{
    config.plugins.delete('prefetch'); // prefetch 삭제
  },
}
