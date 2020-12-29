package zam.hzh.reflect.constructorReflect.demo;

public class ConstructorReflect {

    public ConstructorReflect() {
        System.out.println("公有构造器，无参数");
    }

    public ConstructorReflect(String a) {
        System.out.println("公有构造器，String参数");
    }

    protected ConstructorReflect(int a) {
        System.out.println("保护构造器，int参数");
    }

    private ConstructorReflect(String a, int b) {
        System.out.println("私有构造器，String参数、int参数");
    }

    ConstructorReflect(int a, String b) {
        System.out.println("包可见构造器，int参数、String参数");
    }
}
