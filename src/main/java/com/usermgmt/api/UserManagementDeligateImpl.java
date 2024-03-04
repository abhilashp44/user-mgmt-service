package com.usermgmt.api;

import com.usermgmt.model.UserRequest;
import com.usermgmt.model.UserResponse;
import com.usermgmt.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserManagementDeligateImpl implements UserApiDelegate {

    private final UserManagementService userManagementService;

    @Override
    public ResponseEntity<UserResponse> getUserByMobileNumber(String mobileNumber) {

        return ResponseEntity.status(HttpStatus.OK).body(userManagementService.fetchUser(mobileNumber));
    }

    @Override
    public ResponseEntity<UserResponse> createUser(UserRequest userRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(userManagementService.createUser(userRequest));
    }


}
