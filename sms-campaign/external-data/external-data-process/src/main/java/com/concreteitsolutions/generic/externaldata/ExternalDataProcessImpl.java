package com.concreteitsolutions.generic.externaldata;

import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import com.concreteitsolutions.generic.prospect.ProspectService;
import com.concreteitsolutions.generic.prospect.model.Prospect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExternalDataProcessImpl implements ExternalDataProcess {

    private final ExternalDataService externalDataService;

    private final ProspectService prospectService;

    @Autowired
    public ExternalDataProcessImpl(ProspectService prospectService, ExternalDataService externalDataService) {
        this.prospectService = prospectService;
        this.externalDataService = externalDataService;
    }

    public void importExternalData(final InputStream file, ExternalDataSource externalDataSource) {

        List<Object> objectList = externalDataService.retrieveDataFromFile(file, externalDataSource);

        switch(externalDataSource.getDataModel()) {

            case Prospect.DATA_MODEL_NAME:

                List<Prospect> prospectList = findProspectsFromRetrievedDatas(objectList);

                prospectService.saveAll(prospectList);

            default:
                //TODO: Throw exception

        }
    }

    /**
     *
     * PRIVATE FUNCTIONS
     */
    private List<Prospect> findProspectsFromRetrievedDatas(List<Object> objectList) {

        List<Prospect> prospects = new ArrayList<>();

        for (Object obj : objectList) {
            prospects.add((Prospect) obj);
        }
        return prospects;
    }
}
