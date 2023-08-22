package com.proje.takip_istemi.service;

import com.proje.takip_istemi.dao.AppDAO;
import com.proje.takip_istemi.dto.DurumDTO;
import com.proje.takip_istemi.dto.ProjeDTO;
import com.proje.takip_istemi.entity.Personel;
import com.proje.takip_istemi.entity.Proje;
import com.proje.takip_istemi.entity.Yorum;
import com.proje.takip_istemi.repository.PersonelRepository;
import com.proje.takip_istemi.repository.ProjeRepository;
import com.proje.takip_istemi.response.ProjeResponse;
import com.proje.takip_istemi.response.Response;
import com.proje.takip_istemi.response.YorumResponse;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjeServiceImpl implements ProjeService {

    @Autowired
    AppDAO appDAO;

    @Autowired
    ProjeRepository projeRepository;

    @Autowired
    PersonelRepository personelRepository;
    @Override
    public List<ProjeResponse> findProjects(int id) {
        List<Proje> projects=appDAO.findProjectsByPersonelId(id);
        List<ProjeResponse> temp=new ArrayList<>();

        for(Proje proje:projects){
            ProjeResponse response=new ProjeResponse(proje.getId(),proje.getName(),proje.getDurum(),proje.getIcerik(),proje.getSonTarih(),true);
            temp.add(response);
        }
        return temp;
    }

    @Override
    public String saveProject(ProjeDTO projeDTO) {

        Proje proje=new Proje(
                projeDTO.getName(),
                projeDTO.getSonTarih(),
                projeDTO.getDurum(),
                projeDTO.getIcerik()
        );

        Optional<Personel> personel =personelRepository.findById(projeDTO.getSorumlu());
        Personel tempPersonel;
        if(personel.isPresent() && proje!=null){
            tempPersonel=personel.get();
            proje.addPersonel(tempPersonel);
        }

        projeRepository.save(proje);

        return proje.getName();
    }

    @Override
    @Transactional
    public Response deleteById(int id) {
        Optional<Proje> proje=projeRepository.findById(id);


        if(proje.isPresent()){
            projeRepository.deleteById(id);
            Response response=new Response("Proje silindi id:" +id,true);
            return response;
        }

        Response response=new Response("Proje Bulunamadi:" +id,false);

        return response;
    }

    @Override
    public ProjeResponse updateProje(int id,ProjeDTO projeDTO) {
        Optional<Proje> proje =projeRepository.findById(id);
        if(proje.isPresent()){
            Proje proje1=proje.get();
            proje1.setDurum(projeDTO.getDurum());
            proje1.setIcerik(projeDTO.getIcerik());
            proje1.setName(projeDTO.getName());
            proje1.setSonTarih(projeDTO.getSonTarih());

            appDAO.updateProje(proje1);

            ProjeResponse projeResponse=new ProjeResponse(proje1.getId(),proje1.getName(),proje1.getDurum(),proje1.getIcerik(),proje1.getSonTarih(),true);
            return projeResponse;

        }
        ProjeResponse projeResponse=new ProjeResponse(false,"proje bulunamadi id: "+id);
        return  projeResponse;

    }

    @Override
    @Transactional
    public Response updateProjeByDurum(int id, DurumDTO durumDTO) {
        Optional<Proje> proje=projeRepository.findById(id);
        if(proje.isPresent()){
            Proje temp=proje.get();
            temp.setDurum(durumDTO.getDurum());
            appDAO.updateProje(temp);
            return new Response("Proje Güncellendi",true);
        }
        return new Response("Proje bulunmadı",false);
    }

    @Override
    public ProjeResponse getProje(int id) {
        Optional<Proje> proje=projeRepository.findById(id);
        if(proje.isPresent()){
            Proje temp=proje.get();
            ProjeResponse response=new ProjeResponse(temp.getId(),temp.getName(),temp.getDurum(),temp.getIcerik(),temp.getSonTarih(),true);
            return response;
        }
        return new ProjeResponse(false,"PROJE BULUNAMADI");

    }

    @Override
    public List<YorumResponse> getYorumlarById(int id) {
        List<Yorum> yorumlar=appDAO.getYorumlarByProjeId(id);
        List<YorumResponse> responses=new ArrayList<>();

        for(Yorum yorum:yorumlar){
            Personel personel=yorum.getPersonel();
            YorumResponse yorumResponse=new YorumResponse(yorum.getIcerik(),personel.getId());
            responses.add(yorumResponse);
        }
        return responses;
    }
}
