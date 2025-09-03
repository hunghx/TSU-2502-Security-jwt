package ra.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ra.edu.entity.Role;
import ra.edu.entity.RoleName;
import ra.edu.entity.User;
import ra.edu.repository.IRoleRepository;
import ra.edu.repository.IUserRepository;

import java.time.LocalDate;
import java.util.Collections;

@SpringBootApplication
public class SecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityJwtApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(IRoleRepository roleRepository, IUserRepository userRepository, PasswordEncoder passwordEncoder){
        return args ->{
//            Role r1 = new Role(null, RoleName.ROLE_ADMIN);
//            Role r2 = new Role(null, RoleName.ROLE_USER);
//            Role r3 = new Role(null, RoleName.ROLE_MANAGER);
//            roleRepository.save(r1);
//            roleRepository.save(r2);
//            roleRepository.save(r3);
//            Role r1 = roleRepository.findByRoleName(RoleName.ROLE_ADMIN).orElseThrow();
//            Role r2 = roleRepository.findByRoleName(RoleName.ROLE_USER).orElseThrow();
//            Role r3 = roleRepository.findByRoleName(RoleName.ROLE_MANAGER).orElseThrow();
//
//            User u1 = new User(null, "admin","admin@gmail.com",null,passwordEncoder.encode("admin123"), LocalDate.of(2000,10,10), Collections.singletonList(r1));
//            User u2 = new User(null, "hunghx","hunghx@gmail.com","0983625744",passwordEncoder.encode("hung123"), LocalDate.of(2000,10,10), Collections.singletonList(r2));
//            userRepository.save(u1);
//            userRepository.save(u2);

        } ;
    }
}
