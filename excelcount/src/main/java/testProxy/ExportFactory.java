package testProxy;

import excelutil.ExcelExport;
import excelutil.ExcelExporter;
import excelutil.exception.TypeErrorException;
import excelutil.util.Utils;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import sample.TestJavaBean;
import testProxy.annotation.Collection;
import testProxy.annotation.ToFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExportFactory {

    private final Map<Class<?>, ExcelExport<?>> serviceMethodCache = new ConcurrentHashMap<>();


    @SuppressWarnings("unchecked") // Single-interface proxy creation guarded by parameter safety.
    public <T> T create(Class<T> tClass) {
        Utils.validateServiceInterface(tClass);
        eagerlyValidateMethods(tClass);

        Object proxyInstance = Proxy.newProxyInstance(tClass.getClassLoader(), new Class[]{tClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                return null;
            }
        });
        return (T) proxyInstance;
    }


    private void eagerlyValidateMethods(Class<?> service) {
        for (Method method : service.getDeclaredMethods()) {
            loadExportMethod(method);
        }
    }

    /**
     * 解析interface中的方法，根据@collection 加载单实例
     * @param method
     */
    @SuppressWarnings("unchecked") // Single-interface proxy creation guarded by parameter safety.
    private ExcelExport loadExportMethod(Method method){
        Class pojoClass = getPojoClass(method);

        synchronized (serviceMethodCache){
            ExcelExport<?> excelExport = serviceMethodCache.get(pojoClass);
            //这里初始化会堵塞 但是考虑到初始化都是项目启动时候的事情 因此关系不大吧
            if(excelExport ==null) {
                excelExport = new ExcelExport<>(pojoClass);
            }
             return excelExport;
        }
    }

    private Class getPojoClass(Method method){
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            Annotation[] annotations = parameterAnnotations[i];
            for (Annotation annotation : annotations) {
                if(annotation instanceof Collection){
                    return ((Class)((ParameterizedType)method.getGenericParameterTypes()[i]).getActualTypeArguments()[0]);
                }
            }
        }
        throw new IllegalArgumentException("Method \" "+ method.toGenericString()+ " \" is not annotated by "  + Collection.class.getName());
    }




    @Test
    public void testSth(){
        Date date = new Date();
        try {
            for(Method method: TestInterface.class.getMethods()){
                Class pojoClass = getPojoClass(method);
                ExcelExporter excelExport = new ExcelExporter<>(pojoClass);

                ArrayList<TestJavaBean> testJavaBeans = new ArrayList<TestJavaBean>(){{
                    add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb").setData3(null).setData4(2).setDate(new Date()));
                    add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
                }};

                try {
                    Workbook workbook = excelExport.getWorkbook(testJavaBeans);
                    File file = new File("D://newtext.xls");
                    if (!file.exists()) {
                        file.createNewFile();
                    } else {
                        file.delete();
                        file.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    workbook.write(fileOutputStream);

                } catch (TypeErrorException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(new Date().getTime() - date.getTime());
    }
}
