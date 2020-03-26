# spring redis sample

## issue
sample 在测试过程中遇到的问题

### 控制台提示信息
- 场景:  
控制台提示:(虽然只是个 info)
```
  ...
  ...: Multiple Spring Data modules found, entering strict repository configuration mode!
```
- 分析:  
  由于 `spring-boot-starter-data-redis` 除了引入 `spring-data-redis` 外,还引入了 `spring-data-key-value`,spring 内部判断引入了多个 'spring-data' 模块,这只是个提示信息,不影响使用
- 处理:
  虽然只是个提示信息,但由于`spring-boot-starter-data-redis` 默认开启了 `repository`功能,如果没有用到 repository 功能,可在配置中关闭,提示信息消失
```
  spring.data.redis.repositories.enabled=false    
```
- 扩展 
  如果引入除了`spring-boot-starter-data-redis`,还引入了如 `data-mongo`,`data-jpa`等,建议在启动类中使用注解:
```
  ...
  @EnableRedisRepositories(basePackages="xxx.xx.xx.repositories.redis")
  @EnableMongoRepositories(basePackages="xxx.xx.xx.repositories.mongo")
  ...
```
 如果不这样做,导致 spring 在扫描 repository 时,可能会生成多个代理 bean,导致依赖注入的不准确
 

## 参考地址
- spring data redis
```
  https://docs.spring.io/spring-data/redis/docs/2.2.5.RELEASE/reference/html/
``` 
- redis 官方文档
```
  https://redis.io/documentation
```