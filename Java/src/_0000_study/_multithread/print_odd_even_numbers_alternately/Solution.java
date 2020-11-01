package _0000_study._multithread.print_odd_even_numbers_alternately;

/**
 * Date: 2020/10/2 19:23
 * Content:
 */
public class Solution {
    private static int count = 0;  // 打印的数字
    private static final Object lock = new Object();  // 锁

    public static final int MAX_NUM = 10;  // 打印数据范围

    public static void main(String[] args) {
        // 创建 Runnable 实例
        Runnable r1 = () -> {  // 打印偶数的线程
            while (count <= MAX_NUM) {  // while 这一行和下面的 synchronized 对应行不可以交换位置，否则会发生死锁
                synchronized (lock) {
                    if ((count & 1) == 0)  // 如果 count 是偶数
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                }
            }
        };
        Runnable r2 = () -> {  // 打印奇数的线程
            // 注意因为 MAX_NUM 为偶数，如果是 <= 的话，假设某一刻 count = MAX_NUM, 两个线程都在等锁
            // 偶数线程会打印出 count, 并将 count 加一，之后奇数线程会将加一后的结果打印出来，导致错误!!!
            while (count < MAX_NUM) {
                synchronized (lock) {
                    if ((count & 1) == 1)  // 如果 count 是奇数数
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                }
            }
        };

        // 创建线程
        Thread thread1 = new Thread(r1, "even");
        Thread thread2 = new Thread(r2, "odd");

        // 启动线程
        thread1.start();
        thread2.start();
    }
}
