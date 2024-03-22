package coding.guide.board.exception;

import org.springframework.http.HttpStatus;

import coding.guide.exception.code.IErrorCode;

public enum BoardErrorEnum implements IErrorCode {

    NOT_FOUND_BOARD("B001", "해당하는 게시물이 없습니다.", HttpStatus.NOT_FOUND);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    BoardErrorEnum(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
