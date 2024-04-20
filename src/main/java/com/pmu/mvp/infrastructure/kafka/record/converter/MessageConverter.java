package com.pmu.mvp.infrastructure.kafka.record.converter;

import com.pmu.mvp.domain.Course;
import com.pmu.mvp.domain.Partant;
import com.pmu.mvp.infrastructure.kafka.record.CourseMessage;
import com.pmu.mvp.infrastructure.kafka.record.PartantMessage;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MessageConverter {
    public PartantMessage toPartantMessage(Partant partant) {
        return PartantMessage.builder()
                .id(partant.getId())
                .nom(partant.getNom())
                .numero(partant.getNumero())
                .build();
    }
    public CourseMessage toCourseMessage(Course course) {
        return CourseMessage.builder()
                .id(course.getId())
                .date(course.getDate().toString())
                .nom(course.getNom())
                .numero(course.getNumero())
                .partants(course.getPartants().stream().map(this::toPartantMessage).toList())
                .build();
    }
}
