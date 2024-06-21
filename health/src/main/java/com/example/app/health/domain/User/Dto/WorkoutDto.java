package com.example.app.health.domain.User.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutDto {

    private String id;
    private String part;
    private String kind;
    private String workout_set;
    private String time;
    private String date;
}
