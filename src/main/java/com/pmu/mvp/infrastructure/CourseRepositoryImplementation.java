package com.pmu.mvp.infrastructure;

import com.pmu.mvp.domain.Course;
import com.pmu.mvp.domain.CourseRepository;
import com.pmu.mvp.infrastructure.db.converter.CourseEntityConverter;
import com.pmu.mvp.infrastructure.db.CourseDao;
import com.pmu.mvp.infrastructure.db.table.CourseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CourseRepositoryImplementation implements CourseRepository {
    private final CourseDao courseDao;

    private final CourseEntityConverter courseEntityConverter;

    @Override
    public Course save(Course course) {
        CourseEntity courseEntity = courseEntityConverter.toCourseEntity(course);
        CourseEntity courseEntitySaved = courseDao.save(courseEntityConverter.associateEachPartantToCourse(courseEntity));
        return courseEntityConverter.toCourse(courseEntitySaved);
    }
}
