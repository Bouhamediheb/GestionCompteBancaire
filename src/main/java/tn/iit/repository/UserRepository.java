package tn.iit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iit.beans.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
