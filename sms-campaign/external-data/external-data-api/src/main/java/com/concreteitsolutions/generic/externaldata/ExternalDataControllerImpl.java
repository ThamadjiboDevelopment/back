package com.concreteitsolutions.generic.externaldata;

import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSourceFormat;
import com.concreteitsolutions.generic.externaldata.exceptions.ExternalDataTechnicalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Component
public class ExternalDataControllerImpl implements ExternalDataController {

    private final ExternalDataProcess externalDataProcess;

    @Autowired
    public ExternalDataControllerImpl(ExternalDataProcess externalDataProcess) {
        this.externalDataProcess = externalDataProcess;
    }

    public void importDataFromExcel(@RequestParam("file") MultipartFile file, @PathVariable("dataModel") String dataModel) {

        ExternalDataSource externalDataSource = ExternalDataSource.builder()
                .dataModel(dataModel)
                .fileName(file.getOriginalFilename())
                .format(ExternalDataSourceFormat.EXCEL)
                .build();

        externalDataProcess.importExternalData(findInputStream(file), externalDataSource);
    }


    /**
     *
     * Private functions
     *
     */

    private InputStream findInputStream(final MultipartFile file) {

        try {

            return file.getInputStream();

        } catch (IOException e) {

            e.printStackTrace();
            throw new ExternalDataTechnicalException(ExternalDataTechnicalException.ExternalDataError.FILE_INPUT_ERROR, "Error while reading uploaded file");
        }
    }
}
