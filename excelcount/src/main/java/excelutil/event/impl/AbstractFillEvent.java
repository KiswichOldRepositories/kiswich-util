package excelutil.event.impl;

import excelutil.event.FillEvent;

public abstract class AbstractFillEvent<T> implements FillEvent<T> {

    @Override
    public void beforeScanAnnotation() {

    }

    @Override
    public void afterScanAnnotation() {

    }

    @Override
    public void beforeResolveAnnotation() {

    }

    @Override
    public void afterResolveAnnotation() {

    }

    @Override
    public void beforeFillExcel() {

    }

    @Override
    public void afterFillExcel() {

    }

    @Override
    public void beforeTransportExcel() {

    }

    @Override
    public void afterTransportExcel() {

    }
}
