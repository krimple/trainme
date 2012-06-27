package com.chariot.lunchlearn.testingtalk.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@RooToString
@RooJavaBean
public class AuditEntry {

  protected AuditEntry() {
    super();
  }

  /**Construct allowing audit entry creation but not manipulation
   * of the time recorded. This time is (naively) the system time.
   * @param className The class name that is being audited
   * @param action the activity that caused the action
   */
  public AuditEntry(String className, String action) {
    this.className = className;
    this.auditLogEntryDate = new Date();
    this.action = action;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "audit_id")
  private Long id;

  @Column(name = "class_name", length=255, nullable = false)
  private String className;

  @Temporal(value = TemporalType.TIMESTAMP)
  @DateTimeFormat(style = "M-")
  private Date auditLogEntryDate;

  @Column(name = "audit_action", length=2000, columnDefinition = "longvarchar")
  private String action;

  public Long getId() {
    return id;
  }

  public String getClassName() {
    return className;
  }

  public Date getAuditLogEntryDate() {
    return auditLogEntryDate;
  }

  public String getAction() {
    return action;
  }
}
