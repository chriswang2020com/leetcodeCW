外部配置源：java属性文件，YAML文件，环境变量
# 自动配置原理
> 1. 查看配置类，基于条件注解决定是否激活
> 2. 自动配置类，tomcat等激活
> 3. 
@import

# bean的实例化详细过程
> 1. 概念态BeanDefinition：查看bean是否创建，加载bean信息
> 2. 纯净态：docreate创建实例，通过反射调用无参构造函数
> 3. 属性注入：MyEmail注入EmailService：属性注入autowired建立临时缓存
> 4. 初始化：init-method自定义方法等。初始化前：BeanPostProcessor.before，初始化后：BeanPostProcessor.after
> 5. 最终放入单例池 singletonObjectMap存放成熟的bean
> bean是否会被回收
> - singleton类型不会被GC
> - prototype放在堆内，会被GC

# springboot内置Tomcat启动原理
- SB-starter-web会添加容器自动配置类
- 决定使用web容器（默认tomcat）
- 
# 动态代理
> 有接口用jdk，反之cglib动态代理
> jdk动态代理在程序执行时，动态通过invocationHandler生成代理类
> 需要3个参数：类加载器，被实现的一些接口，h当前对象invocationHandler
> invoke需要3个参数：proxy动态代理类，method方法，args参数


# @transactional 创建动态代理，事务的失效原因？
> - 生成的proxy作用：拿方法注解transactional属性，拿方法invoke反射调用目标类，提交事务
> 
> 

# springMVC执行流程
1. 前端控制器：DispatcherServlet
2. 前端控制器收到请求后，传给HandlerMapping处理url(@RestController)，根据xml配置进行拦截后返回handler
3. 执行handler，自己写的controller处理，返回model和view给DS
4. 请求视图解析器，生成view对象
5. 数据渲染到视图上

# transactional 获取不到外层传播条件
> @transactional是声明事务，用到transactiontemplate是编程式事务
> 
# starter
自己写一个starter：https://zhuanlan.zhihu.com/p/353561846
https://www.bilibili.com/video/BV1gc41117ta?p=7&vd_source=e9ee163a0843e95b21c5d6cf1d4a1c42
1. 原理
- 起步依赖和自动配置


# servlet
Java Servlet 是运行在带有支持 Java Servlet 规范的解释器的 web 服务器上的 Java 类。