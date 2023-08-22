package com.proje.takip_istemi.service;

import com.proje.takip_istemi.dto.DurumDTO;
import com.proje.takip_istemi.dto.GorevDTO;
import com.proje.takip_istemi.response.GorevResponse;
import com.proje.takip_istemi.response.ProjeResponse;
import com.proje.takip_istemi.response.Response;

import java.util.List;

public interface GorevService {

    List<GorevResponse> findGorevlerByProjeId(int id);

    Response saveGorev(GorevDTO gorevDTO);

    Response deleteById(int id);

    Response updateGorev(int id,GorevDTO gorevDTO);

    List<GorevResponse> findGorevlerByPersonelId(int id);

    Response updateDurumGorev(int id, DurumDTO durumDTO);
}
