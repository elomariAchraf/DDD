package com.pmu.mvp.application;

import com.pmu.mvp.domain.Course;
import com.pmu.mvp.domain.CourseRepository;
import com.pmu.mvp.domain.KafkaProducerService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.*;


import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseValidator courseValidator;
    private final KafkaProducerService kafkaProducerService;

    public Course save(Course course) {
        Errors erreurs = new BeanPropertyBindingResult(course, "course");
        courseValidator.validate(course, erreurs);
        if (erreurs.hasErrors()) {
            throw new ValidationException("course object validation failed: " + erreurs.getAllErrors());
        }
        return courseRepository.save(course);
    }

    public void publish(Course course) {
        kafkaProducerService.sendMessage(course);
    }
}
