package ra.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ra.edu.dto.DataResponse;
import ra.edu.entity.User;
import ra.edu.exception.NotFoundException;
import ra.edu.service.impl.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/api/v1/users/{id}")
    public ResponseEntity<DataResponse<User>> getUserById(@PathVariable Long id) throws NotFoundException {
        DataResponse<User> dataResponse = DataResponse.<User>builder()
                .success(true)
                .message("Successfully")
                .data(userService.getUserById(id))
                .build();
        return new ResponseEntity<>(dataResponse, HttpStatus.OK); // 200
    }
}
