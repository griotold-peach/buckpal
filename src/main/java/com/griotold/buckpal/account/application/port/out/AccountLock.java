package com.griotold.buckpal.account.application.port.out;

import com.griotold.buckpal.account.domain.Account.AccountId;

/**
 * 계좌 잠금 포트 (Outbound Port)
 * 
 * <p>동시성 제어를 위한 계좌 잠금 인터페이스
 * <p>송금 시 출금/입금 계좌를 잠가서 동시 접근을 방지
 */
public interface AccountLock {

    /**
     * 계좌를 잠근다 (Lock)
     * 
     * @param accountId 잠글 계좌 ID
     */
    void lockAccount(AccountId accountId);

    /**
     * 계좌 잠금을 해제한다 (Unlock)
     * 
     * @param accountId 잠금 해제할 계좌 ID
     */
    void releaseAccount(AccountId accountId);
}