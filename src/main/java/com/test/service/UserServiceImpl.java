//package com.test.service;
//
//import com.test.dao.UserDao;
//import com.test.domain.dto.User;
//import com.test.domain.request.LoginRequest;
//import com.test.domain.request.SignupRequest;
//import org.springframework.stereotype.Service;
//
//public class UserServiceImpl implements UserService {
//    private final UserDao userDao;
//
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//
//    @Override
//    public User login(LoginRequest loginRequest) {
//        return userDao.Login(loginRequest);
//    }
//
//    @Override
//    public boolean signup(SignupRequest signupRequest) {
//        return userDao.Signup(signupRequest);
//    }
//}
