# spring oauth2
## 注解说明
- `@EnableWebSecurity`  
  该注解用于 spring security 基本认证登录,即该项目本身的验证

- `@EnableAuthorizationServer`
  该注解用于 oauth 认证,获取 token 等

- `@EnableResourceServer`
  该注解用于 资源服务 的配置,用于 token 访问验证,其使用的过滤器默认 order=3(无法修改) ,故而与注解 `EnableWebSecurity`同时使用时, 后者 order 应大于 3
 
## grant_type 类型
```
  authorization_code
  password
  client_credentials
  implicit
  refresh_token
```

## 项目内包说明
- `c.s.sample.spring` 是 spring 官方的代码,在该项目中只是将类拆解,其配置是基于内存的
- `c.s.sample.config` 是本项目的示例代码

## 操作手册
- h2 数据库地址  
  `http://localhost:8080/h2-console`
- 启动项目,输入如下地址,获取 `authorization_code`  
  地址: `http://localhost:8080/oauth/authorize?client_id=client1&response_type=code&scope=write`  
  浏览器将会跳转到: `http://localhost:11001/?code=r3UhVG`  
  其中 `r3UhVG` 就是 `authorization_code`  

- 使用 `postman` 获取 token
在 postman 输入地址: `http://localhost:8080/oauth/token?grant_type=authorization_code&code=r3UhVG&redirect_uri=http://localhost:11001/&scope=write`,
注意:
  `redirect_uri` 参数值后面的 '/'  
  需要选择 `post` 的方式  
  需要选择认证(Authorization)方式: `Basic Auth`  
  
- 在 postman 使用 token 访问 api  
地址: `http://localhost:8080/api/users/me`  
认证方式: `Bearer Token`,值为上一步获取到的 `access_token`














