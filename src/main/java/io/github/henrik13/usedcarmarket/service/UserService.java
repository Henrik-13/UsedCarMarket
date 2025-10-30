package io.github.henrik13.usedcarmarket.service;

import io.github.henrik13.usedcarmarket.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User createUser(User user);

    boolean existsByUsername(String username);

    String authenticate(User user);
}
