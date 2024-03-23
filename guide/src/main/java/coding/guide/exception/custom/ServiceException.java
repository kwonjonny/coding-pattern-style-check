package coding.guide.exception.custom;

import coding.guide.exception.code.IErrorCode;

public class ServiceException extends RuntimeException {

    private IErrorCode errorCode;

    public ServiceException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ServiceException(String message, IErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}