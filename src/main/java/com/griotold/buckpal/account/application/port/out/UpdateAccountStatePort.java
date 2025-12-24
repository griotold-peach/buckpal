package com.griotold.buckpal.account.application.port.out;

import com.griotold.buckpal.account.domain.Account;

/**
 * 계좌 상태 업데이트 포트 (Outbound Port)
 * 
 * <p>Application에서 영속성 레이어로 나가는 포트
 */
public interface UpdateAccountStatePort {

    /**
     * 계좌의 활동(Activity) 정보를 저장한다
     * 
     * @param account 저장할 계좌
     */
    void updateActivities(Account account);
}
