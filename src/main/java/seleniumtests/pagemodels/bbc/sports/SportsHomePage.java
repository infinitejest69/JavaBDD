package seleniumtests.pagemodels.bbc.sports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SportsHomePage {

  WebDriver driver;
  String page = "https://www.bbc.co.uk/sport";

  String menuString = ".//*[@data-stat-name='primary-nav-v2'][contains(text(),'replace')]";
  String submenuString = ".//*[@data-stat-name='secondary-nav-v2'][contains(text(),'replace')]";

  @FindBy(id = "page")
  WebElement pageTitle;

  public SportsHomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void clickMenuItem(String menuItem) {
    driver.findElement(By.xpath(menuString.replace("replace", menuItem))).click();
  }

  public void clickSubMenuItem(String subMenuItem) {
    driver.findElement(By.xpath(submenuString.replace("replace", subMenuItem))).click();
  }

  public String getPageTitle() {
    return pageTitle.getText();
  }
}
