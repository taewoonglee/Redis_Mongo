package com.test.service;

import com.test.domain.dto.User;
import com.test.domain.request.LoginRequest;
import com.test.domain.request.SignupRequest;

public interface UserService {



    User login(LoginRequest loginRequest);

    boolean signup(SignupRequest signupRequest);
}
