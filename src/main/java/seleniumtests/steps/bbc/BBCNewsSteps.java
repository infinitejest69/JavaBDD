package seleniumtests.steps.bbc;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import seleniumtests.pagemodels.PageManager;
import seleniumtests.steps.DriverManager;

import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;

public class BBCNewsSteps {

  WebDriver driver;
  PageManager pageManager;

  public BBCNewsSteps(DriverManager driverManager) throws MalformedURLException {
    this.driver = driverManager.getDriver();
    this.pageManager = new PageManager(driverManager);
  }

  @When("i click news menu {string}")
  public void iCheckNewsFor(String menuItem) {
    pageManager.getNewsHomePage().clickMenuItem(menuItem);
  }

  @Then("i see stories for {string}")
  public void iSeeStoriesFor(String input) {

    assertThat(pageManager.getNewsHomePage().getCSectionLinkText(input)).contains(input);

    // Cant assert on all items in the list
    // pageManager.getNewsHomePage().getCSectionLinkText(input)
    //  .forEach(c -> assertThat(c).contains(input));
  }
}
