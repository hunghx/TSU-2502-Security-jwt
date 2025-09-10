package ra.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.entity.User;
import ra.edu.exception.NotFoundException;
import ra.edu.repository.IUserRepository;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    public User getUserById(Long id) throws NotFoundException{
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User with "+id+ " not found"));
    }
}
