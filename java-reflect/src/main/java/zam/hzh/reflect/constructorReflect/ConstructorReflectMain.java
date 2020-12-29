package zam.hzh.reflect.constructorReflect;

import zam.hzh.reflect.constructorReflect.demo.ConstructorReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorReflectMain {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<ConstructorReflect> constructorReflectClass = ConstructorReflect.class;

        System.out.println("=============================");
        System.out.println("获取公有构造器：");
        Constructor<?>[] constructors = constructorReflectClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("=============================");
        System.out.println("获取所有构造器：");
        Constructor<?>[] declaredConstructors = constructorReflectClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        System.out.println("=============================");
        System.out.println("获取特定构造器创建对象：");
        // 获取无参数构造器
        Constructor<ConstructorReflect> declaredConstructor = constructorReflectClass.getDeclaredConstructor();
        ConstructorReflect constructorReflect = declaredConstructor.newInstance();

        // 获取String参数构造器
        Constructor<ConstructorReflect> declaredConstructor1 = constructorReflectClass.getDeclaredConstructor(String.class);
        ConstructorReflect constructorReflect1 = declaredConstructor1.newInstance("a");

        // 对于类中无法访问的构造器，都需设置允许访问
        // 获取int参数构造器，保护构造器
        Constructor<ConstructorReflect> declaredConstructor2 = constructorReflectClass.getDeclaredConstructor(int.class);
        // 设置允许访问
        declaredConstructor2.setAccessible(true);
        ConstructorReflect constructorReflect2 = declaredConstructor2.newInstance(1);

        // 获取Sting参数、int参数构造器，私有构造器
        Constructor<ConstructorReflect> declaredConstructor3 = constructorReflectClass.getDeclaredConstructor(String.class, int.class);
        declaredConstructor3.setAccessible(true);
        ConstructorReflect constructorReflect3 = declaredConstructor3.newInstance("a", 1);

        // 获取int参数、String参数构造器，包可见构造器
        Constructor<ConstructorReflect> declaredConstructor4 = constructorReflectClass.getDeclaredConstructor(int.class, String.class);
        declaredConstructor4.setAccessible(true);
        ConstructorReflect constructorReflect4 = declaredConstructor4.newInstance(1, "a");
    }
}
