package com.chariot.lunchlearn.testingtalk.service;

import com.chariot.lunchlearn.testingtalk.db.AuditRepository;
import com.chariot.lunchlearn.testingtalk.model.AuditEntry;

import java.util.ArrayList;
import java.util.List;

public class AuditRepositoryStub implements AuditRepository {

  List<AuditEntry> database = new ArrayList<AuditEntry>();

  @Override
  public void addAuditEntry(String clazz, String action) {
    AuditEntry auditEntry = new AuditEntry(clazz, action);
    database.add(auditEntry);
  }

  public List<AuditEntry> getDatabase() {
    return database;
  }
}
