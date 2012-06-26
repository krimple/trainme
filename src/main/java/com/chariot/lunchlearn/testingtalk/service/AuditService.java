package com.chariot.lunchlearn.testingtalk.service;

import java.util.Date;

public interface AuditService {
  void auditActivity(Class clazz, String action, Date date);
}
