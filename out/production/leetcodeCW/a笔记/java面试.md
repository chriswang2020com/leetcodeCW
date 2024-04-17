# 抽象类和接口类
> 抽象类为了代码复用，继承关系。接口用来规定实现方法。
>
# 泛型

# 


Java 集合框架
1. 说说 List,Set,Map 三者的区别？三者底层的数据结构？
2. 有哪些集合是线程不安全的？怎么解决呢？
3. ⽐较 HashSet、LinkedHashSet 和 TreeSet 三者的异同
4. HashMap 和 Hashtable 的区别？HashMap 和 HashSet 区别？HashMap 和 TreeMap 区
   别？
5. HashMap 的底层实现：https://tech.meituan.com/2016/06/24/java-hashmap.html
> 结合链表和数组的优点，快插快找
> 开放寻址法：找下一个空的数组下标存储
> 链式寻址法：链表
> 再hash法：类似布隆过滤器
> 如果当前位置存在元素的话，就判断该元素与要存入的元素的 hash 值以及 key 是否相同，如果相同的话，直接覆盖，不相同就通过拉链法解决冲突。
6. HashMap 的⻓度为什么是 2 的幂次⽅
> 因为扩容是2倍的
7. ConcurrentHashMap 和 Hashtable 的区别？
> 用到了分段锁，线程安全且并发更高
> 初始16个segment，每个segment是一个hashmap数组
> 1.8之后改为node数组+红黑树，跟hashmap一样，相当于每个hashmap节点都能加锁。
8. ConcurrentHashMap 线程安全的具体实现⽅式/底层具体实现
> 分段锁segment，之后每个节点都可以上锁
9. 什么是treeMap

重写重载，
Java 基础
1. Java 中的⼏种基本数据类型是什么？对应的包装类型是什么？各⾃占⽤多少字节呢？
2.String 、 StringBuffer 和 StringBuilder 的区别是什么? String 为什么是不可变的?
   String s1 = new String("abc"); 这段代码创建了⼏个字符串对象？
> string是不可变的，为常量，线程安全。操作量少用string
> StringBuffer是线程安全, public synchronized int append
> stringBuilder不是线程安全，效率最高
4. == 与 equals?hashCode 与 equals ?
5. 包装类型的缓存机制了解么？
6. ⾃动装箱与拆箱了解吗？原理是什么？
7. 深拷⻉和浅拷⻉区别了解吗？什么是引⽤拷⻉？
8. 谈谈对 Java 注解的理解，解决了什么问题？
9. Exception 和 Error 有什么区别？
10. Java 反射？反射有什么缺点？你是怎么理解反射的（为什么框架需要反射）？
11. Java 泛型了解么？什么是类型擦除？介绍⼀下常⽤的通配符？
12. 内部类了解吗？匿名内部类了解吗？
13. BIO,NIO,AIO 有什么区别?
- 如何写一个IO流：https://www.cnblogs.com/robothy/p/14235598.html
- 零拷贝速通：https://xie.infoq.cn/article/a34cf4d2c6556d6c81be17303
> 用户空间（User space） 和 内核空间（Kernel space ）
> 通过系统调用访问内核空间，只能通过操作系统才能访问。
> ## 两个步骤。1. 准备数据，磁盘到内核缓冲区。2.拷贝数据，内核缓冲区到用户区
> 同步阻塞 I/O、同步非阻塞 I/O、I/O 多路复用、信号驱动 I/O 和异步 I/O。
> BIO 属于同步阻塞 IO。 准备，拷贝都阻塞。同步非阻塞差不多，通过轮询操作避免一直阻塞，消耗cpu
> NIO 属于多路复用。发起select调用，等数据准备好再发起read调用。selector多路复用器，同时链接多个客户端。
> > BUFFER缓冲区链接channel，capacity存放大小，limit读写数据的边界，position下一个可以读写的位置。
> > buffer.flip，clear负责position0切换为读或者写。
> > dma控制器：负责把硬盘读到内核态缓冲区
> > 零拷贝技术：mmap用户空间和系统空间共享，sendfile直接内核发到socket缓冲，不能修改数据    
> AIO 异步，read之后不阻塞，拷贝完回调。就是BIO的升级款。