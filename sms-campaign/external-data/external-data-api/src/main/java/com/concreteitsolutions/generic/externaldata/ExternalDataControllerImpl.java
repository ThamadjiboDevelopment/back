package com.concreteitsolutions.generic.externaldata;

import com.concreteitsolutions.commonframework.core.exceptions.tmp.LOG;
import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSourceFormat;
import com.concreteitsolutions.generic.externaldata.exceptions.ExternalDataTechnicalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

@Component
public class ExternalDataControllerImpl implements ExternalDataController {

    private final ExternalDataProcess externalDataProcess;

    @Autowired
    public ExternalDataControllerImpl(ExternalDataProcess externalDataProcess) {
        this.externalDataProcess = externalDataProcess;
    }

    public ResponseEntity<String> importDataFromExcel(@RequestParam("file") MultipartFile file, @PathVariable("dataModel") String dataModel) {

        LOG.debug("Entered in import data controller ..");
        ExternalDataSource externalDataSource = ExternalDataSource.builder()
                .dataModel(dataModel)
                .fileName(file.getOriginalFilename())
                .format(ExternalDataSourceFormat.EXCEL)
                .build();

        externalDataProcess.importExternalData(findInputStream(file), externalDataSource);

        return ResponseEntity.status(HttpStatus.OK).body("OK");
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
