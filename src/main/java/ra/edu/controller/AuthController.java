package ra.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.dto.DataResponse;
import ra.edu.dto.FormLogin;
import ra.edu.dto.FormRegister;
import ra.edu.service.impl.AuthenService;

@RestController
//@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {
    /*
    *
    * */
    @Autowired
    private AuthenService authenService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody FormLogin request){
        DataResponse response = authenService.login(request);
        if (response.isSuccess()){
            return ResponseEntity.ok(response); // 200
        }else  {
            return ResponseEntity.badRequest().body(response); // 400
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody FormRegister request){
        return new ResponseEntity<>(authenService.register(request), HttpStatus.CREATED); // 201
    }
}
