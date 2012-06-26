package com.chariot.lunchlearn.testingtalk.db;

import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository {
  void addAuditEntry(String clazz, String action);
}
