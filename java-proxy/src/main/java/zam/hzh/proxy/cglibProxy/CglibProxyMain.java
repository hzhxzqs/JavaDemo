package zam.hzh.proxy.cglibProxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import zam.hzh.proxy.cglibProxy.demo.CglibProxyMethodInterceptor;
import zam.hzh.proxy.cglibProxy.demo.CglibTargetClass;

import java.io.File;

public class CglibProxyMain {

    public static void main(String[] args) {
        // 在指定目录下生成动态代理类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                System.getProperty("user.dir") + File.separator + "com");
        // 创建Enhancer对象，类似于JDK动态代理的Proxy类
        Enhancer enhancer = new Enhancer();
        // 设置目标类的字节码文件
        enhancer.setSuperclass(CglibTargetClass.class);
        // 设置回调函数
        enhancer.setCallback(new CglibProxyMethodInterceptor());
        // 创建代理类
        CglibTargetClass proxyClass = (CglibTargetClass) enhancer.create();
        proxyClass.doSomething();
    }
}
