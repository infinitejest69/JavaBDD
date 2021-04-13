package seleniumtests.pagemodels.bbc.iplayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumtests.pagemodels.BasePage;

public class iPlayerHomePage extends BasePage {

  WebDriver driver;
  String page = "https://www.bbc.co.uk/iplayer";

  @FindBy(xpath = ".//*[@aria-label='TV Guide']/span")
  WebElement menu_tvGuide;

  @FindBy(xpath = ".//*[@aria-label='A to Z']/span")
  WebElement menu_A2Z;

  public iPlayerHomePage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void navigateToPage() {
    driver.get(page);
  }

  public void clickMenuA2Z() {
    menu_A2Z.click();
  }

  public void clickMenuTVGuide() {
    menu_tvGuide.click();
  }

  public String getPageUrl() {
    return driver.getCurrentUrl();
  }

  public String getPageTitle() {
    return driver.getTitle();
  }
}
