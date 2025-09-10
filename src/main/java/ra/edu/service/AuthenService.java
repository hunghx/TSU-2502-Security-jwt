package ra.edu.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ra.edu.config.jwt.JWTProvider;
import ra.edu.dto.DataResponse;
import ra.edu.dto.FormLogin;
import ra.edu.dto.FormRegister;
import ra.edu.entity.Role;
import ra.edu.entity.RoleName;
import ra.edu.entity.User;
import ra.edu.repository.IRoleRepository;
import ra.edu.repository.IUserRepository;

import java.util.*;

@Service
@Slf4j
public class AuthenService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTProvider jwtProvider;
    public DataResponse<?> login(FormLogin request){
        // xacs thuc thong qua authentication manager
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        }catch (Exception e){
            log.error("Invalid username or password");
            log.warn("Invalid username or password",request.getUsername()+"-"+request.getPassword());
            return DataResponse.builder()
                    .success(false)
                    .error(e.getMessage())
                    .build();

        }

        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        log.info("Login Successful",user.getFullName() );
        // tao token
        Map<String, Object> map = new HashMap<>();
        map.put("token",jwtProvider.generateToken(request.getUsername()));
        map.put("type", "Bearer");
        map.put("username",request.getUsername());
        map.put("fullName", user.getFullName());
        map.put("role", user.getRoles());
        // tra ve thong tin chua token
        return DataResponse.builder()
                .success(true)
                .message("Login Successful")
                .data(map)
                .build();
    }

    public DataResponse<?> register(FormRegister request){
        Role role = null;
        // bien doi tu dto-> entity
        if (request.getRole()!=null && request.getRole().equals("manager")){
            role = roleRepository.findByRoleName(RoleName.ROLE_MANAGER).orElseThrow();
        }else {
            role = roleRepository.findByRoleName(RoleName.ROLE_USER).orElseThrow();
        }
        User user = new User(
                null,
                request.getFullName(),
                request.getEmail(),
                request.getPhone(),
                passwordEncoder.encode(request.getPassword()),
                request.getBirthDate(),
                Collections.singletonList(role)
        );
        userRepository.save(user);
        return DataResponse.builder()
                .success(true)
                .message("Register Successful")
                .build();
    }
}
