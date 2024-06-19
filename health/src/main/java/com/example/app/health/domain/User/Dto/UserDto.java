package com.example.app.health.domain.User.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private String id;
    @NotBlank(message="username을 입력하세요")
    private String name;
    private String email;
    private String nickname;
    @NotBlank(message="password 입력하세요")
    @Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$",message="'숫자','문자','특수문자' 무조건 1개 이상, 비밀번호 '최소 8자에서 최대 16자'까지 허용됩니다" )
    private String password;

    @NotBlank(message="repassword 입력하세요")
    @Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$",message="'숫자','문자','특수문자' 무조건 1개 이상, 비밀번호 '최소 8자에서 최대 16자'까지 허용됩니다" )
    private String repassword;
    @NotBlank(message="기본주소를 입력하세요")
    private String addr;
    private String addrDetails;
    private String phone;

}
