package com.pmu.mvp.exposition.converter;

import com.pmu.mvp.domain.Course;
import com.pmu.mvp.exposition.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseConverter {

    private final PartantConverter partantConverter;

    public Course toCourse(CourseDto courseDto) {
        return new Course.Builder()
                .numero(courseDto.getNumero())
                .nom(courseDto.getNom())
                .date(courseDto.getDate())
                .partants(partantConverter.toPartants(courseDto.getPartants()))
                .build();
    }
}
