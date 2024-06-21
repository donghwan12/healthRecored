package com.example.app.health.controller;

import com.example.app.health.domain.User.Dto.WorkoutDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MainController {

    @GetMapping("/main")
    public String main_get(Model model){
        log.info("GET/Main...");

        WorkoutDto workoutDto=new WorkoutDto();
        model.addAttribute("workoutDto",workoutDto);

        return "main";
    }

    @PostMapping("/main")
    public String processWorkout(@ModelAttribute("WorkoutDto") WorkoutDto workoutDto) {
        // 폼 데이터 처리 로직
        log.info("post/processWorkout/workoutDto : "+workoutDto);
        return "redirect:/main"; // 처리 후 리다이렉트하는 경우
    }

}
