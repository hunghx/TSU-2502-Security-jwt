package ra.edu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/api/user/test")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> test1(){
        return ResponseEntity.ok("Hello World");
//        2025-09-10T18:51:26.882+07:00  INFO 5824 --- [security-jwt] [nio-9999-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
    }
    @GetMapping("/api/admin/test")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> test2(){
        return ResponseEntity.ok("Hello World");
    }
    @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    @GetMapping("/api/manager/test")
    public ResponseEntity<String> test3(){
        return ResponseEntity.ok("Hello World");
    }
}
