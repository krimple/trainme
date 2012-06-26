package com.chariot.lunchlearn.testingtalk.db;

import com.chariot.lunchlearn.testingtalk.model.Course;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Course.class)
public interface CourseRepository {
}
