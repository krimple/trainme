package com.chariot.lunchlearn.testingtalk.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@RooJavaBean
@RooToString
@RooJpaEntity
public class Offering {

  @Temporal(value = TemporalType.DATE)
  @DateTimeFormat(style = "M-")
  @Column(name = "offer_date", nullable = false)
  private Date offeringDate;

  @Column(name = "offer_price", nullable = false, precision = 2, length = 7)
  private BigDecimal offeringPrice;

  private int maxCapacity;

  @Embedded
  private Address address;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;

}
