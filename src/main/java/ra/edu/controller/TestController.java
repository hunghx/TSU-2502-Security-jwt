package ra.edu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/api/user/test")
    public ResponseEntity<String> test1(){
        return ResponseEntity.ok("Hello World");
    }
    @GetMapping("/api/admin/test")
    public ResponseEntity<String> test2(){
        return ResponseEntity.ok("Hello World");
    }
    @GetMapping("/api/manager/test")
    public ResponseEntity<String> test3(){
        return ResponseEntity.ok("Hello World");
    }
}
