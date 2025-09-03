package ra.edu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // tạo ra các tài khoản cứng
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN").build();
//        UserDetails user = User.withUsername("user").password(passwordEncoder().encode("user123")).roles("USER").build();
//        return new InMemoryUserDetailsManager(admin,user);
//    }


}
