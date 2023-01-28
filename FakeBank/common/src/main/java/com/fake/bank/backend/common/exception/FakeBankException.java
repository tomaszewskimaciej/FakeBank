package com.fake.bank.backend.common.exception;

import com.fake.bank.backend.common.exception.type.FakeBankErrorType;
import lombok.Getter;

@Getter
public class FakeBankException extends RuntimeException {
    private FakeBankErrorType errorType;

    public FakeBankException(FakeBankErrorType errorType) {
        super(errorType.getValue());
        this.errorType = errorType;
    }
}
