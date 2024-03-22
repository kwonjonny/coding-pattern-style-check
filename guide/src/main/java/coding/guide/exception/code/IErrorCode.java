package coding.guide.exception.code;

import org.springframework.http.HttpStatus;

public interface IErrorCode {
    String getCode();

    String getMessage();

    HttpStatus getHttpStatus();
}
