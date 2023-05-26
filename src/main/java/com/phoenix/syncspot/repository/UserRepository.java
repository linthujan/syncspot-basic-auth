package com.phoenix.syncspot.repository;

import com.phoenix.syncspot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findUserByFileId(Long id);
    public User findByUsername(String regNo);
    boolean existsByUsername(String username);
}
