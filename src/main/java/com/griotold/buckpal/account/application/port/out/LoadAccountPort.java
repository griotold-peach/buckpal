package com.griotold.buckpal.account.application.port.out;

import com.griotold.buckpal.account.domain.Account;
import com.griotold.buckpal.account.domain.Account.AccountId;
import java.time.LocalDateTime;

/**
 * 계좌 조회 포트 (Outbound Port)
 * 
 * <p>Application에서 영속성 레이어로 나가는 포트
 */
public interface LoadAccountPort {

    /**
     * 특정 시점 기준으로 계좌를 조회한다
     * 
     * @param accountId 계좌 ID
     * @param baselineDate 기준 시점
     * @return 조회된 계좌
     */
    Account loadAccount(AccountId accountId, LocalDateTime baselineDate);
}