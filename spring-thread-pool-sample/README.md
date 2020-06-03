# 线程池示例

## 创建线程池的三种方式

### 1. guava 方式
`c.s.sample.guava`

### common-lang3 方式
`c.s.sample.lang3`

### spring 方式
`c.s.sample.spring`

### 注意事项
网络上,根据阿里的建议,不建议使用`java.util.concurrent.Executors` 类快速创建线程池  
理论上,此种方式创建的线程池是无限大的,会导致 OOM


## 线程池操作原理
1. 核心线程数量: 即并发执行任务时线程的数量,未满时,接收任务将继续创建线程
2. 阻塞任务队列: 当核心线程数量已满时,将任务放入阻塞任务队列中
3. 最大线程数量: 当核心线程数量已满,阻塞任务队列已满,继续创建线程达到最大线程数量
4. 拒绝处理: 当核心线程数量已满,阻塞任务队列已满,最大线程数量已满,则执行拒绝处理. 默认: 抛出异常,任务丢弃

## 拒绝处理的方式
1. AbortPolicy: 默认方式,抛出异常,任务丢弃
2. CallerRunsPolicy: 直接在 execute方法调用的线程中执行被拒绝的任务
3. DiscardOldestPolicy: 抛弃最旧的未处理请求,对 execute 方法重试
4. DiscardPolicy: 丢弃任务
5. 实现接口 `java.util.concurrent.RejectedExecutionHandler`,自定义方式