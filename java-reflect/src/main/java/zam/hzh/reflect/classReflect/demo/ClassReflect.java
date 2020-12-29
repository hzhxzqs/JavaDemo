package zam.hzh.reflect.classReflect.demo;


import javax.jws.WebService;
import java.io.Serializable;

@WebService
public class ClassReflect extends Thread implements Serializable, Cloneable {

    public ClassReflect() {
        System.out.println("创建对象");
    }
}
