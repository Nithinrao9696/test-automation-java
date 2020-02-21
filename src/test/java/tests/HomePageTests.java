
import static junit.framework.Assert.assertEquals;
import java.net.URL;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class is responsible to test the UserInterface using Selenium Grid concept
 */
public class UISeleniumGridTest {
  private static final Logger log = Logger.getLogger(UISeleniumGrid.class);
  private static Wait<WebDriver> wait;
  private static DesiredCapabilities capabillities;
  private static WebDriver driver;
  @BeforeClass
  public static void setUp() throws Exception {  
    capabillities = DesiredCapabilities.firefox();
    /** URL is the selenium hub URL here **/
    driver = new RemoteWebDriver(new URL("http://ap-jenkdx-dev:4444/wd/hub"), capabillities);
    capabillities.setBrowserName("firefox"); 
    wait = new WebDriverWait(driver, 6000);
  }
  /**
     * To test the UI
     * @throws Exception
     */
  @Test
  public void testUI() throws Exception {     
    /** Your application URL which you want to test **/
    driver.get("http://localhost:8090/myapp/index.html"); 
    wait.until(new ExpectedCondition<Boolean>() {  
      public Boolean apply(WebDriver webDriver) {     
        log.info("Please be patience .... Searching ...");  
        return webDriver.findElement(By.tagName("title")) != null;          
      }         
    });
    log.info(driver.findElement(By.tagName("body")).getText());
    assertEquals("URL must be http://localhost:8090/myapp/index.html", "http://localhost:8090/myapp/index.html", driver.getCurrentUrl());
    /** put other asserts as well **/
  }
  @AfterClass
  public static void tearDown() throws Exception {
    driver.quit();  
  }
}
