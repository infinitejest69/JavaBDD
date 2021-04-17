package seleniumtests.config;

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

  public screenShotLevel getScreenShotPolicy() {
    screenShotLevel screenshotPolicy =
        screenShotLevel.valueOf(properties.getProperty("screenshotPolicy"));
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

  public enum screenShotLevel {
    NONE,
    FAIL,
    ALL
  }
}
