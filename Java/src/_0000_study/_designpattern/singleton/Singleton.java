package _0000_study._designpattern.singleton;

/**
 * Date: 2020/10/13 15:02
 * Content:
 * 懒汉式：双重检查
 */
public class Singleton {  // 典型例子：ExtClassLoader 扩展类加载器

    private static volatile Singleton instance;

    private static boolean flag = false;

    private Singleton() {
        synchronized (Singleton.class) {
            if (!flag) {
                flag = true;
            } else {
                throw new RuntimeException("不要试图用反射破坏单例!");
            }
        }
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                    /*
                        1.分配内存空间
                        2.执行构造方法，初始化对象
                        3.让instance指向这个空间

                        如果重排序为132，则多线程情况下可能会导致NPE
                     */
                }
            }
        }

        return instance;
    }
}

