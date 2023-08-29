package com.proje.takip_istemi.service;

import com.proje.takip_istemi.dto.LoginDTO;
import com.proje.takip_istemi.dto.YoneticiDTO;
import com.proje.takip_istemi.response.AdminResponse;
import com.proje.takip_istemi.response.YoneticiResponse;

import java.util.List;

public interface AdminService {
    AdminResponse findAdmin(LoginDTO loginDTO);

    List<YoneticiDTO> findYoneticiByAdminId(int id);
}
