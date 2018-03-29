package sample;

import excelutil.ExportObjectExcel;
import excelutil.annotation.AutoWidth;
import excelutil.annotation.ColumnName;
import excelutil.annotation.TableName;
import excelutil.exception.TypeErrorException;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@TableName("Head")
@AutoWidth
public class TestJavaBean {
    private String data1;
    private String data2;
    private String data3;

    @ColumnName(value = "title1", order = 5)
    public String getData1() {
        return data1;
    }

    public TestJavaBean setData1(String data1) {
        this.data1 = data1;
        return this;
    }

    @ColumnName(value = "title2", order = 10)
    public String getData2() {
        return data2;
    }

    public TestJavaBean setData2(String data2) {
        this.data2 = data2;
        return this;
    }

    @ColumnName(value = "title3", order = 7)
    public String getData3() {
        return data3;
    }

    public TestJavaBean setData3(String data3) {
        this.data3 = data3;
        return this;
    }

    @Test
    public void testDemo() {

        ExportObjectExcel<TestJavaBean> excel = new ExportObjectExcel<>(TestJavaBean.class);

        ArrayList<TestJavaBean> testJavaBeans = new ArrayList<TestJavaBean>(){{
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss"));
            add(new TestJavaBean().setData1("aaa\neeee").setData2("bbbbb").setData3("sssss\nss"));
        }};
        try {
            Workbook workbook = excel.getWorkbook(testJavaBeans);
            File file = new File("E://newtext.xls");
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
}
