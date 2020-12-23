package zam.hzh.proxy.staticProxy.demo;

/**
 * 代理类
 * 实现StaticProxyInterface接口
 */
public class StaticProxyClass implements StaticProxyInterface {

    private StaticProxyInterface target;

    public StaticProxyClass(StaticProxyInterface target) {
        // 传入目标类
        this.target = target;
    }

    @Override
    public void doSomething() {
        System.out.println("代理类搞事情了。。。");
        // 调用目标类方法
        target.doSomething();
        System.out.println("代理类又搞事情了。。。");
    }

    public StaticProxyInterface getTarget() {
        return target;
    }

    public void setTarget(StaticProxyInterface target) {
        this.target = target;
    }
}
