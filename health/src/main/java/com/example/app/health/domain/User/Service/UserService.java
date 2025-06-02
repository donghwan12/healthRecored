package com.example.app.health.domain.User.Service;

import com.example.app.health.domain.User.Dto.SessionDto;
import com.example.app.health.domain.User.Dto.UserDto;
import com.example.app.health.domain.User.Entity.session;
import com.example.app.health.domain.User.Entity.User;
import com.example.app.health.domain.User.repository.SessionRepository;
import com.example.app.health.domain.User.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.Optional;

@Slf4j
@Service
public class UserService {
    UserDto userdto=new UserDto();

    session session=new session();

    SessionDto sessionDto=new SessionDto();


    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    UserRepository userRepository;

//회원가입==============
    @Transactional(rollbackFor = Exception.class)
    public boolean userjoin(UserDto userdto, Model model){

        log.info("UserJoin/UserService/userjoin...");
        //password vsrepassword
        if(!userdto.getPassword().equals(userdto.getRepassword())){
            System.out.println("패스워드가 일치하지않습니다.");
            return false;
        }
        if(userRepository.existsById(userdto.getId())){
            System.out.println("이미 아이디가 존재합니다.");
        return false;
        }
        User user=new User();
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
    public SessionDto UserLogin(SessionDto sessionDto){
        log.info("UserService/userLogin/userDto : "+sessionDto);
        UserDto userDto=new UserDto();
        userDto.setName(String.valueOf(userRepository.existsById(sessionDto.getId())));

        log.info("userDto.setname : " +userDto.getName());

        Optional<User> userOptional=userRepository.findById(sessionDto.getId());

        //아이디,패스워드가 존재하지 않는경우.
        if(userOptional.isEmpty()){
            log.info("입력하신 아이디가 존재하지않습니다");
            return null;
        }
        User user=userOptional.get();

        if(!sessionDto.getId().equals(user.getId())){
            log.info("입력하신 아이디가 존재하지않습니다.");
            return null;
        }
        if(!sessionDto.getPassword().equals(user.getPassword())){
            log.info("입력하신 비밀번호가 존재하지않습니다.");
            return null;
        }


        session.setId(sessionDto.getId());
        session.setPassword(sessionDto.getPassword());
        session.setName(String.valueOf(userDto.getName()));
        log.info("session : "+session);
        sessionRepository.save(session);
        log.info("로그인에 성공했습니다.");
        return sessionDto;
    }

}
