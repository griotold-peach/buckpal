package com.griotold.buckpal.account.application.port.in;

import com.griotold.buckpal.account.domain.Account.AccountId;
import com.griotold.buckpal.account.domain.Money;
import com.griotold.buckpal.common.SelfValidating;
import jakarta.validation.constraints.NotNull;

/**
 * 송금 유스케이스의 입력 커맨드
 * 
 * <p>Self-Validating 패턴을 사용하여 생성 시점에 유효성 검증
 */
public record SendMoneyCommand(
    @NotNull AccountId sourceAccountId,
    @NotNull AccountId targetAccountId,
    @NotNull Money money
) {
    
    /**
     * Compact Constructor - 생성 시 자동 유효성 검증
     */
    public SendMoneyCommand {
        SelfValidating.validate(this);
    }
}