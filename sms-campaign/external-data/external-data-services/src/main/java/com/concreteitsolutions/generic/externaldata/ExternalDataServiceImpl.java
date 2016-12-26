package com.concreteitsolutions.generic.externaldata;


import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSourceFormat;
import com.concreteitsolutions.generic.externaldata.exceptions.ExternalDataTechnicalException;
import com.concreteitsolutions.generic.externaldata.model.ExternalData;
import com.sun.tools.doclets.internal.toolkit.util.Extern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class ExternalDataServiceImpl implements ExternalDataService {

    private final ExternalDataDao externalDataDao;

    @Autowired
    public ExternalDataServiceImpl(ExternalDataDao externalDataDao) {
        this.externalDataDao = externalDataDao;
    }

    public List<ExternalData> retrieveDataFromExternalFile(InputStream inputStream, ExternalDataSource externalDataSource) {

        if(externalDataSource.getFormat() == ExternalDataSourceFormat.EXCEL) {
            return externalDataDao.retrieveExternalDataFromExternalFile(inputStream);
        }
        throw new ExternalDataTechnicalException(ExternalDataTechnicalException.ExternalDataError.EXTERNAL_DATA_FORMAT_NOT_SUPPORTED);
    }
}
