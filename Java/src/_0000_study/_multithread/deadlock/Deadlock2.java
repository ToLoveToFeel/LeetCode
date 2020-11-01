package _0000_study._multithread.deadlock;

/**
 * Date: 2020/10/23 20:00
 * Content:
 */
public class Deadlock2 {
    public static final String PATH = "_0000_study.classicalproblems.multithread.deadlock.";

    public static void main(String[] args) {
        // 创建 Runnable
        MyRunnable r1 = new MyRunnable('A');
        MyRunnable r2 = new MyRunnable('B');

        // 创建线程
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);

        // 启动线程
        thread1.start();
        thread2.start();
    }

    static class MyRunnable implements Runnable{
        private char flag;

        public MyRunnable(char flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            try {
                Class.forName(Deadlock2.PATH + "Static" + flag);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

class StaticA {
    static {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        try {
            Class.forName(Deadlock2.PATH + "StaticB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("StaticA init OK");
    }
}

class StaticB {
    static {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        try {
            Class.forName(Deadlock2.PATH + "StaticA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("StaticB init OK");
    }
}
