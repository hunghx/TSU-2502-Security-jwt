package ra.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.edu.entity.User;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    // tạo 1 phuowng thức lấy thông tin người dùng theo username(email/phone)
    Optional<User> findByEmail(String email);
    @Query("from User where email = :username or phone = :username")
    Optional<User> findByUsername(@Param("username") String username);

}
