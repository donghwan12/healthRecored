package com.example.app.health.domain.User.Service;

import com.example.app.health.domain.User.Dto.WorkOutDetailDto;
import com.example.app.health.domain.User.Dto.WorkoutDto;
import com.example.app.health.domain.User.Entity.User;
import com.example.app.health.domain.User.Entity.Workout;
import com.example.app.health.domain.User.Entity.session;
import com.example.app.health.domain.User.Entity.workoutdetail;
import com.example.app.health.domain.User.repository.SessionRepository;
import com.example.app.health.domain.User.repository.UserRepository;
import com.example.app.health.domain.User.repository.WorkOutDetailRepository;
import com.example.app.health.domain.User.repository.WorkOutRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MainService {
    WorkoutDto workoutDto;

    @Autowired
    WorkOutRepository workOutRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    WorkOutDetailRepository workOutDetailRepository;

    public WorkoutDto wokrout_add(WorkoutDto workoutDto){
        log.info("MainSErvice/wokrout_add/workoutDto : "+workoutDto);

        Workout workout=new Workout();
        workoutdetail workoutdetail=new workoutdetail();
        User user=userRepository.findByname(workoutDto.getName());
        String passowrd=user.getPassword();
        log.info("password : "+ passowrd);
        session session=sessionRepository.findBypassword(passowrd);
        log.info("session : "+session);


        workout.setDate(workoutDto.getDate());
        workout.setTime(workoutDto.getTime());
        workout.setId(workoutDto.getId());
        workout.setName(workoutDto.getName());
        workout.setExercise(workoutDto.getExercise());
        workout.setUser(user);
        log.info("worktou :  "+workout);



        List<workoutdetail> workoutDetails = workoutDto.getWorkoutdetails().stream().map(detailDto -> {
            workoutdetail detail = new workoutdetail();
//            detail.setPart(detailDto.getPart());
            detail.setKind(detailDto.getKind());
            detail.setExerciseSet(detailDto.getWorkout_set());
            detail.setKg(detailDto.getKg());
            detail.setNumber(detailDto.getNumber());
            detail.setWorkout(workout);
            return detail;
        }).collect(Collectors.toList());

        workout.setWorkoutDetails(workoutDetails);
        log.info("workout: " + workout);
        workOutRepository.save(workout);
//        log.info("workoutdetails : "+workoutdetail);
//        workOutDetailRepository.save(workoutdetail);
        return workoutDto;
    }


    //list 조회
    @Transactional(rollbackFor = Exception.class)
    public List<WorkoutDto> workoutList(){

        List<Workout> workouts = workOutRepository.findAll();
        log.info("workouts : "+workouts);
        List<WorkoutDto> workoutDtos = new ArrayList<>();

        for (Workout workout : workouts) {
            WorkoutDto workoutDto = new WorkoutDto();
            workoutDto.setId(workout.getId());
            workoutDto.setDate(workout.getDate());
            workoutDto.setExercise(workout.getExercise());
            workoutDto.setTime(workout.getTime());

            workoutDtos.add(workoutDto);
        }

        log.info("workoutDto : "+workoutDtos);
        return workoutDtos;
    }
    //상세읽기 서ㅣ스
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> Read(Long id) {
        log.info("MainService/read...!" + id);
        Map<String, Object> result = new HashMap();

        Optional<Workout> workout= (workOutRepository.findById(id));
        result.put("workout",workout);
        return result;
    }
}
