package com.chariot.lunchlearn.testingtalk.model;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@RooJavaBean
@RooToString
@RooJpaEntity
public class Offering {

  @Temporal(value = TemporalType.DATE)
  @Column(name = "offer_date", nullable = false)
  private Date offeringDate;

  @Column(name = "offer_price", nullable = false, precision = 2, length = 7)
  private BigDecimal offeringPrice;

  private int maxCapacity;

  @Embedded
  private Address address;

}
