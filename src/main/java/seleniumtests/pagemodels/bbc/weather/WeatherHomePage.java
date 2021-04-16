package seleniumtests.pagemodels.bbc.weather;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherHomePage {

  WebDriver driver;
  String page = "https://www.bbc.co.uk/weather";

  @FindBy(id = "ls-c-search__input-label")
  WebElement locationSearchBar;

  @FindBy(xpath = ".//input[@type='submit']")
  WebElement submitLocationButton;

  @FindBy(id = "wr-location-name-id")
  WebElement locationTitle;

  public WeatherHomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void inputLocation(String location) {
    locationSearchBar.sendKeys(location);
  }

  public void clickSubmit(){
    submitLocationButton.click();
  }

  public String getLocationText() {
    return locationTitle.getText();
  }
}
