package com.proje.takip_istemi.service;

import com.proje.takip_istemi.dto.LoginDTO;
import com.proje.takip_istemi.entity.Personel;
import com.proje.takip_istemi.entity.Yonetici;
import com.proje.takip_istemi.repository.PersonelRepository;
import com.proje.takip_istemi.repository.YoneticiRepository;
import com.proje.takip_istemi.response.PersonelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonelServiceImpl implements PersonelService{

    @Autowired
    PersonelRepository personelRepository;

    @Autowired
    YoneticiRepository yoneticiRepository;


    @Override
    public PersonelResponse findPersonel(LoginDTO loginDTO) {
        Personel personel=personelRepository.findByEmail(loginDTO.getUsername());
        Yonetici yonetici=personel.getYonetici();
        if(personel != null){
            PersonelResponse response=new PersonelResponse(personel.getId(),personel.getName(),personel.getDepartment(),personel.getUnvan(),personel.getImage(),personel.getYetkinlikler(),yonetici.getId());
            return response;
        }
        return new PersonelResponse("Personel Bulunamadi.");
    }
}
