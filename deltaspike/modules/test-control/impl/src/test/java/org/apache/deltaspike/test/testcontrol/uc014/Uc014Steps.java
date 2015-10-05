package org.apache.deltaspike.test.testcontrol.uc014;

import javax.inject.Inject;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.apache.deltaspike.test.testcontrol.uc012.ApplicationScopedTestBean;
import org.apache.deltaspike.test.testcontrol.uc012.ApplicationScopedTestBeanClient;
import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;

/**
 * Created by rafael-pestano on 05/10/2015.
 */
public class Uc014Steps {

  @Inject
  private ApplicationScopedTestBean testBean;

  @Inject
  private ApplicationScopedTestBeanClient testBeanClient;


  @Given("^test bean value is set to (\\d+)$")
  public void initBeanValue(int value) {
    this.testBean.setValue(value);
  }

  @When("^bean value is incremented by (\\d+)$")
  public void incrementBeanValue(int amount) {
    this.testBeanClient.increment(amount);//will increment bean value
  }

  @Then("^bean value should be (\\d+)$")
  public void checkBeanValue(int result) {
    Assert.assertEquals(result, this.testBean.getValue());
  }

  @After
  public void finalCheck() {
    int value = BeanProvider.getContextualReference(ApplicationScopedTestBean.class).getValue();
    int nextValue = BeanProvider.getContextualReference(ApplicationScopedTestBeanClient.class).getNextValue();

    if (value == 0)
    {
      throw new IllegalStateException("new application-scoped bean instance was created");
    }

    if (nextValue == 1)
    {
      throw new IllegalStateException("new application-scoped bean instance was created");
    }
  }

  @Given("$")
  public void test_bean_value_is_set_to_value() throws Throwable {
    // Express the Regexp above with the code you wish you had
    throw new PendingException();
  }

}
