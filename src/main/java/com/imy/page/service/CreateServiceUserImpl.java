package com.imy.page.service;

import com.imy.page.dto.CreateUser;
import com.imy.page.repository.CreateUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CreateServiceUserImpl implements CreateServiceUser {
    @Autowired
    private CreateUserRepository createUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public int createUser(CreateUser createUser) {
        String encodedPassword = passwordEncoder.encode(createUser.getUserPw());
        String encodedPasswordOverlap = passwordEncoder.encode(createUser.getUserPwOverlap());
        createUser.setUserPw(encodedPassword);
        createUser.setUserPwOverlap(encodedPasswordOverlap);
        
        int returnData = createUserRepository.createUser(createUser);
        if(returnData!=1){
            return 0;
        }
        return returnData;
    }

    @Override
    public CreateUser selectUser(Map<String, Object> param) {
        CreateUser findUser = createUserRepository.selectUser(param);
        if(passwordEncoder.matches(param.get("userPw").toString(), findUser.getUserPw())){
            return findUser;
        }else{
            return null;
        }


    }
}
