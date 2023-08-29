package com.proje.takip_istemi.service;

import com.proje.takip_istemi.dto.LoginDTO;
import com.proje.takip_istemi.response.LoginMessage;
import com.proje.takip_istemi.response.UsersResponse;

import javax.swing.event.ListDataEvent;
import java.util.List;

public interface UserService {

    LoginMessage loginUser(LoginDTO loginDTO);

    List<UsersResponse> findKullaniciler();
}
