创建string的方式和区别:https://blog.csdn.net/yuiop123455/article/details/107242285
jvm详解：https://cloud.tencent.com/developer/article/2045898
gc优化：https://tech.meituan.com/2017/12/29/jvm-optimize.html
todo：
1. linux语句，docker语句
2. 阅读gc优化
我的笔试：
1. 如何把方法区撑爆，如何使电脑锁死
> 不断创建对象引用，引用了不会GC，o = new Object[] {o};

2. 类加载过程
> - 加载，连接（验证，准备，解析），初始化
> - 加载过程： 根据类名获取class字节码信息。包括动态代理时的加载。
> - 连接：1. 验证格式，2. 准备：方法区内存分配，静态变量 3. 解析：常量池内的地址解析成具体内容
> - 初始化：赋值，执行java程序代码。

3. 破坏双亲委派
- tomcat需要部署多个应用，需要加载多个相同的类，为每个web容器单独提供一个WebAppClassLoader加载器。

双亲委派：不直接加载，而是交给父加载器加载。1. 避免重复加载, 2. 保证安全性，bootstrap加载内部类不会被替换；
```agsl
Bootstrap ClassLoader ，主要负责加载Java核心类库，%JRE_HOME%\lib下的rt.jar、resources.jar、charsets.jar和class等。
Extention ClassLoader，主要负责加载目录%JRE_HOME%\lib\ext目录下的jar包和class文件。
Application ClassLoader ，主要负责加载当前应用的classpath下的所有类
User ClassLoader ， 用户自定义的类加载器,可加载指定路径的class文件
```

# 虚拟机/java栈：
- 一个线程可以有多个栈帧
- 由线程私有，栈帧中有方法，不需要进行垃圾回收。嵌套方法太多就会导致stack overflow。
- 线程太多会out of memory，没有内存创虚拟机栈


## 如何判定是否要清除？
可达性分析：https://blog.csdn.net/qq_32099833/article/details/109253339
- GC Roots找到相关的存活对象，a.next = b
- gc root:
1、虚拟机栈中引用的对象
  比如：各个线程被调用的方法中使用到的参数、局部变量等。

2、本地方法栈内JNI（通常说的本地方法）引用的对象

3、方法区中类静态属性引用的对象
比如：Java类的引用类型静态变量

4、方法区中常量引用的对象
比如：字符串常量池（string Table） 里的引用

5、**所有被同步锁synchronized持有的对象。代码块中的内容**

6、Java虚拟机内部的引用。
基本数据类型对应的Class对象，一些常驻的异常对象（如：
NullPointerException、OutOfMemoryError） ，系统类加载器。

7、反映java虚拟机内部情况的JMXBean、JVMTI中注册的回调、本地代码缓存等

8、除了这些固定的GCRoots集合以外，根据用户所选用的垃圾收集器以及当前回收的内存区域不同，还可以有其他对象“临时性”地加入，共同构成完整GC Roots集合。比如：分代收集和局部回收（Partial GC）。
回收算法

## 判定完毕如何清除？
三大类：复制(复制一份再清除，碎片少，内存需求高，效率高stw少)，标记整理(移动再清除，效率低要算)，标记清除(最简单，碎片多，效率低)
分代收集：针对不同区用不同算法



## 具体案例
CMS：标记清除，低暂停，标记期间stw时间短，老年代，低暂停
Serial Old：老年代，stw，标记整理
parallel GC：新生代，stw，复制算法
G1：整堆，分区算法，把eden，old做成多个region，eden满就清eden，mixedgc老年代占比高，回收新生代，大对象。fullgc：如果mixed复制算法内存不够，触发stw，用一次serialgc，标记整理算法。
ZGC：整堆，分页算法

Serial系列 复制算法清理新生代STW，老年代整理算法STW
Parallel系列：serial加上并行
CMS：初始标记stw，再并发标记慢慢标引用，再重新标记更改的，再并发清理：https://juejin.cn/post/6926365727700189198
G1：

