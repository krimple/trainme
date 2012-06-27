delete from audit_entry;

insert into audit_entry(audit_action, audit_log_entry_date, class_name)
values ('insert data', sysdate, 'myclass');

