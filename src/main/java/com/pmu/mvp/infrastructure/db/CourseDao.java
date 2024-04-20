package com.pmu.mvp.infrastructure.db;

import com.pmu.mvp.infrastructure.db.table.CourseEntity;
import org.springframework.data.repository.CrudRepository;

public interface CourseDao extends CrudRepository<CourseEntity, Long> {
}
