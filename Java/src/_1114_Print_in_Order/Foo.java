package _1114_Print_in_Order;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Date: 2020/9/30 14:40
 * Content:
 */
class Foo {
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();

        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) ;

        printSecond.run();

        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) ;

        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建实例
        Foo foo = new Foo();
        // 创建 Runnable
        Runnable r1 = () -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r3 = () -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        // 创建线程
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        Thread thread3 = new Thread(r3);
        // 启动线程
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
