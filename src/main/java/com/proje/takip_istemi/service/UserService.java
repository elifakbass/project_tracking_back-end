package com.proje.takip_istemi.service;

import com.proje.takip_istemi.dto.LoginDTO;
import com.proje.takip_istemi.response.LoginMessage;

public interface UserService {

    LoginMessage loginUser(LoginDTO loginDTO);
}
