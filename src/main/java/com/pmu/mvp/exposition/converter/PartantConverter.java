package com.pmu.mvp.exposition.converter;

import com.pmu.mvp.domain.Partant;
import com.pmu.mvp.exposition.dto.PartantDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PartantConverter {

    public Partant toPartant(PartantDto partantDto) {
        return new Partant.Builder()
                .nom(partantDto.getNom())
                .numero(partantDto.getNumero())
                .build();
    }

    public List<Partant> toPartants(List<PartantDto> partantDtos) {
        return partantDtos.stream()
                .map(this::toPartant)
                .toList();
    }
}
