package com.example.app.health.domain.User.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkOutDetailDto {

    private String part;
    private String kind;
    private String workout_set;
    private String kg;
    private String number;
}
