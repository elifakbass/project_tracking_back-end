package com.proje.takip_istemi.service;

import com.proje.takip_istemi.dto.YorumDTO;
import com.proje.takip_istemi.entity.Personel;
import com.proje.takip_istemi.entity.Proje;
import com.proje.takip_istemi.entity.Yorum;
import com.proje.takip_istemi.repository.PersonelRepository;
import com.proje.takip_istemi.repository.ProjeRepository;
import com.proje.takip_istemi.repository.YorumRepository;
import com.proje.takip_istemi.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class YorumServiceImpl implements YorumService{
    @Autowired
    YorumRepository yorumRepository;

    @Autowired
    PersonelRepository personelRepository;

    @Autowired
    ProjeRepository projeRepository;
    @Override
    public Response saveYorum(YorumDTO yorumDTO) {
        Yorum yorum=new Yorum(yorumDTO.getIcerik());
        Optional<Personel> personel=personelRepository.findById(yorumDTO.getPersonelId());
        Optional<Proje> proje=projeRepository.findById(yorumDTO.getProjeId());

        if(personel.isPresent() && proje.isPresent()){
            Personel personel1=personel.get();
            Proje proje1=proje.get();
            yorum.setPersonel(personel1);
            yorum.setProje(proje1);

        }
        yorumRepository.save(yorum);
        return new Response("yorum kaydedildi",true);
    }
}
