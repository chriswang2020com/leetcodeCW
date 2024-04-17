IOC记录：https://chat.openai.com/share/2705bf5e-3925-4290-85fe-354c815c610c

、
  BeanFactoryPostProcessor
、
 BeanPostProcessor
等概念

ApplicationContext
及
Bean
实例化详细过程

# IOC
- BeanFactory创definition：拥有createBean权限，加载bean定义至BeanDefinition，包括如何加载
- BeanFactory创bean实例：只允许单个实例singleton，每个都是独立的，例如DAO。如需每个独立用Prototype
- ApplicationContext: 作为BeanFactory的扩展，更加智能，扫描配置类，getbean获取容器中的bean
> bean的实例化详细过程
> 1. 概念态BeanDefinition：查看bean是否创建，加载bean信息
> 2. 纯净态：docreate创建实例，通过反射调用无参构造函数
> 3. 属性注入：MyEmail注入EmailService：属性注入autowired建立临时缓存
> 4. 初始化：init-method自定义方法等。初始化前：BeanPostProcessor.before，初始化后：BeanPostProcessor.after
> 5. 最终放入单例池 singletonObjectMap存放成熟的bean