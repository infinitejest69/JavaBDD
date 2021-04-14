package seleniumtests.pagemodels.bbc.news;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumtests.pagemodels.BasePage;

import java.util.ArrayList;
import java.util.List;

public class NewsHomePage extends BasePage {

  WebDriver driver;
  String page = "https://www.bbc.co.uk/news";
  String MenuSearch = ".//li/a/span[contains(text(),'replace')]";

  @FindBy(xpath = ".//li[2]/a[@class='gs-c-section-link gs-c-section-link--truncate nw-c-section-link nw-o-link nw-o-link--no-visited-state']/span")
  List<WebElement> cSectionLink;


  public NewsHomePage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public String getPageUrl() {
    return page;
  }

  public List<String> getCSectionLinkText(String input) {
    List<String> arrayList = new ArrayList<>();
    for (WebElement clink : cSectionLink) {
      arrayList.add(clink.getText());
    }
    return arrayList;
  }

  public void clickMenuItem(String input) {
    String replace = MenuSearch.replace("replace", input);
    driver.findElement(new By.ByXPath(replace)).click();
  }
}
