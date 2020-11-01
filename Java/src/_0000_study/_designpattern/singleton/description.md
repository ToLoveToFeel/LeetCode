单例模式的8种写法

* （1）饿汉式（静态常量）[可用]

  ```java
  /**
   * Date: 2020/4/4 9:39
   * Content:  饿汉式（静态常量）[可用]
   */
  public class Singleton1 {
  
      private final static Singleton1 INSTANCE = new Singleton1();
  
      private Singleton1(){}
  
      public static Singleton1 getInstance(){
          return INSTANCE;
      }
  }
  ```

  优点：简单，无线程同步问题（因为static变量在类加载的时候就是实例化完毕）

* （2）饿汉式（静态代码块）[可用]

  ```java
  /**
   * Date: 2020/4/4 9:39
   * Content:  饿汉式（静态代码块）[可用]
   */
  public class Singleton2 {
  
      private final static Singleton2 INSTANCE;
      
      static {
          INSTANCE = new Singleton2();
      }
  
      private Singleton2(){}
  
      public static Singleton2 getInstance(){
          return INSTANCE;
      }
  }
  ```

  优点：简单，无线程同步问题（因为static代码块在类加载的时候就是实例化完毕）

* （3）懒汉式（线程不安全）[不可用]

  ```java
  /**
   * Date: 2020/4/4 11:00
   * Content:  懒汉式（线程不安全）[不可用]
   */
  public class Singleton3 {
  
      private static Singleton3 instance;
  
      private Singleton3(){}
  
      public static Singleton3 getInstance(){
          if (instance == null) {
              instance = new Singleton3();
          }
          return instance;
      }
  }
  ```

  <font color=red>**为什么不可用？**</font>因为加入两个线程同时去 if 判断，均成立，会创建两个实例

* （4）懒汉式（线程安全，同步方法）[不推荐用]

  ```java
  /**
   * Date: 2020/4/4 11:05
   * Content:  懒汉式（线程安全，同步方法）[不推荐用]
   */
  public class Singleton4 {
  
      private static Singleton4 instance;
  
      private Singleton4(){}
  
      public synchronized static Singleton4 getInstance(){
          if (instance == null) {
              instance = new Singleton4();
          }
          return instance;
      }
  }
  ```

  <font color=red>**为什么不推荐使用？**</font>比如这个单例是个处理字符串工具类，如果多个进程想要得到该实例去处理字符串，则无法实现，效率低下

* （5）懒汉式（线程不安全，同步代码块）[不可用]

  ```java
  /**
   * Date: 2020/4/4 11:11
   * Content:  懒汉式（线程不安全，同步代码块）[不可用]
   */
  public class Singleton5 {
  
      private static Singleton5 instance;
  
      private Singleton5(){}
  
      public static Singleton5 getInstance(){
          if (instance == null) {
              synchronized (Singleton5.class) {
                  instance = new Singleton5();
              }
          }
          return instance;
      }
  }
  ```

  <font color=red>**为什么不可用？**</font>因为加入两个线程同时去 if 判断，均成立，会创建两个实例

* （6）<font color=red>**双重检查[推荐面试使用]**</font> 
    ```java
    /**
     * Date: 2020/4/4 11:14
     * Content:  双重检查[推荐面试使用]
     */
    public class Singleton6 {
    
        private volatile static Singleton6 instance;
    
        private Singleton6(){}
    
        public static Singleton6 getInstance(){
            if (instance == null) {
                synchronized (Singleton6.class) {
                    if (instance == null) {
                        instance = new Singleton6();
                    }
                }
            }
            return instance;
        }
    }
    ```

优点：线程安全；延迟加载，效率较高

<font color=red>**为什么要double-check，单check行不行？**</font> 

* 不行，如果去掉内部的 if 判断，会造成线程不安全；如果去掉外部的 if 判断，会造成效率低下，每次只能有一个线程运行，就如单例模式第（4）中写法

<font color=red>**那为什么不把synchronized放在getInstance()这个方法前？**</font> 

* 这样做事可以的，但这种方式不好，因为：比如这个单例是个处理字符串工具类，如果多个进程想要得到该实例去处理字符串，则无法实现，效率低下（就是（4）的缺点）

<font color=red>**为什么需要用volatile修饰instance？**</font> 

* 因为新建对象不是原子操作，实际上包含三个步骤：（1）新建一个空的对象；（2）调用构造函数赋值；（3）将对象引用赋值给instance。
* volatile保证了这三个步骤不会重排序。<font color=red>**重排序会导致NPE。**</font> 如果没有volatile可能发生重排序，比如一种重排序方式为：（1）（3）（2），如果此时线程1执行完（1）（3）后切换到线程2，线程2发现instance非空，返回instance，会导致线程2使用成员变量时抛出空指针异常（NPE）。
* volatile同时也保证了可见性。（这种说法本身没有问题，但不应作为这个问题的回答，因为：synchronized具有happens-before原则，已经保证了可见性）

* （7）懒汉式（静态内部类）[推荐使用]

  ```java
  /**
   * Date: 2020/4/4 12:59
   * Content:  懒汉式（静态内部类）[推荐使用]
   */
  public class Singleton7 {
  
      private Singleton7(){}
  
      private static class SingletonInstance {
          private static final Singleton7 INSTANCE = new Singleton7();
      }
  
      public static Singleton7 getInstance(){
          return SingletonInstance.INSTANCE;
      }
  }
  ```

  根据 JVM 的规定，加载类时，不会将 INSTANCE 初始化

* <font color=red>**枚举[推荐使用]**</font> 

  ```java
  /**
   * Date: 2020/4/4 13:01
   * Content:  枚举[推荐使用]
   */
  public enum Singleton8 {
      INSTANCE;
      public void whatever(){}
  }
  ```

  枚举经过反编译之后还是class


