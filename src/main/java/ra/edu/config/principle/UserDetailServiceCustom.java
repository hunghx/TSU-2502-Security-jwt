package ra.edu.config.principle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ra.edu.entity.User;
import ra.edu.exception.NotFoundException;
import ra.edu.repository.IUserRepository;

import java.util.List;

@Service
@Slf4j
public class UserDetailServiceCustom implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("login by username: "+username);
        // logic username là gì>>>>>
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("ko tìm thấy username"));
        List<SimpleGrantedAuthority> roles = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .toList();
//       UserDetails userDetails = UserDetailCustom.builder()
//               .username(username)
//               .password(user.getPassword())
//               .authorities(roles)
//               .build();
//        return userDetails;
        UserDetailCustom userDetails = new UserDetailCustom();
        userDetails.setUsername(username);
        userDetails.setPassword(user.getPassword());
        userDetails.setAuthorities(roles);
        return userDetails;
    }
}
