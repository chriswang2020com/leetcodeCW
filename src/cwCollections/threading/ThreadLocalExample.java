package cwCollections.threading;

public class ThreadLocalExample {
    // 创建一个 ThreadLocal 对象
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    // 定义一个方法，用于设置当前线程的变量值
    public static void setThreadLocalValue(int value) {
        threadLocal.set(value);
    }

    // 定义一个方法，用于获取当前线程的变量值
    public static int getThreadLocalValue() {
        return threadLocal.get();
    }

    public static void main(String[] args) {
        // 创建并启动多个线程
        for (int i = 0; i < 3; i++) {
            final int finalI = i;
            new Thread(() -> {
                // 每个线程设置自己的变量值
                setThreadLocalValue(finalI);
                // 获取并打印当前线程的变量值
                System.out.println("Thread " + Thread.currentThread().getName() + " value: " + getThreadLocalValue());
            }).start();
        }
    }
}

