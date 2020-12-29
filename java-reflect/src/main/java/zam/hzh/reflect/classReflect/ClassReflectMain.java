package zam.hzh.reflect.classReflect;

import zam.hzh.reflect.classReflect.demo.ClassReflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

public class ClassReflectMain {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        // 获取Class对象的3种方法
        // 1. 通过类的class属性获取
        Class<ClassReflect> reflectClass1 = ClassReflect.class;

        // 2. 通过Class类的静态方法forName获取，抛出ClassNotFoundException异常
        Class<?> reflectClass2 = Class.forName("zam.hzh.reflect.classReflect.demo.ClassReflect");

        // 3. 通过类对象.getClass()获取
        ClassReflect classReflect = new ClassReflect();
        Class<? extends ClassReflect> reflectClass3 = classReflect.getClass();

        // 调用无参构造器创建对象
        ClassReflect classReflect1 = reflectClass1.getDeclaredConstructor().newInstance();
        ClassReflect classReflect2 = (ClassReflect) reflectClass2.getDeclaredConstructor().newInstance();
        ClassReflect classReflect3 = reflectClass3.getDeclaredConstructor().newInstance();

        System.out.println("=============================");
        System.out.println("获取父类：");
        Class<? super ClassReflect> superclass = reflectClass1.getSuperclass();
        System.out.println(superclass);

        System.out.println("=============================");
        System.out.println("获取接口：");
        Class<?>[] interfaces = reflectClass1.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        System.out.println("=============================");
        System.out.println("获取注解：");
        Annotation[] annotations = reflectClass1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        System.out.println("=============================");
        System.out.println("获取类加载器：");
        ClassLoader classLoader = reflectClass1.getClassLoader();
        System.out.println(classLoader);

        System.out.println("=============================");
        System.out.println("获取包：");
        Package classPackage = reflectClass1.getPackage();
        System.out.println(classPackage);

        System.out.println("=============================");
        System.out.println("获取类名：");
        String name = reflectClass1.getName();
        System.out.println(name);

        System.out.println("获取简单类名：");
        String simpleName = reflectClass1.getSimpleName();
        System.out.println(simpleName);

    }
}
