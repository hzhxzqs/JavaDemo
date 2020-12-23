package zam.hzh.proxy.staticProxy;

import zam.hzh.proxy.staticProxy.demo.StaticProxyClass;
import zam.hzh.proxy.staticProxy.demo.StaticProxyInterface;
import zam.hzh.proxy.staticProxy.demo.StaticTargetClass;

public class StaticProxyMain {

    public static void main(String[] args) {
        StaticProxyInterface targetClass = new StaticTargetClass();
        // 将目标类传入代理类
        StaticProxyInterface proxyClass = new StaticProxyClass(targetClass);
        // 调用代理类方法
        proxyClass.doSomething();
    }
}
