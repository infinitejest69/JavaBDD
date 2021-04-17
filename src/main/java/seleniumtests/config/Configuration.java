package seleniumtests.config;

import seleniumtests.enums.DriverType;
import seleniumtests.enums.EnvironmentType;
import seleniumtests.enums.ScreenShotLevel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

  private final Properties properties;

  public Configuration() {
    BufferedReader reader;
    String propertyFilePath = "src//test//resources//configuration.properties";
    try {
      reader = new BufferedReader(new FileReader(propertyFilePath));
      properties = new Properties();
      try {
        properties.load(reader);
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
    }
  }

  public String getDriverPath() {
    String driverPath = properties.getProperty("driverPath");
    if (driverPath != null) return driverPath;
    else
      throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
  }

  public ScreenShotLevel getScreenShotPolicy() {
    ScreenShotLevel screenshotPolicy =
        ScreenShotLevel.valueOf(properties.getProperty("screenshotPolicy"));
    if (screenshotPolicy != null) return screenshotPolicy;
    else
      throw new RuntimeException(
          "screenshotPolicy not specified in the Configuration.properties file.");
  }

  public long getImplicitlyWait() {
    String implicitlyWait = properties.getProperty("implicitlyWait");
    if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
    else
      throw new RuntimeException(
          "implicitlyWait not specified in the Configuration.properties file.");
  }

  public DriverType getBrowser() {
    String browserName = properties.getProperty("browser");
    if (browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
    else if (browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
    else if (browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
    else
      throw new RuntimeException(
          "Browser Name Key value in Configuration.properties is not matched : " + browserName);
  }

  public EnvironmentType getEnvironment() {
    String environmentName = properties.getProperty("environment");
    if (environmentName == null || environmentName.equalsIgnoreCase("local"))
      return EnvironmentType.LOCAL;
    else if (environmentName.equals("remote")) return EnvironmentType.REMOTE;
    else
      throw new RuntimeException(
          "Environment Type Key value in Configuration.properties is not matched : "
              + environmentName);
  }

  public Boolean getBrowserWindowSize() {
    String windowSize = properties.getProperty("windowMaximize");
    if (windowSize != null) return Boolean.valueOf(windowSize);
    return true;
  }
}
