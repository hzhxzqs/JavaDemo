package zam.hzh.proxy.jdkProxy;

import zam.hzh.proxy.jdkProxy.demo.JdkProxyInterface;
import zam.hzh.proxy.jdkProxy.demo.JdkProxyInvocationHandler;
import zam.hzh.proxy.jdkProxy.demo.JdkTargetClass;

import java.lang.reflect.Proxy;

public class JdkProxyMain {

    public static void main(String[] args) {
        // 设置输出动态代理产生的类
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        JdkProxyInterface targetClass = new JdkTargetClass();
        // 将目标类传入调用处理器
        JdkProxyInvocationHandler invocationHandler = new JdkProxyInvocationHandler(targetClass);
        // 生成动态代理类实例
        JdkProxyInterface proxyClass = (JdkProxyInterface) Proxy.newProxyInstance(targetClass.getClass().getClassLoader(),
                targetClass.getClass().getInterfaces(), invocationHandler);
        // 调用代理类方法
        proxyClass.doSomething();
    }
}
