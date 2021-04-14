package seleniumtests.steps.google;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import seleniumtests.pagemodels.PageManager;
import seleniumtests.config.Configuration;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSteps {
  WebDriver driver;
  Configuration configuration;
  PageManager pageManager;

  public GoogleSteps(WebDriver driver, Configuration configuration, PageManager pageManager) {
    this.driver = driver;
    this.configuration = configuration;
    this.pageManager = pageManager;
  }

  @Given("user is on Google Home Page")
  public void userIsOnGoogleHomePage() {
    pageManager.getGoogleHomePage().navigateToPage();
    assertThat(pageManager.getGoogleHomePage().getPageTitle()).isEqualToIgnoringCase("google");
  }

}
