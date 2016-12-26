package com.concreteitsolutions.generic.externaldata;


import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;

import java.io.InputStream;
import java.util.List;

public interface ExternalDataService {

    List<Object> retrieveDataFromFile(InputStream inputStream, ExternalDataSource externalDataSource);
}
