# how-to
## 说明
该 sample 实现了两种配置  
1. 前后端合并一起的配置,参考 `c.s.sample.config.SecurityConfig`,官方例子  
2. 前后端分离的配置,参考 `c.s.sample.config.SecurityConfiguration`  
使用时,请将另一种配置注释

### 前后端合并配置
1. 不需要启动前端
2. 直接启动项目
```
	mvn spring-boot:run -DskipTests
```
3. 访问地址: localhost:10086

### 前后端分离配置
1. 启动后端项目
2. 启动前端项目,在 security-sample 目录下
3. 前端是 vue 项目,启动
```
	npm run serve
```
4. 访问 localhost:7777/login

## 拓展思考
### 前后端分离,登录后如何访问后端API
建议扩展 `org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter`  
生成一个 token  
重写认证方式,加入 token 认证  
这样前端每个访问后端 API,带上这个 token,通过过滤器认证 token 就可以了  
所以决定还是用 spring-oauth,这样 token 也更好管理