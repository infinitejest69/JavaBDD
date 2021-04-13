package seleniumtests.steps.google;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import seleniumtests.pagemodels.PageManager;
import seleniumtests.config.Configuration;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class Steps {
  WebDriver driver;
  Configuration configuration;
  PageManager pageManager;

  @Before()
  public void userIsOnHomePage() {
    configuration = new Configuration();
    System.setProperty("webdriver.chrome.driver", configuration.getDriverPath());
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(configuration.getImplicitlyWait(), TimeUnit.SECONDS);
    pageManager = new PageManager(driver);
  }

  @Given("user is on Google Home Page")
  public void userIsOnGoogleHomePage() {
    pageManager.getGoogleHomePage().navigateToPage();
    assertThat(pageManager.getGoogleHomePage().getPageTitle()).isEqualToIgnoringCase("google");
  }
}
