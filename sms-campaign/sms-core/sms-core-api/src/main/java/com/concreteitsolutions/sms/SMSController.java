package com.concreteitsolutions.sms;

import com.concreteitsolutions.sms.model.CreditView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public interface SMSController {

	@RequestMapping(path = "/credit", method = RequestMethod.GET)
	CreditView findRemainingCredit();
}
