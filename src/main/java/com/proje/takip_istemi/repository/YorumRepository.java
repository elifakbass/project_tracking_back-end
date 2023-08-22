package com.proje.takip_istemi.repository;

import com.proje.takip_istemi.entity.Yorum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YorumRepository extends JpaRepository<Yorum,Integer> {
}
