package com.example.app.health.domain.User.Dto;

import com.example.app.health.domain.User.Entity.session;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutDto {

    private Long id;

    private String name;
    private String part;
    private String kind;
    private String workout_set;
    private String kg;
    private String time;
    private String date;

    private SessionDto sessionDto;

}
