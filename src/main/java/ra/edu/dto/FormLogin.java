package ra.edu.dto;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class FormLogin {
    private String username; // email or phone
    private String password;
}
