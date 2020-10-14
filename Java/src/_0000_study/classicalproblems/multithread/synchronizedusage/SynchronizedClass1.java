package _0000_study.classicalproblems.multithread.synchronizedusage;

/**
 * Date: 2020/10/14 10:24
 * Content:
 * 对象锁：类锁：静态方法锁
 */
public class SynchronizedClass1 implements Runnable {

    private synchronized static void method() throws InterruptedException {
        System.out.println("我是静态方法锁，我叫" + Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " 运行结束");
    }

    @Override
    public void run() {
        try {
            method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static final SynchronizedClass1 instance1 = new SynchronizedClass1();
    private static final SynchronizedClass1 instance2 = new SynchronizedClass1();

    public static void main(String[] args) {
        // 创建线程
        Thread thread1 = new Thread(instance1, "thread1");
        Thread thread2 = new Thread(instance2, "thread2");

        // 启动线程
        thread1.start();
        thread2.start();
    }
}
