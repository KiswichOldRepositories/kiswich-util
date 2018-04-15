package testProxy;

import sample.TestJavaBean;
import testProxy.annotation.Collection;
import testProxy.annotation.ToHttpResponse;

import java.util.List;

public interface TestInterface {

    @ToHttpResponse
    public void test1(@Collection java.util.Collection<TestJavaBean> testJavaBeans);


    public void test2();
}
