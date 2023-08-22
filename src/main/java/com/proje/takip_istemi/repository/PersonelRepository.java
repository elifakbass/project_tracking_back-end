package com.proje.takip_istemi.repository;

import com.proje.takip_istemi.entity.Personel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface PersonelRepository extends JpaRepository<Personel,Integer> {

    Personel findByEmail(String username);
}
