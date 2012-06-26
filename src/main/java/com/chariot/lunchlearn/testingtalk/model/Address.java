package com.chariot.lunchlearn.testingtalk.model;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Embeddable;

@Embeddable
@RooJavaBean
@RooToString
public class Address {

  String addressLine1;
  String addressLine2;
  String city;
  String state;
  String postal;
  String faxNumber;
  String phoneNumber;
  String emailAddress;

}
