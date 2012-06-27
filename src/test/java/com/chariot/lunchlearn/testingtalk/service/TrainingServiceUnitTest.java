package com.chariot.lunchlearn.testingtalk.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TrainingServiceUnitTest {

  private TrainingService trainingService;

  @Before
  public void setUp() {
    trainingService = new TrainingServiceImpl();
  }

  @Test
  public void equationTestSomething() {
    assertTrue(1 == 1);
  }


  @Test
  public void testSomething() {
    // actual, comparison value
    int actual = 1;
    assertEquals(1, actual);
  }

  @Test
  public void matchSomething() {
    // actual, comparison matcher
    // notice, we construct a sentence this way...
    int actual = 1;
    assertThat(actual, equalTo(1) );
  }

  @After
  public void tearDown() {
    System.out.println("Cleaning up...");
    // redundant... we do setUp each time
    trainingService = null;
  }

}
