package com.proje.takip_istemi.service;

import com.proje.takip_istemi.dao.AppDAO;
import com.proje.takip_istemi.dto.LoginDTO;
import com.proje.takip_istemi.dto.PersonelDTO;
import com.proje.takip_istemi.entity.Personel;
import com.proje.takip_istemi.entity.Yonetici;
import com.proje.takip_istemi.repository.PersonelRepository;
import com.proje.takip_istemi.repository.YoneticiRepository;
import com.proje.takip_istemi.response.PersonelResponse;
import com.proje.takip_istemi.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonelServiceImpl implements PersonelService{

    @Autowired
    PersonelRepository personelRepository;

    @Autowired
    YoneticiRepository yoneticiRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AppDAO appDAO;


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

    @Override
    public PersonelResponse getPersonel(int id) {
        Optional<Personel> personel=personelRepository.findById(id);
        if(personel.isPresent()){
            Personel temp=personel.get();
            Yonetici yonetici=temp.getYonetici();
            PersonelResponse response=new PersonelResponse(temp.getId(),temp.getName(),temp.getDepartment(),temp.getUnvan(),temp.getImage(),temp.getYetkinlikler(), yonetici.getId());
            return response;
        }
        return new PersonelResponse("personel bulunamadi");
    }

    @Override
    public Response savePersonel(PersonelDTO personelDTO) {
        String password=passwordEncoder.encode(personelDTO.getPassword());
        Personel personel=new Personel(personelDTO.getName(),personelDTO.getEmail(),password,personelDTO.getDepartment(), personelDTO.getUnvan(), personelDTO.getYetkinlikler(), personelDTO.getImage());
        Optional<Yonetici> yonetici=yoneticiRepository.findById(personelDTO.getYonetici_id());

        Yonetici yonetici1=null;
        if(yonetici.isPresent()){
            yonetici1=yonetici.get();
            personel.setYonetici(yonetici1);
        }
        personelRepository.save(personel);



        return new Response(yonetici1.getName()+" adlı yönetici, personel oluşturdu. id:"+personel.getId(),true);


    }

    @Override
    public Response deletePersonel(int id) {
        Optional<Personel> personel=personelRepository.findById(id);

        if(personel.isPresent()){
            Personel personel1=personel.get();
            personelRepository.delete(personel1);
            return new Response("personel silindi id: "+id,true);
        }

        return new Response("personel bulunamadi",false);

    }

    @Override
    public Response updatePersonel(int id, PersonelDTO personelDTO) {
        Optional<Personel> personel=personelRepository.findById(id);

        if(personel.isPresent()){
            Personel personel1=personel.get();
            personel1.setName(personelDTO.getName());
            personel1.setDepartment(personelDTO.getDepartment());
            personel1.setUnvan(personelDTO.getUnvan());
            personel1.setYetkinlikler(personelDTO.getYetkinlikler());

            appDAO.updatePersonel(personel1);

            return new Response("Personel güncellendi id:"+id,true);


        }
        return new Response("Personel bulunamadi",false);
    }
}
