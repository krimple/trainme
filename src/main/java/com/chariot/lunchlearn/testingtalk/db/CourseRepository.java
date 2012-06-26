package com.chariot.lunchlearn.testingtalk.db;

import com.chariot.lunchlearn.testingtalk.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>,
    JpaSpecificationExecutor<Course> {

  @Query("select count(o) from Offering o where o.course.id = ?1")
  public int getCountOfOfferingsForCourse(Long courseId);


  @Query("select CASE WHEN count(o) >= 1 then true else false end " +
         " from Offering o " +
         " where o.course.id = ?1 and o.offeringDate = ?2")
  public boolean hasOfferingOnDate(Long courseId, Date offeringDate);
}
