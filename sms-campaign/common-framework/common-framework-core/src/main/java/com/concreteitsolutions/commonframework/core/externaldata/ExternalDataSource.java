package com.concreteitsolutions.commonframework.core.externaldata;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExternalDataSource {

    private final long id;

    private final ExternalDataSourceFormat format;

    private final String fileName;

    private final String dataModel;

    private final String localStoragePath;

    /**
     * - Import date
     * - User that imported it
     * -
     */
}
