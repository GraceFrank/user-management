package com.user.usermanagement.service;

import com.user.usermanagement.shared.dto.UserDto;
import org.apache.catalina.User;

public interface UserService {
    UserDto createUser (UserDto user);
}
