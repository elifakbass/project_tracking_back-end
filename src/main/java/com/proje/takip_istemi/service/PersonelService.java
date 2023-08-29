package com.proje.takip_istemi.service;

import com.proje.takip_istemi.dto.LoginDTO;
import com.proje.takip_istemi.dto.PersonelDTO;
import com.proje.takip_istemi.entity.Personel;
import com.proje.takip_istemi.response.PersonelResponse;
import com.proje.takip_istemi.response.Response;

public interface PersonelService {

    PersonelResponse findPersonel(LoginDTO loginDTO);

    PersonelResponse getPersonel(int id);

    Response savePersonel(PersonelDTO personelDTO);

    Response deletePersonel(int id);

    Response updatePersonel(int id,PersonelDTO personelDTO);
}
