package com.concreteitsolutions.generic.prospect;

import java.util.List;

import com.concreteitsolutions.generic.prospect.model.Prospect;
import com.concreteitsolutions.generic.prospect.model.ProspectSearchCriteria;

public interface ProspectService {

	List<Prospect> find(final ProspectSearchCriteria criteria, final Integer length);
}
