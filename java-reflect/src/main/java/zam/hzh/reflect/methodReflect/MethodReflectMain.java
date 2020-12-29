package zam.hzh.reflect.methodReflect;

import zam.hzh.reflect.methodReflect.demo.MethodReflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodReflectMain {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MethodReflect methodReflect = new MethodReflect();
        Class<? extends MethodReflect> methodClass = methodReflect.getClass();

        System.out.println("=============================");
        System.out.println("获取公有方法：");
        Method[] methods = methodClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("=============================");
        System.out.println("获取所有方法：");
        Method[] declaredMethods = methodClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        System.out.println("=============================");
        System.out.println("调用公有方法：");
        Method publicMethod = methodClass.getDeclaredMethod("publicMethod");
        publicMethod.invoke(methodReflect);

        System.out.println("=============================");
        System.out.println("调用保护方法：");
        Method protectedMethod = methodClass.getDeclaredMethod("protectedMethod");
        protectedMethod.setAccessible(true);
        protectedMethod.invoke(methodReflect);

        System.out.println("=============================");
        System.out.println("调用私有方法：");
        Method privateMethod = methodClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(methodReflect);

        System.out.println("=============================");
        System.out.println("调用包可见方法：");
        Method packageMethod = methodClass.getDeclaredMethod("packageMethod");
        packageMethod.setAccessible(true);
        packageMethod.invoke(methodReflect);

        System.out.println("=============================");
        System.out.println("调用final方法：");
        Method finalMethod = methodClass.getDeclaredMethod("finalMethod");
        finalMethod.invoke(methodReflect);

        System.out.println("=============================");
        System.out.println("调用static方法：");
        Method staticMethod = methodClass.getDeclaredMethod("staticMethod");
        staticMethod.invoke(methodReflect);

        System.out.println("=============================");
        System.out.println("调用重载方法：");
        Method overloadMethodInt = methodClass.getDeclaredMethod("overloadMethod", int.class);
        overloadMethodInt.invoke(methodReflect, 1);

        Method overloadMethodStr = methodClass.getDeclaredMethod("overloadMethod", String.class);
        overloadMethodStr.invoke(methodReflect, "a");

        System.out.println("=============================");
        System.out.println("其它用法：");
        Method testMethod = methodClass.getDeclaredMethod("testMethod", int.class, String.class);
        System.out.println("获取声明的类：");
        Class<?> declaringClass = testMethod.getDeclaringClass();
        System.out.println(declaringClass);

        System.out.println("获取方法返回类型：");
        Class<?> returnType = testMethod.getReturnType();
        System.out.println(returnType);

        System.out.println("获取方法参数类型：");
        Class<?>[] parameterTypes = testMethod.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println(parameterType);
        }

        System.out.println("获取方法参数个数：");
        int parameterCount = testMethod.getParameterCount();
        System.out.println(parameterCount);

        System.out.println("获取方法抛出异常：");
        Class<?>[] exceptionTypes = testMethod.getExceptionTypes();
        for (Class<?> exceptionType : exceptionTypes) {
            System.out.println(exceptionType);
        }
    }
}
