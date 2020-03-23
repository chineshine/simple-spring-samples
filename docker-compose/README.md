# readme
docker-compose 相关内容说明,及相关配置文件的说明

## my.cnf
- 说明  
  mariadb 的配置文件
- 文件挂载所放位置
```
	/data/mariadb/conf
```

## docker maven 插件
原始插件 `docker-maven-plugin`:
`https://github.com/spotify/docker-maven-plugin`  
官方建议改用 `dockerfile-maven-plugin`:
`https://github.com/spotify/dockerfile-maven`
