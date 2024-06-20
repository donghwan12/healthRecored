package com.example.app.health.domain.User.Service;

import com.example.app.health.domain.User.Dto.UserDto;
import com.example.app.health.domain.User.Entity.user;
import com.example.app.health.domain.User.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@Slf4j
@Service
public class UserService {
    UserDto userdto=new UserDto();




    @Autowired
    UserRepository userRepository;

//회원가입==============
    @Transactional(rollbackFor = Exception.class)
    public boolean userjoin(UserDto userdto, Model model){

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

    //로그인처리
    @Transactional(rollbackFor = Exception.class)
    public UserDto UserLogin(UserDto userDto){
        log.info("UserService/userLogin/userDto : "+userDto);
        user user=new user();

        //아이디,패스워드가 존재하지 않는경우.
        if(!userDto.getId().equals(user.getId())){
            log.info("입력하신 아이디가 존재하지않습니다");
            return null;
        }
        if(!userDto.getPassword().equals(user.getPassword())){
            log.info("입력하신 비밀번호가 존재하지않습니다.");
            return null;

        }
        //로그인성공
        if(userDto.getId().equals(user.getId())){
            if( userDto.getPassword().equals(user.getPassword())){
                log.info("로그인에 성공하셨씁니다.");
                return userDto;
            }
        }

        return userDto;
    }
}
