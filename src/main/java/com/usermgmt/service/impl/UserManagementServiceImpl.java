package com.usermgmt.service.impl;

import com.usermgmt.entity.UserEntity;
import com.usermgmt.exception.RecordAlreadyExistException;
import com.usermgmt.model.UserRequest;
import com.usermgmt.model.UserResponse;
import com.usermgmt.reposotory.UserRepository;
import com.usermgmt.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserManagementServiceImpl implements UserManagementService {

    private final UserRepository userRepository;

    @Override
    public UserResponse fetchUser(String mobileNumber) {

        return userRepository.findByMobileNumber(mobileNumber).map(this::convertUserEntityToUserResponse)
                .orElse(new UserResponse());
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {

        Optional<UserEntity> user = userRepository.findByMobileNumber(userRequest.getMobileNumber());
        if(user.isPresent()) {
            throw new RecordAlreadyExistException();
        }
        return convertUserEntityToUserResponse(userRepository.save(convertUserUserRequestToUserEntity(userRequest)));
    }

    private UserResponse convertUserEntityToUserResponse(UserEntity userEntity) {

        return new UserResponse().userId(userEntity.getUserId().toString()).firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .mobileNumber(userEntity.getMobileNumber());
    }

    private UserEntity convertUserUserRequestToUserEntity(UserRequest userRequest) {

        return UserEntity.builder().firstName(userRequest.getFirstName()).lastName(userRequest.getLastName())
                .mobileNumber(userRequest.getMobileNumber()).build();
    }
}
