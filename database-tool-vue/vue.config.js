const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  publicPath: './',
  devServer:{
    host: "localhost",
    port: 8080,
    https: false,
    open: true,
    proxy: {
      "/tool": {
        target: "http://127.0.0.1:11000",
        ws: false,
        // 是否跨域
        changeOrigin: true,
      }
    }
  }
})
