package com.proje.takip_istemi.service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proje.takip_istemi.dao.AppDAO;
import com.proje.takip_istemi.dto.LoginDTO;
import com.proje.takip_istemi.dto.YoneticiDTO;
import com.proje.takip_istemi.entity.Admin;
import com.proje.takip_istemi.entity.Personel;
import com.proje.takip_istemi.entity.Yonetici;
import com.proje.takip_istemi.repository.AdminRepository;
import com.proje.takip_istemi.repository.YoneticiRepository;
import com.proje.takip_istemi.response.PersonelResponse;
import com.proje.takip_istemi.response.Response;
import com.proje.takip_istemi.response.YoneticiResponse;
import jakarta.transaction.Transactional;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class YoneticiServiceImpl implements YoneticiService{

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    YoneticiRepository yoneticiRepository;

    @Autowired
    AppDAO appDAO;

    @Autowired
    AdminRepository adminRepository;

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

    @Override
    @Transactional
    public Response saveYonetici(YoneticiDTO yoneticiDTO) {
        String password= passwordEncoder.encode(yoneticiDTO.getPassword());
        Yonetici yonetici=new Yonetici(yoneticiDTO.getName(),yoneticiDTO.getEmail(),password,yoneticiDTO.getKurumAdi(),yoneticiDTO.getPersonelSayisi(), yoneticiDTO.getImage());
        Optional<Admin> admin=adminRepository.findById(yoneticiDTO.getAdmin_id());

        if(admin.isPresent()){
            Admin admin1=admin.get();
            yonetici.setAdmin(admin1);

        }
        yoneticiRepository.save(yonetici);
        return new Response("Yönetici Kaydedildi id: "+yonetici.getId(),true);

    }

    @Override
    public Response deleteYonetici(int id) {
        Optional<Yonetici> yonetici=yoneticiRepository.findById(id);

        if(yonetici.isPresent()){
            Yonetici yonetici1=yonetici.get();

            yoneticiRepository.delete(yonetici1);
            return new Response("yonetici silindi id: "+id,true);
        }
        return new Response("yönetici bulunamadi",false);
    }

    @Override
    public Response updateYonetici(int id,YoneticiDTO yoneticiDTO) {
        Optional<Yonetici> yonetici=yoneticiRepository.findById(id);
        if(yonetici.isPresent()){
            Yonetici yonetici1=yonetici.get();
            yonetici1.setName(yoneticiDTO.getName());
            yonetici1.setKurumAdi(yoneticiDTO.getKurumAdi());
            yonetici1.setPersonelSayisi(yoneticiDTO.getPersonelSayisi());

            appDAO.updateYonetici(yonetici1);

            return new Response("Yonetici guncellendi id :"+ id,true);


        }
        return new Response("Yonetici bulunamadi",false);
    }
}
