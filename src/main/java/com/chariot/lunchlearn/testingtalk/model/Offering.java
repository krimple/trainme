package com.chariot.lunchlearn.testingtalk.model;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import java.math.BigDecimal;
import java.util.Date;

@RooJavaBean
@RooToString
@RooJpaEntity
public class Offering {

  private Date offeringDate;

  private BigDecimal offeringPrice;

  private int maxCapacity;

//  @Embedded
//  private Address address;

}
