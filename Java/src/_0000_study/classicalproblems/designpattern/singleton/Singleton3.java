package _0000_study.classicalproblems.designpattern.singleton;

/**
 * Date: 2020/10/13 15:02
 * Content:
 * 饿汉式：静态内部类
 */
public class Singleton3 {

    private Singleton3() {
    }

    private static class SingletonInstance {
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
