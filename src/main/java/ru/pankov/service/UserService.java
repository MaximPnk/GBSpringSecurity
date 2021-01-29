package ru.pankov.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.pankov.entity.Role;
import ru.pankov.entity.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<User> findByUsername(String username);

    Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles);

    Optional<User> findById(Long id);

    void saveOrUpdate(User user);
}
