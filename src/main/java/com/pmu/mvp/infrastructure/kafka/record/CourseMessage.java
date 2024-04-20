package com.pmu.mvp.infrastructure.kafka.record;

import com.pmu.mvp.domain.Partant;
import com.pmu.mvp.domain.validation.NumeroteDeUnSansDoublonsNiTrou;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseMessage {
    private Long id;

    private String date;

    private Integer numero;

    private String nom;

    private List<PartantMessage> partants;
}
