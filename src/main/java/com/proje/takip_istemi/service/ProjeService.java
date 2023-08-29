package com.proje.takip_istemi.service;

import com.proje.takip_istemi.dto.DurumDTO;
import com.proje.takip_istemi.dto.ProjeDTO;
import com.proje.takip_istemi.entity.Proje;
import com.proje.takip_istemi.response.ProjeResponse;
import com.proje.takip_istemi.response.Response;
import com.proje.takip_istemi.response.YorumResponse;

import java.time.LocalDate;
import java.util.List;

public interface ProjeService {

    List<ProjeResponse> findProjects(int id);

    String saveProject(ProjeDTO projeDTO);

    Response deleteById(int id);

    Response updateProje(int id,ProjeDTO projeDTO);

    Response updateProjeByDurum(int id, DurumDTO durumDTO);

    ProjeResponse  getProje(int id);

    List<YorumResponse> getYorumlarById(int id);

    List<ProjeResponse> getMonthlyData(LocalDate startDate, LocalDate endDate);
}
