package zam.hzh.reflect.interfaceReflect;

import zam.hzh.reflect.interfaceReflect.demo.InterfaceReflect;
import zam.hzh.reflect.interfaceReflect.demo.InterfaceReflectImpl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InterfaceReflectMain {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 接口反射不可进行接口初始化，不可直接调用接口方法
        Class<InterfaceReflect> interfaceReflectClass = InterfaceReflect.class;

        System.out.println("=============================");
        System.out.println("获取接口所有变量：");
        Field[] declaredFields = interfaceReflectClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        System.out.println("=============================");
        System.out.println("获取接口所有方法：");
        Method[] declaredMethods = interfaceReflectClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        System.out.println("=============================");
        System.out.println("调用static方法：");
        InterfaceReflect.staticMethod();

        // 可通过接口实现类调用除static方法之外的方法
        InterfaceReflectImpl interfaceReflect = new InterfaceReflectImpl();
        System.out.println("调用default方法：");
        // 实现类调用
        interfaceReflect.defaultMethod();
        // 反射调用
        interfaceReflectClass.getDeclaredMethod("defaultMethod").invoke(interfaceReflect);

        System.out.println("调用接口方法：");
        // 实现类调用
        interfaceReflect.interfaceMethod();
        // 反射调用
        interfaceReflectClass.getDeclaredMethod("interfaceMethod").invoke(interfaceReflect);
    }
}
