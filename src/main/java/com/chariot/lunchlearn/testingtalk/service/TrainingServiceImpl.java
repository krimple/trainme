package com.chariot.lunchlearn.testingtalk.service;

import com.chariot.lunchlearn.testingtalk.db.CourseRepository;
import com.chariot.lunchlearn.testingtalk.model.Course;
import com.chariot.lunchlearn.testingtalk.model.Offering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class TrainingServiceImpl implements TrainingService {

  @Autowired
  private CourseService courseService;

  @Autowired
  private OfferingService offeringService;

  @Autowired
  private CourseRepository courseRepository;


  @Transactional
  public Errors addNewCourse(Course course) {
    // perform validation
    Errors errors = new BeanPropertyBindingResult(course, "course");
    // course id cannot be specified
    if (course.getId() != null) {
      errors.rejectValue("id", "cannot add with existing primary key");
    }
    // course description may be null, but if specified
    // must be <= 1000 chars
    if (course.getDescription() != null &&
        course.getDescription().trim().length() > 1000)
      errors.rejectValue("description", "course description must be less than 1000 characters.");

    // list price checks : not null, > 0
    if (course.getListPrice() == null)
      errors.rejectValue("listPrice", "course must provide a list price. The price can be $0.00");

    if (course.getListPrice().compareTo(new BigDecimal("0.0")) < 0)
      errors.rejectValue("listPrice", "price must not be negative.");

    if (errors.hasErrors()) {
      return errors;
    } else {
     courseService.saveCourse(course);
      return errors;
    }
  }

  @Override
  @Transactional
  public Errors addOffering(Long courseId, Offering offering) {
    // first, check to see whether the date is in use
    // should probably be externalized but simple examples are cheesy by nature

    Errors errors = new BeanPropertyBindingResult(offering, "offering");

    if (courseRepository.hasOfferingOnDate(courseId, offering.getOfferingDate())) {
      errors.rejectValue("offeringDate", "Course already being taught on this date.");
    }
    if (offering.getOfferingDate().before(new Date())) {
      errors.rejectValue("offeringDate", "New course offering cannot occur in the past.");
    }

    if (offering.getMaxCapacity() < 1) {
      errors.rejectValue("maxCapacity", "Must have a capacity >= 1");
    }

    if (offering.getOfferingPrice().compareTo(BigDecimal.ZERO) < 0) {
      errors.rejectValue("offeringPrice", "Cannot pay students to attend. i.e. " +
          "we'll lose a bit in each transaction but make it " +
          "up in volume...");
    }

    // so if validation fails, we exit
    if (errors.hasErrors()) {
      return errors;
    }

    // now we price...

    // figure pricing via tiered model
    // this is bloody awful...
    if (offering.getOfferingPrice() == null) {
      switch (offering.getMaxCapacity()) {
        case 1:case 2:case 3:case 4:case 5:
          offering.setOfferingPrice(new BigDecimal("100.00"));
          break;
        case 6:case 7:case 8:case 9:case 10:
          offering.setOfferingPrice(new BigDecimal("50.00"));
          break;
        case 11:case 12:case 13:case 14:case 15:
          offering.setOfferingPrice(new BigDecimal("25.00"));
        default:
          offering.setOfferingPrice(new BigDecimal("0.00"));
      }
    }

    // we save it...
    offeringService.saveOffering(offering);

    return errors;
  }
}
