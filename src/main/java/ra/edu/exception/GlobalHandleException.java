package ra.edu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.edu.dto.DataResponse;

@RestControllerAdvice // xử lý các ngoại lệ đc sinh ra từ controller
public class GlobalHandleException {
    // xử lý notfound
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<DataResponse<?>> handleNotFound(NotFoundException e){
        DataResponse<?> dataResponse = DataResponse.builder()
                .success(false)
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(dataResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<DataResponse<?>> handleNotFound(HttpRequestMethodNotSupportedException e){
        DataResponse<?> dataResponse = DataResponse.builder()
                .success(false)
                .message("NOT ALLOW METHOD")
                .error(e.getStackTrace())
                .build();
        return new ResponseEntity<>(dataResponse, HttpStatus.METHOD_NOT_ALLOWED); // 405
    }
}