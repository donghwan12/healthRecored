package com.example.app.health.controller;

import com.example.app.health.domain.User.Dto.SessionDto;
import com.example.app.health.domain.User.Dto.UserDto;
import com.example.app.health.domain.User.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("sessionDto", new SessionDto());
        return "home";
    }

    @PostMapping("/")
    public String home_post(@ModelAttribute("sessionDto") SessionDto sessionDto, Model model) {
        log.info("sessionDto : " + sessionDto);
        SessionDto logSession = userService.UserLogin(sessionDto);

        if (logSession != null) {
            return "redirect:/main";
        } else {
            // 로그인 실패 시에도 반드시 sessionDto를 다시 넣어준다
            model.addAttribute("sessionDto", sessionDto);
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "home";
        }
    }
}