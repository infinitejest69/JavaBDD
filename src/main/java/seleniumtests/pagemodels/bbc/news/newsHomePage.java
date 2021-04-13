package seleniumtests.pagemodels.bbc.news;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import seleniumtests.pagemodels.BasePage;

public class newsHomePage extends BasePage {

  WebDriver driver;
  String page = "https://www.bbc.co.uk/news";
  String MenuSearch = ".//li/a/span[contains(text(),'replace')]";

  public newsHomePage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void navigateToPage() {
    super.navigateToPage(page);
  }

  public void clickMenuItem(String input) {
    String replace = MenuSearch.replace("replace", input);
    driver.findElement(new By.ByXPath(replace)).click();
  }
}
