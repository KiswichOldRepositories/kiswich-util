package excelutil.Entity;

import excelutil.ExcelExport;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.Collection;
import java.util.List;

public class ExcelService<T> {


    public Workbook getWorkbook(Collection<T> ts, ExcelExport<T> excelExport) {
        List<MethodService> methodServices = excelExport.getClassService().getMethodServices();


        return null;
    }


}
