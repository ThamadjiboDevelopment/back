package com.concreteitsolutions.sms.credit;

import com.concreteitsolutions.sms.credit.model.Credit;

public interface CreditService {

	Credit findRemainingCreditAndSMS();

}
