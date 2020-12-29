package zam.hzh.reflect.interfaceReflect.demo;

public interface InterfaceReflect {

    String s = "str";

    void interfaceMethod();

    // 实现类不可调用
    static void staticMethod() {
        System.out.println("static方法");
    }

    // 实现类可调用
    default void defaultMethod() {
        System.out.println("default方法");
    }
}
