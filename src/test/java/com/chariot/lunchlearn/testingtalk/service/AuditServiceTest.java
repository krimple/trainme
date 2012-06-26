package com.chariot.lunchlearn.testingtalk.service;

import org.junit.Before;
import org.junit.Test;

public class AuditServiceTest {

  private AuditService auditService;

  @Before
  public void setUp() {
    auditService = new AuditServiceImpl();
  }

  @Test
  public void testAddAuditRecord() {
    // this fails, we start here...
    auditService.auditActivity(
        this.getClass(),
        "do something");

  }
}
