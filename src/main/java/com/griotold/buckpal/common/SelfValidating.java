package com.griotold.buckpal.common;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;

/**
 * Self-Validating 패턴 지원
 * 
 * <p>사용 방법:
 * <ul>
 *   <li>Class: extends SelfValidating&lt;T&gt; → validateSelf() 호출</li>
 *   <li>Record: SelfValidating.validate(this) 호출</li>
 * </ul>
 */
public abstract class SelfValidating<T> {

    private static final Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * 인스턴스 메서드 (extends 방식)
     */
    @SuppressWarnings("unchecked")
    protected void validateSelf() {
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    /**
     * Static 메서드 (record 방식)
     */
    public static <T> void validate(T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}