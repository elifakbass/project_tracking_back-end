package com.proje.takip_istemi.service;

import com.proje.takip_istemi.dto.LoginDTO;
import com.proje.takip_istemi.entity.Personel;
import com.proje.takip_istemi.response.PersonelResponse;

public interface PersonelService {

    PersonelResponse findPersonel(LoginDTO loginDTO);
}
