package cwCollections.threading;

/**
 * @author Mr.乐
 * @Description
 */

// 三种方法，总结一下就是要定义runnable跑的东西
// 1. 创建mythread继承thread并定义run方法
// 2. 创建new runnable直接定义
// 3. 创建callable没搞懂
public class runDemo {
    public static void main(String[] args) {
        MyRunnable myRun = new MyRunnable();//将一个任务提取出来，让多个线程共同去执行
        //封装线程对象
        Thread t01 = new Thread(myRun, "线程01");
        Thread t02 = new Thread(myRun, "线程02");
        Thread t03 = new Thread(myRun, "线程03");
        //开启线程
        t01.start();
        t02.start();
        t03.start();
        //通过匿名内部类的方式创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 0; i++) {
                    System.out.println(Thread.currentThread().getName() + " - " + i);
                }
            }
        },"线程04").start();
    }
}
//自定义线程类，实现Runnable接口
//这并不是一个线程类，是一个可运行的类，它还不是一个线程。
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }
}
