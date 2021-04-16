package seleniumtests.pagemodels.bbc.iplayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumtests.pagemodels.BasePage;

public class IPlayerHomePage extends BasePage {

  WebDriver driver;
  String page = "https://www.bbc.co.uk/iplayer";

  @FindBy(xpath = ".//*[@aria-label='TV Guide']/span")
  WebElement menu_tvGuide;

  @FindBy(xpath = ".//*[@aria-label='A to Z']/span")
  WebElement menu_A2Z;

  String ChannelIconString = ".//*[@href='#iplayer-icon-replace-active']";

  @FindBy(
      xpath =
          ".//*[@class='day-switcher__item__day typo--bold'][contains(text(),'Today')]/../div[2]")
  WebElement todaysDate;

  public IPlayerHomePage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void clickChanelLogo(String ChannelName) {
    String channel = ChannelName.toLowerCase().replace(" ", "");
    driver.findElement(By.xpath(ChannelIconString.replace("replace", channel))).click();
  }

  public void clickMenuA2Z() {
    menu_A2Z.click();
  }

  public void clickMenuTVGuide() {
    menu_tvGuide.click();
  }

  public String getIPLayerTodaysDate() {
    return todaysDate.getText();
  }

  public String getPageUrl() {
    return driver.getCurrentUrl();
  }

  public String getPageTitle() {
    return driver.getTitle();
  }
}
