package com.sebasdevone.practiceCiCd.domain.ports.out;

import com.sebasdevone.practiceCiCd.domain.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserRepositoryPort {
    User save(User user);
    User findById(UUID id);
    User findByEmail(String email);
    Page<User> findAll(Pageable pageable);
    void deleteById(UUID id);
}
