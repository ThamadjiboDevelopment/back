package com.concreteitsolutions.generic.prospect;

import com.concreteitsolutions.generic.prospect.model.ProspectView;

import java.util.List;

public interface ProspectController {

    List<ProspectView> findAllProspects();

    /**
     * Retrieve Prospects that have been imported by external data source identifier
     * @param externalDataSourceId External data source identifier
     * @return List of prospects
     */
    List<ProspectView> findProspectsByDataSource(final long externalDataSourceId);

    /**
     *
     * @return
     */
    String uploadFileAndSaveExternalData();
}
