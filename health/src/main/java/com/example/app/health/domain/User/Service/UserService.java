package com.example.app.health.domain.User.Service;

import com.example.app.health.domain.User.Dto.UserDto;
import com.example.app.health.domain.User.Entity.user;
import com.example.app.health.domain.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    UserDto userdto=new UserDto();




    @Autowired
    UserRepository userRepository;


    public boolean userjoin(UserDto userdto){

        //password vsrepassword
        if(!userdto.getPassword().equals(userdto.getRepassword())){
            System.out.println("패스워드가 일치하지않습니다.");
            return false;
        }
        if(userRepository.existsById(userdto.getId())){
            System.out.println("이미 아이디가 존재합니다.");
        return false;
        }
        user user=new user();
        user.setId(userdto.getId());

        //비밀번호 암호화
        user.setPassword(userdto.getPassword());
        user.setName(userdto.getName());
        user.setPhone(userdto.getPhone());
        user.setEmail(userdto.getEmail());
        user.setNickname(userdto.getNickname());

        //db에 저장한다.
        userRepository.save(user);
        return true;

    }
}
