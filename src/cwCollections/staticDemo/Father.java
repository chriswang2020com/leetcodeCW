package org.example.staticDemo;

public class Father {

    static {
        System.out.println("父类的静态代码块，程序启动后执行，只会执行一次");
    }

    //父类无参构造方法
    public Father(){
        System.out.println("父类的默认构造方法");
    }

    //重载，自定义父类带参构造方法
    public Father(String str){
        System.out.println("父类的带参构造方法，参数为："+str);
    }
}
