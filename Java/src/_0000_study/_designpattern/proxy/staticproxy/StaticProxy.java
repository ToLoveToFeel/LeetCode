package _0000_study._designpattern.proxy.staticproxy;

/**
 * Date: 2020/10/12 20:29
 * Content:
 * 静态代理
 * 特点：代理类和被代理类在编译期间，就确定下来了。
 */
// 接口
interface ClothFactory {
    void produceCloth();
}

// 代理类
class ProxyClothFactory implements ClothFactory {
    private ClothFactory factory;  // 用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

// 被代理类
class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}

public class StaticProxy {
    public static void main(String[] args) {
        // 创建被代理类对象
        ClothFactory nike = new NikeClothFactory();
        // 创建代理类对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        // 通过调用 代理类 的同名方法调用 被代理类 的方法
        proxyClothFactory.produceCloth();
    }
}
