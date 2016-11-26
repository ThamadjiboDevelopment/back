package com.concreteitsolutions.generic.prospect;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concreteitsolutions.generic.prospect.model.Prospect;
import com.concreteitsolutions.generic.prospect.model.ProspectSearchCriteria;

@Component
public class ProspectProcessImpl implements ProspectProcess {

	private final ProspectService prospectService;

	@Autowired
	public ProspectProcessImpl(final ProspectService prospectService) {
		this.prospectService = prospectService;
	}

	public List<Prospect> find(final ProspectSearchCriteria criteria, final Integer length) {

		return prospectService.find(criteria, length);
	}
}
