package com.proje.takip_istemi.dto;

import org.springframework.jca.support.LocalConnectionFactoryBean;

import java.time.LocalDate;

public class DataRangeDTO {
    private LocalDate startDate;

    private LocalDate endDate;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public DataRangeDTO(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
