package zam.hzh.reflect.fieldReflect.demo;

import java.util.List;

public class FieldReflect {

    // 4种修饰符变量
    public String publicField;

    protected String protectedField;

    private String privateField;

    String packageField;

    // 其它变量
    public String strField = "str";

    public int intField = 10;

    public static String staticStrField = "static";

    public static int staticIntField = 10;

    public final String finalStrField = "final";

    public final int finalIntField = 10;

    public static final String staticFinalStrField = "static final";

    public static final int staticFinalIntField = 10;

    public List<String> listField;

    @Override
    public String toString() {
        return "ReflectField{" +
                "publicField='" + publicField + '\'' +
                ", protectedField='" + protectedField + '\'' +
                ", privateField='" + privateField + '\'' +
                ", packageField='" + packageField + '\'' +
                ", strField='" + strField + '\'' +
                ", intField=" + intField +
                ", staticStrField='" + staticStrField + '\'' +
                ", staticIntField=" + staticIntField +
                ", finalStrField='" + finalStrField + '\'' +
                ", finalIntField=" + finalIntField +
                ", staticFinalStrField='" + staticFinalStrField + '\'' +
                ", staticFinalIntField=" + staticFinalIntField +
                ", listField=" + listField +
                '}';
    }
}
