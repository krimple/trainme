package com.chariot.lunchlearn.testingtalk.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
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

  public void setEmailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
  }

  public String getEmailAddress() {
      return this.emailAddress;
  }

  public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
  }

  public String getAddressLine1() {
      return this.addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
      this.addressLine1 = addressLine1;
  }

  public String getAddressLine2() {
      return this.addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
      this.addressLine2 = addressLine2;
  }

  public String getCity() {
      return this.city;
  }

  public void setCity(String city) {
      this.city = city;
  }

  public String getState() {
      return this.state;
  }

  public void setState(String state) {
      this.state = state;
  }

  public String getPostal() {
      return this.postal;
  }

  public void setPostal(String postal) {
      this.postal = postal;
  }

  public String getFaxNumber() {
      return this.faxNumber;
  }

  public void setFaxNumber(String faxNumber) {
      this.faxNumber = faxNumber;
  }

  public String getPhoneNumber() {
      return this.phoneNumber;
  }

  public String toString() {
      return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
