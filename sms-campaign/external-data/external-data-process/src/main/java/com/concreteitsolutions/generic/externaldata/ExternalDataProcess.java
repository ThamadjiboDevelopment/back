package com.concreteitsolutions.generic.externaldata;

import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;

import java.io.InputStream;

public interface ExternalDataProcess {

    void importExternalData(final InputStream file, ExternalDataSource externalDataSource);
}
