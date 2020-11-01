package _0000_study._multithread.deadlock;

/**
 * Date: 2020/10/23 20:00
 * Content:
 */
public class Deadlock1 {
    public static void main(String[] args) {
        // 创建 Runnable
        DeadlockRunnable r1 = new DeadlockRunnable();
        DeadlockRunnable r2 = new DeadlockRunnable();
        r1.flag = 1;
        r2.flag = 2;

        // 创建线程
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);

        // 启动线程
        thread1.start();
        thread2.start();
    }

    static class DeadlockRunnable implements Runnable {
        int flag;
        private static final Object lock1 = new Object();
        private static final Object lock2 = new Object();

        @Override
        public void run() {
            if (flag == 1) {
                synchronized (lock1) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2) {
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            } else if (flag == 2) {
                synchronized (lock2) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            }
        }
    }
}
