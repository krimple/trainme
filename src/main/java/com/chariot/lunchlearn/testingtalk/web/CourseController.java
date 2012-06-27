package com.chariot.lunchlearn.testingtalk.web;

import com.chariot.lunchlearn.testingtalk.model.Course;
import com.chariot.lunchlearn.testingtalk.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/courses")
@Controller
public class CourseController {

  @Autowired
  private CourseService courseService;

  @RequestMapping(method = RequestMethod.GET)
  public @ResponseBody String getCourses() {
    List<Course> courses = courseService.findAllCourses();
    return Course.toJsonArray(courses);
  }
}
