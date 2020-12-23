package zam.hzh.proxy.jdkProxy.demo;

/**
 * 目标类
 * 实现JdkProxyInterface接口
 */
public class JdkTargetClass implements JdkProxyInterface {

    @Override
    public void doSomething() {
        System.out.println("目标类执行任务。。。");
    }
}
