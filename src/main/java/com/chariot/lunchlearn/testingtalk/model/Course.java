package com.chariot.lunchlearn.testingtalk.model;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import java.math.BigDecimal;

@RooJavaBean
@RooToString
@RooJpaEntity
public class Course {

  private String name;

  private BigDecimal listPrice;

  private String description;


}
