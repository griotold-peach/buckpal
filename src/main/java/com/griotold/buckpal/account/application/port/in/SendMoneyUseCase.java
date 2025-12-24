package com.griotold.buckpal.account.application.port.in;

/**
 * 송금 유스케이스 인터페이스
 * 
 * Inbound Port - 외부에서 애플리케이션으로 들어오는 요청
 */
public interface SendMoneyUseCase {
    
    boolean sendMoney(SendMoneyCommand command);
}