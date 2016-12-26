package com.concreteitsolutions.generic.prospect;

import java.io.InputStream;
import java.util.List;

import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concreteitsolutions.generic.prospect.model.Prospect;
import com.concreteitsolutions.generic.prospect.model.ProspectSearchCriteria;

@Component
public class ProspectServiceImpl implements ProspectService {

	private ProspectRepository prospectRepository;

	@Autowired
	public ProspectServiceImpl(ProspectRepository prospectRepository) {
		this.prospectRepository = prospectRepository;
	}

	public List<Prospect> find(long length) {
		return prospectRepository.findAll();
	}

	public List<Prospect> find(ProspectSearchCriteria criteria, Integer length) {
		return null;
	}

	public void saveAll(List<Prospect> prospects) {

		for(Prospect prospect : prospects) {
			prospectRepository.save(prospect);
		}
	}

}
