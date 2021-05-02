package seleniumtests.steps.bbc;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import seleniumtests.pagemodels.PageManager;
import seleniumtests.pagemodels.bbc.iplayer.IPlayerHomePage;
import seleniumtests.steps.DriverManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class BBCIPlayerSteps {

  WebDriver driver;
  PageManager pageManager;
  IPlayerHomePage iPlayerHomePage;

  public BBCIPlayerSteps(DriverManager driverManager) {
    this.driver = driverManager.getDriver();
    this.pageManager = new PageManager(driverManager);
    iPlayerHomePage = pageManager.getIPlayerHomePage();
  }

  @When("i click tv guide")
  public void iClickTvGuide() {
    iPlayerHomePage.clickMenuTVGuide();
  }

  @Then("i see todays Tv Guide")
  public void iSeeTodaysTvGuide() {
    DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("dd");

    String day = LocalDate.now().format(monthFormatter);
    assertThat(iPlayerHomePage.getIPLayerTodaysDate()).isEqualToIgnoringCase(day);
  }

  @And("i click channel {string}")
  public void iClickChannel(String arg0) {
    iPlayerHomePage.clickChanelLogo(arg0);
  }
}
