package com.imy.page.controller;

import com.imy.page.dto.CreateUser;
import com.imy.page.service.CreateServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private CreateServiceUser createServiceUser;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    //로그인화면이동
    @GetMapping("membership/login")
    public String loginPage() {
        return "membership/login";
    }

    @GetMapping("membership/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/createUserForm")
    public String createUserForm() {
        return "membership/createUserForm";
    }

    @PostMapping("/membership/createUserForm")
    public ResponseEntity<Void> createUser(CreateUser createUser) {
        int returnData = createServiceUser.createUser(createUser);

        if (returnData == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/loginCheck")
    public String loginCheck(@RequestParam Map<String, Object> param, HttpSession session, Model model) {
        CreateUser findUser = createServiceUser.selectUser(param);

        if(findUser==null){
            model.addAttribute("userNot", "아이디 또는 비밀번호가 잘못 입력 되었습니다. 아이디와 비밀번호를 정확히 입력해주세요");
            return "membership/login";
        } else {
            session.setAttribute("loginUser", findUser.getUserId());
            model.addAttribute("userYes", findUser.getUserId());
        }
        return "redirect:/";
    }
}
