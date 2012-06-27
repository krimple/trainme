package com.chariot.lunchlearn.testingtalk.service;

import com.chariot.lunchlearn.testingtalk.model.Course;

import java.math.BigDecimal;

public interface DiscountService {

  BigDecimal calculateDiscount(Course course, int numStudents);
}
