package com.imy.page.repository;

import com.imy.page.dto.CreateUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
@Mapper
public interface CreateUserRepository {

    int createUser(CreateUser createUser);
    CreateUser selectUser(Map<String, Object> param);

}
