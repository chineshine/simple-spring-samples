# spring boot

## 验证
- 所在包: `c.s.sample.validation` 
 
### 验证方式
- 简单验证: `c.s.sample.validation.simple`  
  1. 在传参的实体类上,定义约束注解  
  2. 在 *Controller 的方法上,在参数上加 `@valid` 注解,并传入参数 `BindingResult`
- 分组验证: `c.s.sample.validation.group`  
  1. 需要定义分组接口,如: `One,Two`,且必需是接口
  2. 在传参的实体类上,定义约束注解,并在注解中添加组
  3. 在 *Controller 的方法上,在参数上加 `@Validated` 注解,注解需定义组
- 自定义验证: `c.s.sample.validation.customer`
  1. 定义自定义注解: `c.s.sample.validation.customer.ArrayNotNull`
  2. 定义校验器: `c.s.sample.validation.customer.ArrayNotNullValidator`
  3. 参考 简单验证
  
### 测试  
- 测试类: `src/test/java` 下有对应包名的测试类    

### 验证信息的国际化
- 参考 jar 包: `hibernate-validator-{{ version }}.Final.jar`
- 供参考的国际化配置文件所在包的位置: `org.hibernate-validator`
- 自定义位置在: `src/main/resources/ValidationMessages*.properties`
