package testProxy;

import org.junit.Test;
import sample.TestJavaBean;
import testProxy.annotation.ToHttpResponse;

import java.lang.annotation.Annotation;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 学习动态代理的使用
 * <p>
 * 1.获取参数泛型class{i:"方法中的第i个行参",j:"类型中第j个泛型"}
 * ((Class)((ParameterizedType)method.getGenericParameterTypes()[i]).getActualTypeArguments()[j)
 */
public class TestProxy {

    @Test
    public void testProxy() {
        Class<TestInterface> testInterfaceClass = TestInterface.class;
        TestInterface o = (TestInterface) Proxy.newProxyInstance(testInterfaceClass.getClassLoader(), new Class[]{testInterfaceClass}, new InvocationHandler() {


            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                for (Annotation annotation : method.getAnnotations()) {
                    if (annotation instanceof ToHttpResponse) {
                        System.out.println((annotation).annotationType().getName());
                    }
                }

                Type[] genericParameterTypes = method.getGenericParameterTypes();
//                Parameter[] parameters = method.getParameters();

                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                for (int i = 0, parameterAnnotationsLength = parameterAnnotations.length; i < parameterAnnotationsLength; i++) {
                    Annotation[] annotations = parameterAnnotations[i];
                    for (Annotation annotation : annotations) {
                        if (args[i] instanceof Collection) {

                            System.out.println(((Class) ((ParameterizedType) genericParameterTypes[i]).getActualTypeArguments()[0]) + " " + (annotation).annotationType().getName());
//                                for(Method method1 :((Class)((ParameterizedType)genericParameterTypes[i]).getActualTypeArguments()[0]).getMethods()){
//                                    System.out.println(method1.getName());
//                                }


                        } else {
                            System.out.println(args[i].getClass().getName() + " " + (annotation).annotationType().getName());
                        }
                    }
                }
                return null;
            }
        });


        o.test1(new ArrayList<TestJavaBean>());
        o.test2();
//        o.test();
//        o.test();
//        o.test();
//        System.out.println(o);

    }
}
