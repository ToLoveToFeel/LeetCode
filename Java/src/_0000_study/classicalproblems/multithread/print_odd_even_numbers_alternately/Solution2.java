package _0000_study.classicalproblems.multithread.print_odd_even_numbers_alternately;

/**
 * Date: 2020/10/2 19:23
 * Content:
 */
public class Solution2 {
    private static int count = 0;  // 打印的数字
    private static final Object lock = new Object();  // 锁

    public static final int MAX_NUM = 10;  // 打印数据范围

    public static void main(String[] args) {
        // 创建 Runnable
        MyRunnable r1 = new MyRunnable();
        MyRunnable r2 = new MyRunnable();

        // 创建线程
        Thread thread1 = new Thread(r1, "even");
        Thread thread2 = new Thread(r2, "odd");

        // 启动线程
        thread1.start();
        thread2.start();
    }

    // 1.拿到锁，就打印
    // 2.打印完，唤醒其他线程，自己就休眠
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            // while 这一行和下面的 synchronized 对应行可以交换位置
            // 原因在于 lock.wait(); 会释放 synchronized 时获得到的 monitor 锁, 被唤醒的线程又获取该锁
            while (count <= MAX_NUM) {
                synchronized (lock) {
                    // 拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    // 唤醒另一个线程
                    lock.notify();
                    // 任务没有结束，则当前运行线程进入睡眠
                    if (count <= MAX_NUM) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
