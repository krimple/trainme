package com.chariot.lunchlearn.testingtalk.service;

import com.chariot.lunchlearn.testingtalk.model.Course;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@ContextConfiguration(locations = {"classpath:META-INF/spring/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DiscountServiceIntegrationTest {

  @Autowired
  private DiscountService service;

  private Course course;
  @Before
  public void createCourse() {
    course = new Course();
    course.setDescription("saldfkjasflkjasdf");
    course.setListPrice(new BigDecimal("120.00"));
    course.setName("asaslkfjaslkfjasd");
    course.setId(99L);
    course.setVersion(1);
  }

  @Test
  public void testDiscountUnder5Students() {
    BigDecimal result = service.calculateDiscount(course, 3);
    assertThat(0d, equalTo(result.doubleValue()));
  }

  @Test(expected = RuntimeException.class)
  public void testDiscountSadPathNegativeStudents() {
    service.calculateDiscount(course, -100);
  }
}
