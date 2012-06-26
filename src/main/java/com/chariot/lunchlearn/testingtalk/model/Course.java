package com.chariot.lunchlearn.testingtalk.model;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import java.math.BigDecimal;

@RooJavaBean
@RooToString
@RooJpaEntity
public class Course {

  @Column(name = "course_name", length = 80, nullable = false)
  private String name;

  @Column(name = "list_price", nullable = false, precision = 2, length = 7)
  private BigDecimal listPrice;

  @Column(name="course_description", length = 600, nullable = true)
  private String description;


}
