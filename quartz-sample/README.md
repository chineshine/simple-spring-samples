# spring quartz sample

## how-to
1. 需要先实现一个JOB,该 JOB 需实现接口 `org.quartz.Job`  
  参考 `c.s.sample.modules.demo.job.DemoJob`

2. 定义一个使用 `org.springframework.context.annotation.Configuration` 注解的类  
  参考 `c.s.sample.configuration.DemoScheduler`  
  类中需实现 JOB 和 trigger 两个方法,用 `org.springframework.context.annotation.Bean` 注解  
```
JOB: 定义一个定时任务 JOB
TRIGGER: 定义一个触发器,用于触发定时的执行
```

3. 启动项目
```
	mvn spring-boot:run -DskipTests
```