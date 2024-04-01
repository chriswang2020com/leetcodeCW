# 基础总结
spring自动装配
- @SpringBootApplication，@Configuration，@EnableAutoConfiguration，@ComponentScan
@Configuration：它定义了一个或多个@Bean方法，用于创建和配置Spring应用程序上下文中的Bean。
@EnableAutoConfiguration：启用Spring Boot的自动配置机制
@ComponentScan：指示Spring扫描当前包中的所有@Component、@Service注解的类，将它们注册为Bean。

# 注入
- @resource根据名称，@autowired根据类型

# 异步
- @Async注解


ioc
- @component注册，@Bean注册bean实例
- @autowired Service 依赖注入 @Qualifier("ServiceImpl")指定实现方式
- BeanFactory获取beanDefinition


mvc
- @RestController
- @RequestMapping("/api")，
- @GetMapping("/users/{id}")，(@PathVariable Long id)
- @PostMapping("/users")，（@RequestBody User user）
- @PutMapping("/users/{id}") public void updateUser(@PathVariable Long id, @RequestBody User user)
- @ResponseBody，用于将方法的返回值转换为HTTP响应的主体

aop
- 动态代理+MyBatis的拦截器
- 在程序执行过程中修改参数


bean
1. bean的生命周期
> 1. 实例化bean
> 2. 设置对象属性
> 3. 检查aware相关接口设置依赖
> 4. BeanPostProcessor前置处理
> 5. 开始初始化init方法
> 6. BeanPostProcessor后置处理
> 7. 注册destruction回调接口

4. bean的作用域
定义方法：@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
> singleton：IOC容器中只有唯一的bean
> prototype：每次获取会创建一个新的bean实例，new一个bean
> 
> 
2. bean是否线程安全？
> 是否有状态，有可变的成员变量。大部分Dao，Service是无状态的，就是线程安全的
> 取决于作用域，
> 
> 

知识点
1. @component和@bean的区别，bean注解用于方法，创建实例
2. thymeleaf作用


