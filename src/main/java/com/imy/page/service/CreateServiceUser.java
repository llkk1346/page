package com.imy.page.service;

import com.imy.page.dto.CreateUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface CreateServiceUser {
    int createUser(CreateUser createUser);
    CreateUser selectUser(Map<String, Object> param);

}
