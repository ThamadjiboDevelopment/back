package com.concreteitsolutions.generic.prospect;

import java.util.List;

import com.concreteitsolutions.generic.prospect.model.Prospect;

public interface ProspectRepository {

	/**
	 * Search with JPA criterias LATER ...
	 * 
	 * @return
	 */
	List<Prospect> find();
}
