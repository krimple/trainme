package com.chariot.lunchlearn.testingtalk.service;

import com.chariot.lunchlearn.testingtalk.db.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditService {

  @Autowired
  private AuditRepository auditRepository;

  @Override
  public void auditActivity(Class clazz, String action) {
    auditRepository.addAuditEntry(
        clazz.getCanonicalName(), action);
  }
}
