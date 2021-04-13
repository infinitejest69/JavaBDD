package seleniumtests.pagemodels.bbc.sports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class sportsHomePage {

  WebDriver driver;
  String page = "https://www.google.co.uk/";

  @FindBy(xpath = ".//input[@aria-label='Search']")
  WebElement search;

  @FindBy(xpath = ".//input[@aria-label='Google Search']")
  WebElement submitSearch;


  public sportsHomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void navigateToPage() {
    driver.get(page);
  }

  public void enterStringToSearch(String input){
    search.sendKeys(input);
  }

  public String getPageTitle() {
    return driver.getTitle();
  }
}
