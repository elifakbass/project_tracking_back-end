package com.proje.takip_istemi.service;

import com.proje.takip_istemi.dao.AppDAO;
import com.proje.takip_istemi.dto.LoginDTO;
import com.proje.takip_istemi.dto.YoneticiDTO;
import com.proje.takip_istemi.entity.Admin;
import com.proje.takip_istemi.entity.Yonetici;
import com.proje.takip_istemi.repository.AdminRepository;
import com.proje.takip_istemi.response.AdminResponse;
import com.proje.takip_istemi.response.YoneticiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    AppDAO appDAO;

    @Override
    public AdminResponse findAdmin(LoginDTO loginDTO) {
        Admin admin= adminRepository.findByEmail(loginDTO.getUsername());
        return new AdminResponse(admin.getId(),admin.getName());}

    @Override
    public List<YoneticiDTO> findYoneticiByAdminId(int id) {
        List<Yonetici> yoneticiList=appDAO.findYoneticilerByAdminId(id);
        List<YoneticiDTO> responses=new ArrayList<>();

        if(!yoneticiList.isEmpty()){
            for(Yonetici yonetici:yoneticiList){
                YoneticiDTO yoneticiDTO=new YoneticiDTO(yonetici.getId(), yonetici.getName(),yonetici.getKurumAdi(),yonetici.getPersonelSayisi(),yonetici.getImage());
                responses.add(yoneticiDTO);
            }
        }
        return responses;
    }
}
