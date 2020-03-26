# spring cache sample
spring 缓存

## 操作
- 引包,参考 pom.xml
- 在主类(spring 启动类)激活缓存功能: @EnableCaching
- 具体参考: c.s.sample.repository.DictRepositoryImpl

## 原理
1. 当第一次查询数据时,查询会从数据库查询数据,并将查出的数据缓存至内存中
2. 当第二次甚至多次查同样的数据时,会直接从内存中读取数据
3. 当再次查询,查询不同的数据时,会再次从数据库中查询,并再次缓存至内存中