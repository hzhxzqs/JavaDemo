package zam.hzh.reflect.fieldReflect;

import zam.hzh.reflect.fieldReflect.demo.FieldReflect;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class FieldReflectMain {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        FieldReflect fieldReflect = new FieldReflect();
        Class<? extends FieldReflect> fieldClass = fieldReflect.getClass();

        System.out.println("=============================");
        System.out.println("获取公有成员变量：");
        Field[] fields = fieldClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("=============================");
        System.out.println("获取类中所有成员变量：");
        Field[] declaredFields = fieldClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }

        // **************获取类中成员变量并修改**************
        System.out.println("=============================");
        System.out.println("操作公有成员变量：");
        Field publicField = fieldClass.getDeclaredField("publicField");
        System.out.println("修改前，publicField = " + publicField.get(fieldReflect));
        publicField.set(fieldReflect, "publicField");
        System.out.println("修改后，publicField = " + publicField.get(fieldReflect));

        System.out.println("=============================");
        System.out.println("操作保护成员变量：");
        Field protectedField = fieldClass.getDeclaredField("protectedField");
        protectedField.setAccessible(true);
        System.out.println("修改前，protectedField = " + protectedField.get(fieldReflect));
        protectedField.set(fieldReflect, "protectedField");
        System.out.println("修改后，protectedField = " + protectedField.get(fieldReflect));

        System.out.println("=============================");
        System.out.println("操作私有成员变量：");
        Field privateField = fieldClass.getDeclaredField("privateField");
        privateField.setAccessible(true);
        System.out.println("修改前，privateField = " + privateField.get(fieldReflect));
        privateField.set(fieldReflect, "privateField");
        System.out.println("修改后，privateField = " + privateField.get(fieldReflect));

        System.out.println("=============================");
        System.out.println("操作包可见成员变量：");
        Field packageField = fieldClass.getDeclaredField("packageField");
        packageField.setAccessible(true);
        System.out.println("修改前，packageField = " + packageField.get(fieldReflect));
        packageField.set(fieldReflect, "packageField");
        System.out.println("修改后，packageField = " + packageField.get(fieldReflect));

        // **************获取其它成员变量并修改**************
        System.out.println("=============================");
        System.out.println("操作无其它修饰成员变量：");
        Field strField = fieldClass.getDeclaredField("strField");
        System.out.println("修改前，strField = " + strField.get(fieldReflect));
        strField.set(fieldReflect, "strField");
        System.out.println("修改后，strField = " + strField.get(fieldReflect));

        Field intField = fieldClass.getDeclaredField("intField");
        System.out.println("修改前，intField = " + intField.get(fieldReflect));
        intField.setInt(fieldReflect, 100);
        System.out.println("修改后，intField = " + intField.get(fieldReflect));

        System.out.println("=============================");
        System.out.println("操作static修饰的成员变量：");
        Field staticStrField = fieldClass.getDeclaredField("staticStrField");
        System.out.println("修改前，staticStrField = " + staticStrField.get(fieldReflect));
        staticStrField.set(fieldReflect, "staticStrField");
        System.out.println("修改后，staticStrField = " + staticStrField.get(fieldReflect));

        Field staticIntField = fieldClass.getDeclaredField("staticIntField");
        System.out.println("修改前，staticIntField = " + staticIntField.get(fieldReflect));
        staticIntField.setInt(fieldReflect, 100);
        System.out.println("修改后，staticIntField = " + staticIntField.get(fieldReflect));

        // final修饰的成员变量需要设置允许访问才能进行set操作
        // set之后的值只在反射中有效，对象本身的值不变
        System.out.println("=============================");
        System.out.println("操作final修饰的成员变量：");
        Field finalStrField = fieldClass.getDeclaredField("finalStrField");
        System.out.println("修改前，finalStrField = " + finalStrField.get(fieldReflect));
        finalStrField.setAccessible(true);
        finalStrField.set(fieldReflect, "finalStrField");
        System.out.println("修改后，finalStrField = " + finalStrField.get(fieldReflect));
        System.out.println("对象值，finalStrField = " + fieldReflect.finalStrField);

        Field finalIntField = fieldClass.getDeclaredField("finalIntField");
        System.out.println("修改前，finalIntField = " + finalIntField.get(fieldReflect));
        finalIntField.setAccessible(true);
        finalIntField.setInt(fieldReflect, 100);
        System.out.println("修改后，finalIntField = " + finalIntField.get(fieldReflect));
        System.out.println("对象值，finalIntField = " + fieldReflect.finalIntField);

        // static final修饰的成员变量无法进行set操作，无论是否设置允许访问
        System.out.println("=============================");
        System.out.println("操作static final修饰的成员变量：");
        Field staticFinalStrField = fieldClass.getDeclaredField("staticFinalStrField");
        System.out.println("staticFinalStrField = " + staticFinalStrField.get(fieldReflect));
        // staticFinalStrField.set(fieldReflect, "staticFinalStrField");

        Field staticFinalIntField = fieldClass.getDeclaredField("staticFinalIntField");
        System.out.println("staticFinalIntField = " + staticFinalIntField.get(fieldReflect));
        // staticFinalIntField.setInt(fieldReflect, 200);

        System.out.println("=============================");
        System.out.println("操作list成员变量：");
        Field listField = fieldClass.getDeclaredField("listField");
        System.out.println("修改前，listField = " + listField.get(fieldReflect));
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        listField.set(fieldReflect, strings);
        System.out.println("修改后，listField = " + listField.get(fieldReflect));

        System.out.println("=============================");
        System.out.println("所有修改后对象的值：");
        System.out.println(fieldReflect);
    }
}
