package com.chariot.lunchlearn.testingtalk.db;

import com.chariot.lunchlearn.testingtalk.model.AuditEntry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

public class AuditJpaRepository implements AuditRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public void addAuditEntry(String clazz, String action) {
    AuditEntry entry = new AuditEntry(clazz,  action);
    em.persist(entry);
  }
}
