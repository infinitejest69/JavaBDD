package seleniumtests.pagemodels;

import org.openqa.selenium.WebDriver;
import seleniumtests.pagemodels.bbc.news.NewsHomePage;
import seleniumtests.pagemodels.google.GoogleHomePage;
import seleniumtests.steps.DriverManager;

public class PageManager {

  private final WebDriver driver;
  private GoogleHomePage homePage;
  private NewsHomePage newsHomePage;

  public PageManager(DriverManager driverManager) {
    this.driver = driverManager.getDriver();
  }

  public GoogleHomePage getGoogleHomePage() {
    return (homePage == null) ? homePage = new GoogleHomePage(driver) : homePage;
  }

  public NewsHomePage getNewsHomePage() {
    return (homePage == null) ? newsHomePage = new NewsHomePage(driver) : newsHomePage;
  }
}
