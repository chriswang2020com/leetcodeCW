package org.example.staticDemo;

//子类构造器
public class Son extends Father{
    static {
        System.out.println("子类的静态代码块，程序启动后执行，只会执行一次，先执行父类的，在执行子类的");
    }
    {
        System.out.println("子类构造代码块，每次调用构造方法都会执行的");
    }

    //无参构造器
    public Son(){
        //这里没有指定调用父类的哪个构造方法，会默认调用super(),调用父类的无参构造器public Father()
    }

    //重载构造器，多传两个参数
    public Son(String str1,String str2){
        //必须写在构造器第一行，调用父类的带参构造器public Father(str)
        super(str1);
        System.out.println("子类带参构造器："+str2);
    }
}
