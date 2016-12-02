package com.concreteitsolutions.generic.prospect;

import java.util.Arrays;
import java.util.List;

import com.concreteitsolutions.generic.prospect.model.PreferenceCategory;
import com.concreteitsolutions.generic.prospect.model.Prospect;
import org.springframework.stereotype.Component;

@Component
public class ProspectRepositorImplMock implements ProspectRepository {

	public List<Prospect> find() {
		Prospect prospect = new Prospect("Tahirou", "DJIBO", "0635338517", Arrays.asList(PreferenceCategory.SPORT), null);

		return Arrays.asList(prospect);
	}
}
