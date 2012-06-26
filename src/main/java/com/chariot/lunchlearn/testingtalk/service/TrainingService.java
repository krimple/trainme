package com.chariot.lunchlearn.testingtalk.service;

import com.chariot.lunchlearn.testingtalk.model.Course;
import com.chariot.lunchlearn.testingtalk.model.Offering;
import org.springframework.validation.Errors;

/**
 * Business methods for a facade service
 * that provides access to course-grained
 * methods to manage training events.
 *
 * Also provides validation of data so
 * objects can be exported and used by
 * multiple front-end systems.
 */
public interface TrainingService {
  Errors addNewCourse(Course course);

  Errors addOffering(Long courseId, Offering offering);
}
