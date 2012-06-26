package com.chariot.lunchlearn.testingtalk.service;

import com.chariot.lunchlearn.testingtalk.db.CourseRepository;
import com.chariot.lunchlearn.testingtalk.model.Course;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseServiceImpl implements CourseService {

  @Autowired
  private CourseRepository courseRepository;

  @Override
  public long countAllCourses() {
    return courseRepository.count();
  }

  @Override
  public void deleteCourse(Course course) {
    courseRepository.delete(course);
  }

  @Override
  public Course findCourse(Long id) {
    return courseRepository.findOne(id);
  }

  @Override
  public List<Course> findAllCourses() {
    return courseRepository.findAll();
  }

  @Override
  public List<Course> findCourseEntries(int firstResult, int maxResults) {
    return courseRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
  }

  @Override
  public void saveCourse(Course course) {
    courseRepository.save(course);
  }

  @Override
  public Course updateCourse(Course course) {
    return courseRepository.save(course);
  }
}
