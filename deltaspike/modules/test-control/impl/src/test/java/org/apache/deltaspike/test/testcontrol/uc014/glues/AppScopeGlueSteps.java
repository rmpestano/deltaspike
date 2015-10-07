package org.apache.deltaspike.test.testcontrol.uc014.glues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.apache.deltaspike.test.testcontrol.uc012.ApplicationScopedTestBean;
import org.apache.deltaspike.test.testcontrol.uc012.ApplicationScopedTestBeanClient;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

/**
 * Created by rafael-pestano on 05/10/2015.
 */
public class AppScopeGlueSteps {

  @Inject
  private ApplicationScopedTestBean testBean;

  @Inject
  ProjectStage projectStage;


  @Then("^test bean value must be reseted$")
  public void checkBeanValue() {
    assertEquals(projectStage, ProjectStage.Development);//@see AppScopeBeanWithGlueTest
    assertEquals(0, this.testBean.getValue());
  }





}
