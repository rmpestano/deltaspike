package org.apache.deltaspike.test.testcontrol.uc014.feature.multiscenario;

import javax.inject.Inject;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.test.testcontrol.uc012.ApplicationScopedTestBean;
import org.apache.deltaspike.test.testcontrol.uc012.ApplicationScopedTestBeanClient;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by rafael-pestano on 05/10/2015.
 */
public class AppScopeBeanSteps {

  @Inject
  private ApplicationScopedTestBean testBean;

  @Inject
  private ApplicationScopedTestBeanClient testBeanClient;

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


  @Given("^test bean value is set to (\\d+)$")
  public void initBeanValue(int value) {
    this.testBean.setValue(value);
    assertEquals(projectStage, ProjectStage.Production);
  }

  @When("^bean value is incremented by (\\d+)$")
  public void incrementBeanValue(int amount) {
    this.testBeanClient.increment(amount);//will increment bean value
  }

  @Then("^bean value should be (\\d+)$")
  public void checkBeanValue(int result) {
    assertEquals(result, this.testBean.getValue());
  }




}
