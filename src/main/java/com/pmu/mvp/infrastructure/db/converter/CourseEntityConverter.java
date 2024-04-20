package com.pmu.mvp.infrastructure.db.converter;

import com.pmu.mvp.domain.Course;
import com.pmu.mvp.infrastructure.db.table.CourseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseEntityConverter {

    private final PartantEntityConverter partantEntityConverter;

    public CourseEntity toCourseEntity(Course course) {
        return CourseEntity.builder()
                .id(course.getId())
                .date(course.getDate())
                .nom(course.getNom())
                .numero(course.getNumero())
                .partantEntities(partantEntityConverter.toPartantEntities(course.getPartants()))
                .build();
    }

    public CourseEntity associateEachPartantToCourse(CourseEntity courseEntity) {
        courseEntity.getPartantEntities().forEach(partantEntity -> partantEntity.setCourseEntity(courseEntity));
        return courseEntity;
    }

    public Course toCourse(CourseEntity courseEntity) {
        return Course.builder()
                .id(courseEntity.getId())
                .date(courseEntity.getDate())
                .nom(courseEntity.getNom())
                .numero(courseEntity.getNumero())
                .partants(partantEntityConverter.toPartants(courseEntity.getPartantEntities()))
                .build();
    }
}
