package com.pmu.mvp.application;

import com.pmu.mvp.domain.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class CourseValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Course.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Course course = (Course) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (course.nom().length() < 6 || course.nom().length() > 32) {
            errors.rejectValue("nom course", "nom de la course n'est pas comprise entre 7 et 31");
        }
        // Ajout d'autre validation selon le besoin
    }
}
