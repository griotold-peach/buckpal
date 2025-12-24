package com.griotold.buckpal.account.application.port.in;

import com.griotold.buckpal.account.domain.Account.AccountId;
import com.griotold.buckpal.account.domain.Money;

public interface GetAccountBalanceQuery {

	Money getAccountBalance(AccountId accountId);

}
