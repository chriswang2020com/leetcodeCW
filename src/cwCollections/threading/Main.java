package cwCollections.threading;

public class Main {



    public static void main(String[] args) {
        Thread t1 = new myThread();
        t1.setName("test");
        t1.start();
        System.out.println(Thread.currentThread().getName());
    }
}

class myThread extends Thread{
    public myThread(){
    }
    public myThread(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("executed.");
    }
}
