package seleniumtests.steps.bbc;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import seleniumtests.pagemodels.PageManager;
import seleniumtests.pagemodels.bbc.sports.SportsHomePage;
import seleniumtests.steps.DriverManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BBCSportsSteps {

  WebDriver driver;
  PageManager pageManager;
  SportsHomePage sportsHomePage;

  public BBCSportsSteps(DriverManager driverManager) {
    this.driver = driverManager.getDriver();
    this.pageManager = new PageManager(driverManager);
    sportsHomePage = pageManager.getSportsHomePage();
  }

  @Then("i see current formula 1 driver table")
  public void iSeeCurrentFormulaDriverTable() {
    assertThat(sportsHomePage.getPageTitle()).isEqualToIgnoringCase("FIA Formula 1 Standings");
  }

  @When("i click {string} from the menu")
  public void iClickFromTheMenu(String menuItem) {
    sportsHomePage.clickMenuItem(menuItem);
  }

  @When("i click {string} from the submenu")
  public void iClickFromTheSubmenu(String subMenuItem) {
    sportsHomePage.clickSubMenuItem(subMenuItem);
  }
}
