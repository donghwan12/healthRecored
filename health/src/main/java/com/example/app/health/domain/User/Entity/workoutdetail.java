package com.example.app.health.domain.User.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class workoutdetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String part;
    private String kind;
    private String exerciseSet;
    private String kg;
    private String number;

    @ManyToOne
    @JoinColumn(name="workout_id",foreignKey = @ForeignKey(name="FK_Workout_detail_0",
        foreignKeyDefinition = "FOREIGN KEY(workout_id) REFERENCES workout(id) on DELETE CASCADE ON UPDATE CASCADE"))
    private Workout workout;

}
