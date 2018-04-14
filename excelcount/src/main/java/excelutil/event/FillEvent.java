package excelutil.event;

/**
 * 在excel的一整套的事件
 * 包括
 * <dl>
 * <li>扫描前</li>
 * <li>扫描后</li>
 * <li>解析前</li>
 * <li>解析后</li>
 * <li>填充前</li>
 * <li>填充后</li>
 * <li>发送前</li>
 * <li>发送后</li>
 * </dl>
 */
public interface FillEvent<T> {

    public void beforeScanAnnotation();

    public void afterScanAnnotation();

    public void beforeResolveAnnotation();

    public void afterResolveAnnotation();

    public void beforeFillExcel();

    public void afterFillExcel();

    public void beforeTransportExcel();

    public void afterTransportExcel();
}
