import org.junit.Test;
import top.kiswich.googleoauth.standard.auth.IGoogleOauth2Scope;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.stream.Stream;

public class TestAll {
    @Test
    public void testAll(){
        Field[] fields = IGoogleOauth2Scope.class.getFields();
        for(Field field : fields){
            try {
                System.out.println(field.getName() + " : " + field.get(null));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testViewMap(){
        student student = new student("na", "a");
        new HashMap<String,String>(){{
            put("string","string");
        }};

    }
}

class student{
    public String name;
    public String age;

    public student(String name, String age) {
        this.name = name;
        this.age = age;
    }
}