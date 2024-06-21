package com.example.app.health.domain.User.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String part;
    private String kind;
    private String workout_set;
    private String time;
    private String date;

    // 다른 필드들...

    // session과의 관계 설정
    @ManyToOne(fetch = FetchType.LAZY) // FetchType.LAZY를 사용하여 지연 로딩 설정
    @JoinColumn(name = "session_id", nullable = false) // session_id 외래키
    private session session; // session 엔티티와 연결
}
