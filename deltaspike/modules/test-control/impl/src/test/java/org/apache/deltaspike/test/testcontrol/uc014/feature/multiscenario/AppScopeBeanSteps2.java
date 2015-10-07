package org.apache.deltaspike.test.testcontrol.uc014.feature.multiscenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.test.testcontrol.uc012.ApplicationScopedTestBean;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

/**
 * Created by rafael-pestano on 05/10/2015.
 *
 */
public class AppScopeBeanSteps2 {

  @Inject
  private ApplicationScopedTestBean testBean;

  @Inject
  ProjectStage projectStage;


  @Before
  public void before(){
    assertNotNull(testBean);
  }

  @After
  public void after(){
    assertNotNull(testBean);
  }


  @Then("^test bean value must be reseted between features$")
  public void checkBeanValue() {
    assertEquals(projectStage, ProjectStage.Production);
    assertEquals(0, this.testBean.getValue());
  }



}
