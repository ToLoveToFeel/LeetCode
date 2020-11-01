package _0000_study._multithread.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Date: 2020/10/5 21:40
 * Content:
 */
public class ThreadLocalUsage {
    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            // 创建 Runnable
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalUsage().date(finalI);
                    System.out.println(Thread.currentThread().getName() + ": " + date);
                }
            };
            // 提交任务
            threadPool.submit(r);
        }
        // 关闭线程池
        threadPool.shutdown();
    }

    // 返回时间
    public String date(int seconds) {
        // 参数单位是毫秒，从1970.1.1 00:00:00 GMT计时
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = ThreadSafeFormatter.t.get();
        return dateFormat.format(date);
    }
}

class ThreadSafeFormatter {
    //    public static ThreadLocal<SimpleDateFormat> t = new ThreadLocal<SimpleDateFormat>() {
//        @Override
//        protected SimpleDateFormat initialValue() {
//            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        }
//    };
    public static ThreadLocal<SimpleDateFormat> t = ThreadLocal.withInitial(
            () -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    );
}
