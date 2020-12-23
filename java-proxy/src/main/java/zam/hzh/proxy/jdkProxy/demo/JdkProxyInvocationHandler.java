package zam.hzh.proxy.jdkProxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 调用处理器
 * 实现InvocationHandler接口创建调用处理器
 */
public class JdkProxyInvocationHandler implements InvocationHandler {

    private Object target;

    public JdkProxyInvocationHandler(Object target) {
        // 传入目标类
        this.target = target;
    }

    /**
     * 负责集中处理动态代理类上的所有方法调用
     *
     * @param proxy  代理类实例
     * @param method 被调用的方法对象
     * @param args   调用参数
     * @return 方法调用结果
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类：" + proxy.getClass());
        System.out.println("调用方法：" + method);
        System.out.println("jdk代理类搞事情了。。。");
        // 通过反射调用目标类方法
        Object result = method.invoke(target, args);
        System.out.println("jdk代理类又搞事情了。。。");
        return result;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
