package ra.edu.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
//@NoArgsConstructor
public class DataResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private Object error;
    private LocalDateTime timestamp; // thời gian trả về
}
