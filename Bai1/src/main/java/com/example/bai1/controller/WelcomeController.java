package com.example.bai1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String home() {
        return "redirect:/welcome";
    }
    @GetMapping("/welcome")
    public String showWelcome(Model model) {
        model.addAttribute("staffName", "Nguyễn Văn An");
        // Trả về "welcome" -> Spring sẽ tự hiểu là /WEB-INF/views/welcome.jsp
        return "welcome";
    }
}
