package zam.hzh.proxy.staticProxy.demo;

/**
 * 目标类
 * 实现StaticProxyInterface接口
 */
public class StaticTargetClass implements StaticProxyInterface {

    @Override
    public void doSomething() {
        System.out.println("目标类执行任务。。。");
    }
}
