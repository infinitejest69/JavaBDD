package seleniumtests.pagemodels;

import org.openqa.selenium.WebDriver;
import seleniumtests.pagemodels.google.GoogleHomePage;

public class PageManager {

  private final WebDriver driver;
  private GoogleHomePage homePage;

  public PageManager(WebDriver driver) {

    this.driver = driver;
  }

  public GoogleHomePage getGoogleHomePage() {
    return (homePage == null) ? homePage = new GoogleHomePage(driver) : homePage;
  }
}
