package seleniumtests.pagemodels;

import org.openqa.selenium.WebDriver;
import seleniumtests.pagemodels.bbc.iplayer.IPlayerHomePage;
import seleniumtests.pagemodels.bbc.news.NewsHomePage;
import seleniumtests.pagemodels.bbc.sports.SportsHomePage;
import seleniumtests.pagemodels.google.GoogleHomePage;
import seleniumtests.steps.DriverManager;

public class PageManager {

  private final WebDriver driver;
  private GoogleHomePage homePage;
  private NewsHomePage newsHomePage;
  private SportsHomePage sportsHomePage;
  private IPlayerHomePage iPlayerHomePage;

  public PageManager(DriverManager driverManager) {
    this.driver = driverManager.getDriver();
  }

  public IPlayerHomePage getIPlayerHomePage() {
    return (homePage == null) ? iPlayerHomePage = new IPlayerHomePage(driver) : iPlayerHomePage;
  }

  public SportsHomePage getSportsHomePage() {
    return (homePage == null) ? sportsHomePage = new SportsHomePage(driver) : sportsHomePage;
  }

  public GoogleHomePage getGoogleHomePage() {
    return (homePage == null) ? homePage = new GoogleHomePage(driver) : homePage;
  }

  public NewsHomePage getNewsHomePage() {
    return (homePage == null) ? newsHomePage = new NewsHomePage(driver) : newsHomePage;
  }
}
