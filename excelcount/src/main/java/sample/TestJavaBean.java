package sample;

import excelutil.ExcelExporter;
import excelutil.annotation.*;
import excelutil.exception.TypeErrorException;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;

@TableName("Head")
public class TestJavaBean {
    private String data1;
    private String data2;
    private String data3;
    private Integer data4;
    private Date date;

    @ColumnName(value = "title1", order = 5)
    public String getData1() {
        return data1;
    }

    public TestJavaBean setData1(String data1) {
        this.data1 = data1;
        return this;
    }

    @ColumnName(value = "title2", order = 10, width = 3)
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

    @ColumnName(value = "title4", order = 8)
    @MapFormats(map = {@MapFormat(name = "1", value = "title00"),
            @MapFormat(name = "2", value = "ttt")})
    public Integer getData4() {
        return data4;
    }

    public TestJavaBean setData4(Integer data4) {
        this.data4 = data4;
        return this;
    }

    @ColumnName(value = "date", order = 9)
    @DateFormat(customFormatType = "yyyy--MM--dd")
    public Date getDate() {
        return date;
    }

    public TestJavaBean setDate(Date date) {
        this.date = date;
        return this;
    }

    @Test
    public void testDemo() {
        Date date = new Date();

        ExcelExporter<TestJavaBean> excel = null;
        try {
            excel = new ExcelExporter<>(TestJavaBean.class);
        } catch (TypeErrorException e) {
            e.printStackTrace();
        }

        ArrayList<TestJavaBean> testJavaBeans = new ArrayList<TestJavaBean>(){{
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb").setData3("sssss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccc找哦品尼高圣大非省的认为俄双方都是ccc中文c中文dddddcccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(2).setDate(new Date()));
            add(new TestJavaBean().setData1("aaa").setData2("bbbbbbbbbbbbb\nccccccccccccc").setData3("sssss\nsss\nss").setData4(1).setDate(new Date()));

        }};
        try {
            Workbook workbook = excel.getWorkbook(testJavaBeans);
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

        System.out.println("总共用了 + " + (new Date().getTime() - date.getTime()));
    }
}
