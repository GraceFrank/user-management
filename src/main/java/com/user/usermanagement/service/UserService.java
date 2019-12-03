package com.user.usermanagement.service;

import com.user.usermanagement.shared.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser (UserDto user);
}
