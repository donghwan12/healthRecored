package com.example.app.health.domain.User.Service;

import com.example.app.health.domain.User.Dto.WorkoutDto;
import com.example.app.health.domain.User.repository.SessionRepository;
import com.example.app.health.domain.User.repository.WorkOutRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MainService {
    WorkoutDto workoutDto;

    @Autowired
    WorkOutRepository workOutRepository;
    @Autowired
    SessionRepository sessionRepository;

    public WorkoutDto wokrout_add(WorkoutDto workoutDto){
        log.info("MainSErvice/wokrout_add/workoutDto : "+workoutDto);


        return workoutDto;
    }
}
