package com.chariot.lunchlearn.testingtalk.service;

import com.chariot.lunchlearn.testingtalk.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
  long countAllCourses();

  void deleteCourse(Course course);

  Course findCourse(Long id);

  List<Course> findAllCourses();

  List<Course> findCourseEntries(int firstResult, int maxResults);

  void saveCourse(Course course);

  Course updateCourse(Course course);
}
