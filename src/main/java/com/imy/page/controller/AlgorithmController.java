package com.imy.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("algorithm")
public class AlgorithmController {

    @GetMapping("/algorithm")
    public String Algorithm() {
        return "algorithm/algorithm";
    }
}
