package _0000_study.classicalproblems.designpattern.singleton;

/**
 * Date: 2020/10/13 15:02
 * Content:
 * 懒汉式：双重检查
 */
public class Singleton {  // 典型例子：ExtClassLoader 扩展类加载器
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}

