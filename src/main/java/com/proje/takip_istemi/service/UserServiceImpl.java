package com.proje.takip_istemi.service;

import com.proje.takip_istemi.dto.LoginDTO;
import com.proje.takip_istemi.entity.Admin;
import com.proje.takip_istemi.entity.Personel;
import com.proje.takip_istemi.entity.User;
import com.proje.takip_istemi.entity.Yonetici;
import com.proje.takip_istemi.repository.PersonelRepository;
import com.proje.takip_istemi.repository.UserRepository;
import com.proje.takip_istemi.repository.YoneticiRepository;
import com.proje.takip_istemi.response.LoginMessage;
import com.proje.takip_istemi.response.UsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;


    private PasswordEncoder passwordEncoder;


    @Autowired
    private PersonelRepository personelRepository;

    @Autowired
    YoneticiRepository yoneticiRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user = userRepository.findByUsername(loginDTO.getUsername());
        if (user != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user1 = userRepository.findOneByUsernameAndPassword(loginDTO.getUsername(), encodedPassword);
                if (user1.isPresent()) {
                    return new LoginMessage("Login Success", true,user.getRole());
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {

                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("Email not exits", false);
        }




    }

    @Override
    public List<UsersResponse> findKullaniciler() {
        List<UsersResponse> responses=new ArrayList<>();

      List<User> users=userRepository.findAll();

      for(User user:users){
          if(user.getRole() != 3){
              UsersResponse response =new UsersResponse(user.getId(),user.getUsername(),user.getImage());
              responses.add(response);
          }
      }
        return responses;
    }

}