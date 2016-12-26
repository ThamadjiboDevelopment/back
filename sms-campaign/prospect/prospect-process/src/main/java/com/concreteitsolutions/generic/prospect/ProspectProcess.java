package com.concreteitsolutions.generic.prospect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import com.concreteitsolutions.generic.prospect.model.Prospect;
import com.concreteitsolutions.generic.prospect.model.ProspectSearchCriteria;

public interface ProspectProcess {

	List<Prospect> find(final ProspectSearchCriteria criteria, final Integer length);

	List<Prospect> find(final long length);

}
