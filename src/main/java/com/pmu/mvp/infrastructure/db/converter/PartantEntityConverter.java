package com.pmu.mvp.infrastructure.db.converter;

import com.pmu.mvp.domain.Partant;
import com.pmu.mvp.infrastructure.db.table.PartantEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PartantEntityConverter {

    public PartantEntity toPartantEntity(Partant partant) {
        return PartantEntity.builder()
                .id(partant.getId())
                .nom(partant.getNom())
                .numero(partant.getNumero())
                .build();
    }

    public List<PartantEntity> toPartantEntities(List<Partant> partants) {
        return partants.stream()
                .map(this::toPartantEntity)
                .toList();
    }

    public Partant toPartant(PartantEntity partantEntity) {
        return Partant.builder()
                .id(partantEntity.getId())
                .nom(partantEntity.getNom())
                .numero(partantEntity.getNumero())
                .build();
    }

    public List<Partant> toPartants(List<PartantEntity> partantEntities) {
        return partantEntities.stream()
                .map(this::toPartant)
                .toList();
    }
}
