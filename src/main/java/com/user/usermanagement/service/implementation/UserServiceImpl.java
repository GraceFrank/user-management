package com.user.usermanagement.service.implementation;

import com.user.usermanagement.UserRepository;
import com.user.usermanagement.io.entity.UserEntity;
import com.user.usermanagement.service.UserService;
import com.user.usermanagement.shared.Utils;
import com.user.usermanagement.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
   public  UserDto createUser (UserDto user){
        UserEntity existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser != null) throw new  RuntimeException("Record already exist");

        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(user, userEntity);

        userEntity.setUserId(utils.generatedUserId(30)  );
        userEntity.setEncryptedPassword("test");

        UserEntity storedUserDetails =  userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }
}
