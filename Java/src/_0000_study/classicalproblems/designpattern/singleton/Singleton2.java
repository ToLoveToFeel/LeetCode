package _0000_study.classicalproblems.designpattern.singleton;

/**
 * Date: 2020/10/13 15:02
 * Content:
 * 饿汉式：静态常量
 */
public class Singleton2 {  // 典型例子：Runtime
    private static final Singleton2 INSTANCE = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}

// 或者（两种写法的实质是一样的）
//public class Singleton2 {
//    private static final Singleton2 INSTANCE;
//
//    static {
//        INSTANCE = new Singleton2();
//    }
//
//    private Singleton2() {
//    }
//
//    public static Singleton2 getInstance() {
//        return INSTANCE;
//    }
//}
