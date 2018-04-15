package testProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestHandler implements InvocationHandler {

    public TestHandler(Class interfaceClass) {

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
