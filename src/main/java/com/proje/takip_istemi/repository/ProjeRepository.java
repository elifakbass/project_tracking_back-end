package com.proje.takip_istemi.repository;

import com.proje.takip_istemi.entity.Proje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProjeRepository extends JpaRepository<Proje,Integer> {
    @Query("SELECT p FROM Proje p WHERE p.sonTarih BETWEEN :startDate AND :endDate")
    List<Proje> getMonthlyData(@Param("startDate") String startDate, @Param("endDate") String endDate);

}
