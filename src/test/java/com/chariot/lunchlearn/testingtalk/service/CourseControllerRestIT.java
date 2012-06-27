package com.chariot.lunchlearn.testingtalk.service;

import com.chariot.lunchlearn.testingtalk.model.Course;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CourseControllerRestIT {

  /** This test requires a running server.
   * Kick off the application with mvn package jetty:run
   * then run this from an IDE or a separate window with mvn test.
   */
  @Test
  public void testGetAllCourses() {
    RestTemplate template = new RestTemplate();
    String coursesJson = template.getForObject("http://localhost:8080/trainme/courses",
        String.class);
    Collection<Course> courses = Course.fromJsonArrayToCourses(coursesJson);
    assertThat(courses.size(), equalTo(1));
  }

}
