# readme
docker-compose 相关内容说明,及相关配置文件的说明

## my.cnf
- 说明:  
  mariadb 的配置文件
- 文件所在位置(主机上):  
```
  /data/mariadb/conf
```

## redis.conf
- 说明:  
  redis 的配置文件
- 文件位置:  
```
  /data/redis/conf/redis.conf
```
- 单独运行:  
  1. 开启 AOF
```
  docker run --name redis:alpine -d redis --appendonly yes  
```
  2. 指定密码
```
  docker run --name redis --rm -p 6379:6379 -d redis:alpine --requirepass 123456
```
  3. 指定配置文件运行
```
  docker run --name redis --rm -d redis:alpine redis-server /data/redis/conf/redis.conf 
```

## docker maven 插件
原始插件 `docker-maven-plugin`:
`https://github.com/spotify/docker-maven-plugin`  
官方建议改用 `dockerfile-maven-plugin`:
`https://github.com/spotify/dockerfile-maven`
