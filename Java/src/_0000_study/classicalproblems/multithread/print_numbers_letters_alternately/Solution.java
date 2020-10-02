package _0000_study.classicalproblems.multithread.print_numbers_letters_alternately;

import java.util.concurrent.CountDownLatch;

/**
 * Date: 2020/10/2 20:05
 * Content:
 */
public class Solution {
    private static final Object lock = new Object();  // 锁
    private static final CountDownLatch latch = new CountDownLatch(1);  // 确保运行顺序

    public static void main(String[] args) throws InterruptedException {
        // 创建 Runnable
        NumberRunnable r1 = new NumberRunnable();
        LetterRunnable r2 = new LetterRunnable();

        // 创建线程
        Thread thread1 = new Thread(r1, "number");
        Thread thread2 = new Thread(r2, "letter");

        // 启动线程
        thread2.start();
        thread1.start();
    }

    // 打印数字的进程
    static class NumberRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                latch.countDown();
                for (int i = 1; i <= 26; i++) {
                    // 打印数字
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    // 唤醒另一个线程
                    lock.notify();
                    // 进入睡眠
                    if (i < 26) {  // 确保程序会运行结束
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

    // 打印字母的进程
    static class LetterRunnable implements Runnable {
        @Override
        public void run() {
            try {
                latch.await();  // 确保 thread1 先被启动
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                for (int i = 0; i < 26; i++) {
                    // 打印字母
                    System.out.println(Thread.currentThread().getName() + ": " + (char) (i + 'a'));
                    // 唤醒另一个线程
                    lock.notify();
                    // 进入睡眠
                    if (i < 25) {  // 确保程序会运行结束，不会陷入无限等待中
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
