package ra.edu.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class FormRegister {
    private String fullName;
    private String email;
    private String phone;
    private String password;
    private LocalDate birthDate;
    private String role;
}
