package com.usermgmt.service;

import com.usermgmt.model.UserRequest;
import com.usermgmt.model.UserResponse;

public interface UserManagementService {
    UserResponse fetchUser(String mobileNumber);

    UserResponse createUser(UserRequest userRequest) ;
}
