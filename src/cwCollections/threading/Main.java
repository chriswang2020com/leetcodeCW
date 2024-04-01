package cwCollections.threading;

public class Main {



    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new myThread();
        t1.start();
        t1.setName("testEnv");
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
