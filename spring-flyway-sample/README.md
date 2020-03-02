# spring flyway
(本例待完善,未完全完成)

## 说明
- 根据指定数据库处理sql脚本
```
  mvn spring-boot:run -DskipTests
```

- 根据配置文件执行特定配置环境的sql脚本,如 配置`application-dev`  
1. 配置:  
`spring.flyway.locations: classpath:/dev/db/migration`
2. 执行
```
  mvn spring-boot:run -DskipTests -Dspring.profiles.active=dev
```
3. 查看数据库
网页访问,打开地址: `http://localhost:9999/h2-console`


## 生产环境建议建表方式
- 不存在则创建
```
  create if not exists table {{ table_name }} ();
```

- 存在则删除,后创建
```
  drop table if exists {{ table_name }};
  create table {{ table_name }} ();
```

## 参考地址
`https://docs.spring.io/spring-boot/docs/2.1.12.RELEASE/reference/html/howto-database-initialization.html#howto-use-a-higher-level-database-migration-tool`

## 相关配置参考
```
# FLYWAY (FlywayProperties)
spring.flyway.baseline-description=<< Flyway Baseline >> # Description to tag an existing schema with when applying a baseline.
spring.flyway.baseline-on-migrate=false # Whether to automatically call baseline when migrating a non-empty schema.
spring.flyway.baseline-version=1 # Version to tag an existing schema with when executing baseline.
spring.flyway.check-location=true # Whether to check that migration scripts location exists.
spring.flyway.clean-disabled=false # Whether to disable cleaning of the database.
spring.flyway.clean-on-validation-error=false # Whether to automatically call clean when a validation error occurs.
spring.flyway.connect-retries=0 # Maximum number of retries when attempting to connect to the database.
spring.flyway.enabled=true # Whether to enable flyway.
spring.flyway.encoding=UTF-8 # Encoding of SQL migrations.
spring.flyway.group=false # Whether to group all pending migrations together in the same transaction when applying them.
spring.flyway.ignore-future-migrations=true # Whether to ignore future migrations when reading the schema history table.
spring.flyway.ignore-ignored-migrations=false # Whether to ignore ignored migrations when reading the schema history table.
spring.flyway.ignore-missing-migrations=false # Whether to ignore missing migrations when reading the schema history table.
spring.flyway.ignore-pending-migrations=false # Whether to ignore pending migrations when reading the schema history table.
spring.flyway.init-sqls= # SQL statements to execute to initialize a connection immediately after obtaining it.
spring.flyway.installed-by= # Username recorded in the schema history table as having applied the migration.
spring.flyway.locations=classpath:db/migration # Locations of migrations scripts. Can contain the special "{vendor}" placeholder to use vendor-specific locations.
spring.flyway.mixed=false # Whether to allow mixing transactional and non-transactional statements within the same migration.
spring.flyway.out-of-order=false # Whether to allow migrations to be run out of order.
spring.flyway.password= # Login password of the database to migrate.
spring.flyway.placeholder-prefix=${ # Prefix of placeholders in migration scripts.
spring.flyway.placeholder-replacement=true # Perform placeholder replacement in migration scripts.
spring.flyway.placeholder-suffix=} # Suffix of placeholders in migration scripts.
spring.flyway.placeholders= # Placeholders and their replacements to apply to sql migration scripts.
spring.flyway.repeatable-sql-migration-prefix=R # File name prefix for repeatable SQL migrations.
spring.flyway.schemas= # Scheme names managed by Flyway (case-sensitive).
spring.flyway.skip-default-callbacks=false # Whether to skip default callbacks. If true, only custom callbacks are used.
spring.flyway.skip-default-resolvers=false # Whether to skip default resolvers. If true, only custom resolvers are used.
spring.flyway.sql-migration-prefix=V # File name prefix for SQL migrations.
spring.flyway.sql-migration-separator=__ # File name separator for SQL migrations.
spring.flyway.sql-migration-suffixes=.sql # File name suffix for SQL migrations.
spring.flyway.table=flyway_schema_history # Name of the schema schema history table that will be used by Flyway.
spring.flyway.target= # Target version up to which migrations should be considered.
spring.flyway.url= # JDBC url of the database to migrate. If not set, the primary configured data source is used.
spring.flyway.user= # Login user of the database to migrate.
spring.flyway.validate-on-migrate=true # Whether to automatically call validate when performing a migration.
```
