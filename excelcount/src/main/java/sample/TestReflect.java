package sample;

import excelutil.annotation.ColumnName;
import excelutil.util.StringUtil;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @
 */
public class TestReflect {

    @Test
    public void testRef() {
        Class<TestJavaBean> testJavaBeanClass = TestJavaBean.class;

        Method[] methods = testJavaBeanClass.getMethods();
        ArrayList<Method> methods1 = new ArrayList<>();

        for (Method method : methods) {
            ColumnName annotation = method.getAnnotation(ColumnName.class);
            if (annotation != null) methods1.add(method);
        }

        for (Method method : methods1) {
//            System.out.println("method ： " + method.getName() + " ; returnType + " + method.getReturnType().isInstance(new Date()));
//            System.out.println("method ： " + method.getName() + " ; returnType + " + TimeUtil.isDateType(method.getReturnType()));
            System.out.println("method ： " + method.getName() + " ; returnType + " + StringUtil.isIntType(method.getReturnType()));

//            System.out.println("method ： " + method.getName() + " ; returnType + " +  ((Class)returnType).isInstance(""));
        }
    }


    @Test
    public void testInnerClass() {


    }
}


