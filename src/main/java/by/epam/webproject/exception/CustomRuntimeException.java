package by.epam.webproject.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CustomRuntimeException extends RuntimeException {

    private RuntimeExceptionCode exceptionCode;

    public CustomRuntimeException(RuntimeExceptionCode exceptionCode) {
        super(exceptionCode.generateMessage());
        this.exceptionCode = exceptionCode;
    }

    public CustomRuntimeException(RuntimeExceptionCode exceptionCode, String... messageParams) {
        super(exceptionCode.generateMessage(messageParams));
        this.exceptionCode = exceptionCode;
    }

    public RuntimeExceptionCode getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(RuntimeExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
