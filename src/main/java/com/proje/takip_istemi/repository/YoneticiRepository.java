package com.proje.takip_istemi.repository;

import com.proje.takip_istemi.entity.Yonetici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface YoneticiRepository  extends JpaRepository<Yonetici,Integer> {

    Yonetici findByEmail(String username);
}
