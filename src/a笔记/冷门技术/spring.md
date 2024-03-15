1. bean的作用域
定义方法：@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
> singleton：IOC容器中只有唯一的bean
> prototype：每次获取会创建一个新的bean
> 
> 
2. bean是否线程安全？
> 是否有状态，有可变的成员变量。大部分Dao，Service是无状态的，就是线程安全的
> 取决于作用域，
> 
> 

知识点
1. @component和@bean的区别，bean注解用于方法
2. thymeleaf作用