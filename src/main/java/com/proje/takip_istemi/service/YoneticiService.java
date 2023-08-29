package com.proje.takip_istemi.service;

import com.proje.takip_istemi.dto.LoginDTO;
import com.proje.takip_istemi.dto.YoneticiDTO;
import com.proje.takip_istemi.entity.Yonetici;
import com.proje.takip_istemi.response.PersonelResponse;
import com.proje.takip_istemi.response.Response;
import com.proje.takip_istemi.response.YoneticiResponse;

import java.util.List;

public interface YoneticiService {

    YoneticiDTO findYonetici(LoginDTO loginDTO);

    List<PersonelResponse> findpersoneller(int theId);

    Response saveYonetici(YoneticiDTO yoneticiDTO);

    Response deleteYonetici(int id);

    Response updateYonetici(int id,YoneticiDTO yoneticiDTO);
}
