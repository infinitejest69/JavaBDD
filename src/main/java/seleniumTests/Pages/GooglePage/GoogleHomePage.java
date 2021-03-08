package seleniumTests.Pages.GooglePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends BasePage{

  WebDriver driver;
  String page = "https://www.google.co.uk/";

  public GoogleHomePage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void navigateTo_Page() {
    driver.get(page);
  }
}
