package com.proje.takip_istemi.service;

import com.proje.takip_istemi.dto.YorumDTO;
import com.proje.takip_istemi.response.Response;

public interface YorumService {

    Response saveYorum(YorumDTO yorumDTO);
}
