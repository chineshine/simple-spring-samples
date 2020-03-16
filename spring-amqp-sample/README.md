# spring amqp sample
spring 利用 amqp 协议,通过使用 rabbit 进行消息通信  

## 配置
### 配置文件
`org.springframework.boot.autoconfigure.amqp.RabbitProperties`
### 配置方式(选择其一)
- 通过在 `application.yml` 中配置
- 通过 `@Configuration` 注解,注入 `Bean:ConnectionNameStrategy`

## 消息推送与接收
### 推送
#### 自动加载的类
`org.springframework.amqp.core.AmqpTemplate`  
`org.springframework.amqp.core.AmqpAdmin`  
`org.springframework.amqp.rabbit.core.RabbitMessagingTemplate`  
如果在 `@Configuration` 注解的类中声明了 `Bean:org.springframework.amqp.support.converter.MessageConverter`,将被关联用来自动装配 `AmqpTemplate`  
任何`Bean:org.springframework.amqp.core.Queue`声明,都会在 rabbitmq实例 中 被声明为一个队列

#### `Retry`(失败重试)策略
如: 连接丢失场景等
```
  spring.rabbitmq.template.retry.enabled=true
  spring.rabbitmq.template.retry.initial-interval=2s	
```
该策略默认是 `disabled`  
也可通过声明`Bean:org.springframework.boot.autoconfigure.amqp.RabbitRetryTemplateCustomizer`自定义一个`org.springframework.retry.support.RetryTemplate`

### 接收
- 通过注解 `@RabbitListener`将会自动创建一个监听器端点
- 如果不定义任何 factory:`Bean:org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory`,spring 会自动装配一个默认 factory:`org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory`
- 通过属性`spring.rabbitmq.listener.type`可以切换监听器容器类型 `simple`,`direct`,默认`simple`
- 如果定义了`Bean:MessageConverter`,会自动关联并装配到 默认 factory
- 如果要创建更多 factory,或覆盖默认的 factory,`spring boot` 提供了 `org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer` 和 `org.springframework.boot.autoconfigure.amqp.DirectRabbitListenerContainerFactoryConfigurer` 用来初始化`SimpleRabbitListenerContainerFactory` 和 `DirectRabbitListenerContainerFactory`

## 参考手册
```
  https://spring.io/guides/gs/messaging-rabbitmq/#scratch
```