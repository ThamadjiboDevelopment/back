package com.concreteitsolutions.sms.credit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concreteitsolutions.sms.credit.model.Credit;

@Component
public class CreditServiceImpl implements CreditService {

	private final CreditDao creditDao;

	@Autowired
	public CreditServiceImpl(CreditDao creditDao) {
		this.creditDao = creditDao;
	}

	public Credit findRemainingCreditAndSMS() {
		return creditDao.findRemainingCreditAndSMS();
	}
}
