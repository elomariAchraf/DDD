package com.pmu.mvp.exposition.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private LocalDate date;
    private Integer numero;
    private String nom;
    private List<PartantDto> partants;
}
