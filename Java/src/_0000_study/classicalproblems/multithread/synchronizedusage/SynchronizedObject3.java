package _0000_study.classicalproblems.multithread.synchronizedusage;

/**
 * Date: 2020/10/14 10:24
 * Content:
 * 对象锁：代码块形式
 */
public class SynchronizedObject3 implements Runnable {

    private final Object lock = new Object();

    private void method() throws InterruptedException {
        synchronized (lock) {
            System.out.println("我是对象锁的代码块形式，我叫" + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " 运行结束");
        }
    }

    @Override
    public void run() {
        try {
            method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static final SynchronizedObject3 instance = new SynchronizedObject3();

    public static void main(String[] args) {
        // 创建线程
        Thread thread1 = new Thread(instance, "thread1");
        Thread thread2 = new Thread(instance, "thread2");

        // 启动线程
        thread1.start();
        thread2.start();
    }
}
