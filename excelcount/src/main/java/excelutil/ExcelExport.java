package excelutil;

import excelutil.Entity.ClassService;
import excelutil.Entity.ExcelService;
import excelutil.event.FillEvent;
import excelutil.event.impl.DefalutFillEvent;
import excelutil.exception.TypeErrorException;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

@Getter
@Setter
public class ExcelExport<T> {
    private Class<T> tClass;
    private ClassService<T> classService;
    private FillEvent<T> fillEvent;

    private ExcelService<T> excelService;

    public ExcelExport(Class<T> tClass) {
        this(tClass, new DefalutFillEvent<T>());
    }

    public ExcelExport(Class<T> tClass, FillEvent<T> fillEvent) {
        this.fillEvent = fillEvent;
        this.tClass = tClass;

        this.classService = new ClassService.Builder<>(tClass, fillEvent).build();
    }


    public void putExcelToHttpResponse(Collection<T> ts, HttpServletResponse response, String fileName
            , boolean autoWidth, boolean autoHetght) {

    }

    public void putExcelToHttpResponse(Collection<T> ts, HttpServletResponse response, String fileName) {
        putExcelToHttpResponse(ts, response, fileName, classService.isAutoWidth(), classService.isAutoHeight());
    }

    /**
     * 将excel传到某个流里,默认关闭流
     *
     * @param ts           pojo的集合，会将里面的数据写入excel
     * @param outputStream 要输出的流，默认关闭
     * @throws IOException
     */
    public void putExcelToOutputstream(Collection<T> ts, OutputStream outputStream) throws IOException {
        putExcelToOutputstream(ts, outputStream, true);
    }

    public void putExcelToOutputstream(Collection<T> ts, OutputStream outputStream, boolean closeed) throws IOException {
        try {
            Workbook workbook = excelService.getWorkbook(ts, this);
            workbook.write(outputStream);
        } finally {
            if (closeed && outputStream != null) outputStream.close();
        }
    }

}
