# spring event listener sample
spring 的 事件监听器

## 操作手册
### 三种方式注册监听器
分别在 `first`,`second`,`third` 三个包内

### 关于事务同步
在 `third` 包下 `c.s.sample.listener.third.ThirdListener`
需要在 `pom.xml`文件内引入相关包,如 jpa