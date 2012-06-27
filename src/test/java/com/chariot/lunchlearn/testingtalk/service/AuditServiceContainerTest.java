package com.chariot.lunchlearn.testingtalk.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:META-INF/spring/applicationContext*.xml",
    "classpath:com/chariot/lunchlearn/testingtalk/service/AuditServiceIntegrationTest-config.xml"})
public class AuditServiceContainerTest {

  @PersistenceContext
  private EntityManager em;

  @Autowired
  private AuditService auditService;

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public void setJdbcTemplate(DataSource datasource) {
    jdbcTemplate = new JdbcTemplate(datasource);
  }

  @Test
  @Transactional
  public void testAddNewAuditRecord() {
    int startRecordCount =
        jdbcTemplate.queryForInt("select count(*) from Audit_Entry");

    auditService.auditActivity(this.getClass(), "something!");

    // force an insert to the db
    em.flush();

    int endRecordCount =
        jdbcTemplate.queryForInt("select count(*) from Audit_Entry");
    assertThat(1, equalTo(endRecordCount - startRecordCount));
  }

  @Test
  public void testDataIntegrity() {
    int recordCount =
        jdbcTemplate.queryForInt("select count(*) from Audit_Entry");

    assertThat(1, equalTo(recordCount));
  }
}