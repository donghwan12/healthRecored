package com.example.app.health.domain.User.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutDto {

    private long id;

    private String name;
    private String exercise;
    private String time;
    private String date;

    private SessionDto sessionDto;

    private List<WorkOutDetailDto> workoutdetails;  // 수정된 부분
}
