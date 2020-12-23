package zam.hzh.proxy.cglibProxy.demo;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 实现MethodInterceptor接口创建方法拦截器（回调函数）
 */
public class CglibProxyMethodInterceptor implements MethodInterceptor {

    /**
     * 处理所有动态代理产生的方法调用
     *
     * @param obj    增强对象/代理对象
     * @param method 被调用的方法对象
     * @param args   调用参数
     * @param proxy  方法代理，用于调用父类（即目标类）方法
     * @return 方法调用结果
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("代理类：" + obj.getClass());
        System.out.println("调用方法：" + method);
        System.out.println("cglib代理类搞事情了。。。");
        // 调用目标类方法
        Object object = proxy.invokeSuper(obj, args);
        System.out.println("cglib代理类又搞事情了。。。");
        return object;
    }
}
