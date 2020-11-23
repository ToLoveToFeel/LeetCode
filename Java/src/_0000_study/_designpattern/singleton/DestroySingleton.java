package _0000_study._designpattern.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Date: 2020/11/23 20:27
 * Content: 通过反射破坏单例模式
 */
public class DestroySingleton {

    /**
     * 反射可以破坏单例模式，为了防止发生这种情况，可以更改Singleton构造器为：
     * private Singleton() {
     *  synchronized (Singleton.class) {
     *      if (instance != null) {
     *          throw new RuntimeException("不要试图用反射破坏单例!");
     *      }
     *   }
     * }
     * 但是上面仍然存在问题，如果两个对象都是通过反射创建的，仍然会创建多个实例，解决方式：红绿灯
     * private static boolean flag = false;
     * private Singleton() {
     *  synchronized (Singleton.class) {
     *      if (!flag) {
     *          flag = true;
     *      } else {
     *          throw new RuntimeException("不要试图用反射破坏单例!");
     *      }
     *   }
     * }
     * 这样的话，即使两个对象都是通过反射创建的，也会报错。
     * 但是这样还是存在问题，如果flag字段被别人解析出来的话，可以通过反射直接修改flag的值
     * 解决方式：枚举!!! Singleton4
     *
     */
    @Test
    public void destroySingleton() throws Exception {
        // 正常途径获得的单例模式
//        Singleton instance = Singleton.getInstance();

        // 通过反射获得单例
        Constructor<Singleton> declaredConstructor =
                Singleton.class.getDeclaredConstructor(null);  // 获取无参构造器
        declaredConstructor.setAccessible(true);  // 无视私有构造器
        Singleton instance1 = declaredConstructor.newInstance();  // 通过反射创建对象

        // 通过反射修改 flag 的值
        Field flag = Singleton.class.getDeclaredField("flag");
        flag.setAccessible(true);
        flag.set(instance1, false);

        Singleton instance2 = declaredConstructor.newInstance();  // 通过反射创建对象

        System.out.println(instance2 == instance1);
    }

    @Test
    public void destroySingleton4() throws Exception {
        Singleton4 instance1 = Singleton4.INSTANCE;
        Singleton4 instance2 = Singleton4.INSTANCE;

        System.out.println(instance1);
        System.out.println(instance2);

        // 尝试用反射破坏枚举单例
        // java.lang.NoSuchMethodException
        /*
         * 枚举本质就是一个类，idea 或 javap 反编译出来的内容显示枚举类有空参构造器，他们都骗了我们
         * 其实不存在无参构造器，用 jad 反编译出的 java 文件可以看到枚举类存在一个有参构造器，如下：
         * private Singleton4(String s, int i)
         * {
         *     super(s, i);
         * }
         * 那就通过有参构造器获取单例!!!
         * 但是这样获取不成功，因为 newInstance 中会检查当前是否为枚举，如果是的话会抛出异常:
         * java.lang.IllegalArgumentException: Cannot reflectively create enum objects
         */
//        Constructor<Singleton4> declaredConstructor =
//                Singleton4.class.getDeclaredConstructor(null);  // 获取无参构造器
        Constructor<Singleton4> declaredConstructor =
                Singleton4.class.getDeclaredConstructor(String.class, int.class);  // 获取有参参构造器
        declaredConstructor.setAccessible(true);  // 无视私有构造器
        Singleton4 instance3 = declaredConstructor.newInstance("", 1);  // 通过反射创建对象

        System.out.println(instance3);
    }


}
