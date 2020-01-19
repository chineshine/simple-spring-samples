# resource server
本项目联动 `authorization-server` 一起调试  
本项目主要为了验证将 oauth 的授权服务(authorization-server) 和 资源服务(resource-server) 分离的做法  

## 操作手册
1. 已经启动 `authorization-server`  
2. 在本项目中 `application.yml` 添加相应配置  
3. 配置对应的 config  
4. 启动项目  
5. 通过在 `authorization-server` 拿到的 `access_token` 直接访问该项目的 api  

### 在 postman 访问本项目 API
地址: http://localhost:11002  
认证方式: `Bearer Token`,粘贴在 `authorization-server`获取的 `access_token`  
点击发送  