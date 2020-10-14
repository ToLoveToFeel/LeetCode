package _0000_study.classicalproblems.multithread.synchronizedusage;

/**
 * Date: 2020/10/14 10:24
 * Content:
 * 对象锁：方法锁
 */
public class SynchronizedObject1 implements Runnable {

    private synchronized void method() throws InterruptedException {  // 默认锁是新建线程时传入的 Runnable 实例
        System.out.println("我是对象锁的方法修饰符形式，我叫" + Thread.currentThread().getName());
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

    private static final SynchronizedObject1 instance = new SynchronizedObject1();

    public static void main(String[] args) {
        // 创建线程
        Thread thread1 = new Thread(instance, "thread1");
        Thread thread2 = new Thread(instance, "thread2");

        // 启动线程
        thread1.start();
        thread2.start();
    }
}
