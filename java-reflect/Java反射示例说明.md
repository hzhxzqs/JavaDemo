# Java反射

## 目录

- [1. Java反射概念](#1-Java反射概念)
- [2. 项目结构](#2-项目结构)
- [3. 类反射](#3-类反射)
  - [3.1 获取Class对象的3种方法](#31-获取Class对象的3种方法)
  - [3.2 通过Class对象创建类对象](#32-通过Class对象创建类对象)
  - [3.3 Class对象常用方法](#33-Class对象常用方法)
  - [3.4 示例操作](#34-示例操作)
- [4. 构造器反射](#4-构造器反射)
  - [4.1 获取Constructor对象](#41-获取Constructor对象)
  - [4.2 Constructor对象常用方法](#42-Constructor对象常用方法)
  - [4.3 示例操作](#43-示例操作)
- [5. 成员变量反射](#5-成员变量反射)
  - [5.1 获取Field对象](#51-获取Field对象)
  - [5.2 Field对象常用方法](#52-Field对象常用方法)
  - [5.3 示例操作](#53-示例操作)
- [6. 方法反射](#6-方法反射)
  - [6.1 获取Method对象](#61-获取Method对象)
  - [6.2 Method对象常用方法](#62-Method对象常用方法)
  - [6.3 示例操作](#63-示例操作)
- [7. 接口反射](#7-接口反射)
  - [7.1 说明](#71-说明)
  - [7.2 示例操作](#72-示例操作)

## 1. Java反射概念
Java反射机制是指在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意方法和属性。这种动态获取信息以及动态调用对象方法的功能称为Java语言的反射机制。

## 2. 项目结构

```
reflect
|—— classReflect   类反射
|—— constructorReflect   构造器反射
|—— fieldReflect   成员变量反射
|—— methodReflect   方法反射
|—— interfaceReflect   接口反射
```

## 3. 类反射
### 3.1 获取Class对象的3种方法

1. 通过`类名.class`获取
2. 通过`Class.forName()`获取，抛出`ClassNotFoundException`异常
3. 通过`类对象.getClass()`获取

```
// 获取Class对象的3种方法
// 1. 通过类名.class属性获取
Class<ClassReflect> reflectClass1 = ClassReflect.class;

// 2. 通过Class.forName()获取，抛出ClassNotFoundException异常
Class<?> reflectClass2 = Class.forName("zam.hzh.reflect.classReflect.demo.ClassReflect");

// 3. 通过类对象.getClass()获取
ClassReflect classReflect = new ClassReflect();
Class<? extends ClassReflect> reflectClass3 = classReflect.getClass();
```

### 3.2 通过Class对象创建类对象

```
// 调用无参构造器创建对象
ClassReflect classReflect1 = reflectClass1.getDeclaredConstructor().newInstance();
ClassReflect classReflect2 = (ClassReflect) reflectClass2.getDeclaredConstructor().newInstance();
ClassReflect classReflect3 = reflectClass3.getDeclaredConstructor().newInstance();
```

### 3.3 Class对象常用方法

1. `getSuperclass()`获取类继承的父类
2. `getInterfaces()`获取类实现的接口
3. `getAnnotations()`获取类标注的RUNTIME注解
4. `getClassLoader()`获取类的类加载器
5. `getPackage()`获取类的包
6. `getName()`获取类名
7. `getSimpleName()`获取简单类名

### 3.4 示例操作
执行`ClassReflectMain`的`main()`方法

## 4. 构造器反射
### 4.1 获取Constructor对象

1. `getConstructors()`获取所有公有构造器
2. `getConstructor(Class<?>...)`获取特定公有构造器，如果没有则抛出`NoSuchMethodException`异常
3. `getDeclaredConstructors()`获取所有构造器
4. `getDeclaredConstructor(Class<?>...)`获取特定构造器，如果没有则抛出`NoSuchMethodException`异常

### 4.2 Constructor对象常用方法

1. `newInstance(Object...)`创建对象
2. `setAccessible(boolean)`设置访问权限

### 4.3 示例操作
执行`ConstructorReflectMain`的`main()`方法

## 5. 成员变量反射
### 5.1 获取Field对象

1. `getFields()`获取所有公有成员变量
2. `getField(String)`获取特定公有成员变量，如果没有则抛出`NoSuchFieldException`异常
3. `getDeclaredFields()`获取所有成员变量
4. `getDeclaredField(String)`获取特定成员变量，如果没有则抛出`NoSuchFieldException`异常

### 5.2 Field对象常用方法

1. `get(Object)`获取Object对象成员变量的值
2. `getInt(Object)`获取Object对象int成员变量的值

   - 基本类型除了`void`之外都有对应的get方法
   - 基本类型成员变量如果使用`get(Object)`获取值，其类型将转为其对应包装类型

3. `set(Object, Object)`设置Object对象成员变量的值
4. `setInt(Object, int)`设置Object对象int成员变量的值

   - 基本类型除了`void`之外都有对应的set方法
   - 基本类型成员变量可使用`set(Object, Object)`设置值

5. `setAccessible(boolean)`设置访问权限

### 5.3 示例操作
执行`FieldReflectMain`的`main()`方法

## 6. 方法反射
### 6.1 获取Method对象

1. `getMethods()`获取所有公有方法，包括继承的公有方法
2. `getMethod(String, Class<?>...)`获取特定公有方法，如果没有则抛出`NoSuchMethodException`异常
3. `getDeclaredMethods()`获取当前类所有方法
4. `getDeclaredMethod(String, Class<?>...)`获取特定方法，如果没有则抛出`NoSuchMethodException`异常

### 6.2 Method对象常用方法

1. `invoke(Object, Object...)`调用方法
2. `setAccessible(boolean)`设置访问权限
3. `getDeclaringClass()`获取声明的类
4. `getReturnType()`获取方法返回类型
5. `getParameterTypes()`获取方法参数类型
6. `getParameterCount()`获取方法参数个数
7. `getExceptionTypes()`获取方法声明的抛出异常

### 6.3 示例操作
执行`MethodReflectMain`的`main()`方法

## 7. 接口反射
### 7.1 说明

- 接口不能实例化，可通过其实现类进行反射操作

### 7.2 示例操作
执行`InterfaceReflectMain`的`main()`方法
