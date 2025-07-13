package com.kce.service;

import com.kce.models.Users;
import com.kce.response.CommonResponce;

public interface UserService {
    public CommonResponce register(Users users);
    String verify(Users user);
}
