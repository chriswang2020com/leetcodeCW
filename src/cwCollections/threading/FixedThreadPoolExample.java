import java.util.concurrent.*;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        // 定义线程池大小为 10
        int poolSize = 10;

        // 创建自定义的线程池
        ExecutorService executor = new ThreadPoolExecutor(
                poolSize, // 核心线程数
                poolSize, // 最大线程数
                0L, // 空闲线程存活时间
                TimeUnit.MILLISECONDS, // 时间单位
                new LinkedBlockingQueue<>() // 任务队列
        );

        // 提交任务到线程池
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                System.out.println("Task executed by thread: " + Thread.currentThread().getName());
            });
        }

        // 关闭线程池
        executor.shutdown();
    }
}
