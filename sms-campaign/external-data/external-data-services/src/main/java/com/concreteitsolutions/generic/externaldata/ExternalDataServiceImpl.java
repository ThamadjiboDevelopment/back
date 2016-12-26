package com.concreteitsolutions.generic.externaldata;


import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class ExternalDataServiceImpl implements ExternalDataService{


    public List<Object> retrieveDataFromFile(InputStream inputStream, ExternalDataSource externalDataSource) {
        return null;
    }
}
