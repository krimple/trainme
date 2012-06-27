package com.chariot.lunchlearn.testingtalk.service;

import com.chariot.lunchlearn.testingtalk.model.Course;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DiscountServiceBean implements DiscountService {

  @Override
  public BigDecimal calculateDiscount(Course course, int numStudents) {
    if (numStudents < 0) throw new IllegalArgumentException("Cannot pass negative value to discount");
    if (numStudents < 5) return BigDecimal.valueOf(0);
    if (numStudents >= 5 && numStudents <= 10) return BigDecimal.valueOf(0.2);
    if (numStudents >= 11 && numStudents <= 20) return BigDecimal.valueOf(0.3);
    return BigDecimal.valueOf(0.4);

  }
}
