创建string的方式和区别:https://blog.csdn.net/yuiop123455/article/details/107242285
jvm详解：https://cloud.tencent.com/developer/article/2045898


scala，java，groovy编译为字节码，被类加载子系统进入内存，jvm指令
执行引擎：有解释器，jit编译器翻成机器语言，垃圾回收器，处理方法区
执行区：本地方法栈，java方法栈，方法区，堆，程序计数器

类加载子系统：加载；验证class文件是否正确，为static分配内存，解析符号引用为直接引用；初始化

双亲委派：1. 避免重复加载, 2. 保证安全性，bootstrap加载内部类不会被替换；ext可以加载向上试
```agsl
Bootstrap ClassLoader ，主要负责加载Java核心类库，%JRE_HOME%\lib下的rt.jar、resources.jar、charsets.jar和class等。
Extention ClassLoader，主要负责加载目录%JRE_HOME%\lib\ext目录下的jar包和class文件。
Application ClassLoader ，主要负责加载当前应用的classpath下的所有类
User ClassLoader ， 用户自定义的类加载器,可加载指定路径的class文件
```

虚拟机/java栈：
- 由线程私有，栈帧中有方法，不需要进行垃圾回收。嵌套方法太多就会导致stack overflow。
- 线程太多会out of memory，没有内存创虚拟机栈

局部变量表： slot对应的局部变量，记录局部变量在哪个slot中，10和20的位置

操作数栈：operand stack执行字节码指令用来计算，存放10和20

堆：所有对象和数组都应该在堆中。创建的对象不会被回收需要gc

新生代：eden，s0，s1。回收后剩下的存活1次，如果eden满了，进行young gc放入s0。下次gc放s1，反反复复。
老年代：如果经历15次垃圾回收，就会放入老年代

垃圾回收类型
1. young gc新生代，old gc老年代，full gc整堆回收


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
- 标记清除，内存不足就STW

