package com.proje.takip_istemi.service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proje.takip_istemi.dao.AppDAO;
import com.proje.takip_istemi.dto.LoginDTO;
import com.proje.takip_istemi.dto.YoneticiDTO;
import com.proje.takip_istemi.entity.Personel;
import com.proje.takip_istemi.entity.Yonetici;
import com.proje.takip_istemi.repository.YoneticiRepository;
import com.proje.takip_istemi.response.PersonelResponse;
import com.proje.takip_istemi.response.Response;
import com.proje.takip_istemi.response.YoneticiResponse;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YoneticiServiceImpl implements YoneticiService{

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    YoneticiRepository yoneticiRepository;

    @Autowired
    AppDAO appDAO;

    @Override
    public YoneticiDTO findYonetici(LoginDTO loginDTO) {
        Yonetici yonetici=yoneticiRepository.findByEmail(loginDTO.getUsername());

        return new YoneticiDTO(yonetici.getId(),yonetici.getName(),yonetici.getKurumAdi(),yonetici.getPersonelSayisi(),yonetici.getImage());


    }

    @Override
    public  List<PersonelResponse> findpersoneller(int theId) {
        List<Personel> personelList=appDAO.findPersonelByYoneticiId(theId);
        List<PersonelResponse> personeller = new ArrayList<>();

        int i=0;
        for(Personel personel:personelList){
            PersonelResponse p=new PersonelResponse(personel.getId(),personel.getName(),personel.getDepartment(),personel.getUnvan(),personel.getImage(),personel.getYetkinlikler(),theId);
            personeller.add(p);
            i++;
        }
        return personeller;


    }
}
