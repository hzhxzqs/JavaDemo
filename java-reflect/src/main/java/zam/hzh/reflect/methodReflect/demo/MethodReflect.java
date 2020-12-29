package zam.hzh.reflect.methodReflect.demo;

import java.io.IOException;

public class MethodReflect {

    public void publicMethod() {
        System.out.println("公有方法");
    }

    protected void protectedMethod() {
        System.out.println("保护方法");
    }

    private void privateMethod() {
        System.out.println("私有方法");
    }

    void packageMethod() {
        System.out.println("包可见方法");
    }

    public final void finalMethod() {
        System.out.println("final方法");
    }

    public static void staticMethod() {
        System.out.println("static方法");
    }

    public void overloadMethod(int i) {
        System.out.println("重载方法->" + i);
    }

    public void overloadMethod(String s) {
        System.out.println("重载方法->" + s);
    }

    public String testMethod(int i, String s) throws IOException, Exception {
        return null;
    }
}
