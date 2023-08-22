package com.proje.takip_istemi.service;

import com.proje.takip_istemi.dao.AppDAO;
import com.proje.takip_istemi.dto.DurumDTO;
import com.proje.takip_istemi.dto.GorevDTO;
import com.proje.takip_istemi.entity.Gorev;
import com.proje.takip_istemi.entity.Personel;
import com.proje.takip_istemi.entity.Proje;
import com.proje.takip_istemi.repository.GorevRepository;
import com.proje.takip_istemi.repository.PersonelRepository;
import com.proje.takip_istemi.repository.ProjeRepository;
import com.proje.takip_istemi.response.ErrorResponse;
import com.proje.takip_istemi.response.GorevResponse;
import com.proje.takip_istemi.response.ProjeResponse;
import com.proje.takip_istemi.response.Response;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GorevServiceImpl implements GorevService{

    @Autowired
    AppDAO appDAO;

    @Autowired
    PersonelRepository personelRepository;

    @Autowired
    GorevRepository gorevRepository;

    @Autowired
    ProjeRepository projeRepository;
    @Override
    public List<GorevResponse> findGorevlerByProjeId(int id) {
        List<GorevResponse> res = new ArrayList<>();
        try {
            List<Gorev> gorevler = appDAO.findGorevlerByProjeId(id);
            if (gorevler != null) {


                List<GorevResponse> response = new ArrayList<>();

                for (Gorev gorev : gorevler){
                    Personel personel=gorev.getPersonel();
                    Proje proje=gorev.getProje();
                    GorevResponse temp = new GorevResponse(gorev.getId(), gorev.getName(), gorev.getDurum(), gorev.getIcerik(), gorev.getSonTarih(),personel.getId(),true, proje.getId());
                    response.add(temp);
                }
                return response;
            }
        }catch (NoResultException | EmptyResultDataAccessException exception){

         /*   ProjeResponse p=new ProjeResponse(false,"Görev Bulunamadi");
            res.add(p);
*/
        }
        return res;

    }

    @Override
    @Transactional
    public Response saveGorev(GorevDTO gorevDTO) {
        Gorev gorev=new Gorev(gorevDTO.getName(),gorevDTO.getSonTarih(),gorevDTO.getDurum(),gorevDTO.getIcerik());
        Optional<Personel> personel=personelRepository.findById(gorevDTO.getSorumlu());
        Optional<Proje> proje=projeRepository.findById(gorevDTO.getProje());

        if(personel.isPresent()){
            Personel temp=personel.get();
            gorev.setPersonel(temp);
        }
        if(proje.isPresent()){
            Proje temp=proje.get();
            gorev.setProje(temp);
        }
        gorevRepository.save(gorev);
        Response response=new Response("Gorev eklendi",true);
        return response;
    }

    @Override
    @Transactional
    public Response deleteById(int id) {
        Optional<Gorev> gorev=gorevRepository.findById(id);
        if(gorev.isPresent()){
            gorevRepository.deleteById(id);
            return new Response("gorev silindi id:" +id,true);
        }
        return new Response("gorev bulunamadı",false);

    }

    @Override
    public Response updateGorev(int id, GorevDTO gorevDTO) {
        Optional<Gorev> gorev=gorevRepository.findById(id);
        if(gorev.isPresent()){
            Gorev gorev1=gorev.get();
            gorev1.setIcerik(gorevDTO.getIcerik());
            gorev1.setDurum(gorevDTO.getDurum());
            gorev1.setSonTarih(gorevDTO.getSonTarih());

            appDAO.updateGorev(gorev1);

            Response response=new Response("gorev guncellendi",true);
            return response;
        }
        return new Response("gorev bulunamdi",false);
    }

    @Override
    public List<GorevResponse> findGorevlerByPersonelId(int id) {
        List<Gorev> gorevler=appDAO.findGorevlerByPersonelId(id);
        List<GorevResponse> response=new ArrayList<>();

        for(Gorev gorev:gorevler){
            Proje proje=gorev.getProje();
            GorevResponse gorevResponse=new GorevResponse(gorev.getId(),gorev.getName(),gorev.getDurum(),gorev.getIcerik(),gorev.getSonTarih(),id,true,proje.getId());
            response.add(gorevResponse);
        }
        return response;

    }

    @Override
    public Response updateDurumGorev(int id, DurumDTO durumDTO) {
        Optional<Gorev> gorev=gorevRepository.findById(id);
        if(gorev.isPresent()){
            Gorev temp=gorev.get();
            temp.setDurum(durumDTO.getDurum());
            appDAO.updateGorev(temp);
            return new Response("Gorev guncellendi",true);
        }
        return new Response("Gorev bulunamadi",false);
    }
}
