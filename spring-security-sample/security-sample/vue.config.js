
module.exports = {
  lintOnSave: process.env.NODE_ENV !== 'production',


    devServer: {
      clientLogLevel: "info",
      watchOptions: {
        poll: true
      },
      open: process.platform === "win32",
      host: "0.0.0.0",
      port: 7777,
      https: false,
      hotOnly: false,
      proxy: {
        "auth": {
          target: "http://127.0.0.1:10086",
          ws: true,
          changOrigin: true,
          pathRewrite: {
            "^/auth": ""
          },
        }
      }, // 设置代理
      before: app => {}
    },

    productionSourceMap: false,
    parallel: false
}
