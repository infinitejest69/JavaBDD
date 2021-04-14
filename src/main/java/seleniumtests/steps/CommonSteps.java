package seleniumtests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import seleniumtests.config.Configuration;

public class CommonSteps {

  WebDriver driver;

  public CommonSteps(DriverManager driverManager) { ;
    this.driver = driverManager.getDriver();
  }

  @Given("i navigate to {string}")
  public void iNavigateTo(String path) {
    driver.navigate().to(path);
  }

  @When("i check the Formula {int} driver table")
  public void iCheckTheFormulaDriverTable(int arg0) {
  }

  @Then("i see current formula {int} driver table")
  public void iSeeCurrentFormulaDriverTable(int arg0) {
  }

  @When("i input the location {string}")
  public void iInputTheLocation(String arg0) {
  }

  @And("click search")
  public void clickSearch() {
  }

  @Then("i see current weather for my location")
  public void iSeeCurrentWeatherForMyLocation() {
  }

  @When("i click tv guide")
  public void iClickTvGuide() {
  }

  @And("i click {string}")
  public void iClick(String arg0) {
  }

  @Then("i see todays Tv Guide")
  public void iSeeTodaysTvGuide() {
  }
}
