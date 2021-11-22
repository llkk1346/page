package com.imy.page.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateUser {

    private String userId;
    private String userPw;
    private String userPwOverlap;
    private String userName;
    private String userY;
    private String userM;
    private String userD;
    private char userSex;
    private String userPhone;
    private char authority;


}
