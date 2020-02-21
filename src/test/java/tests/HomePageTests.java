package basicsOfSelenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ArrayDemo {

    @Test

    public void mailTest() throws MalformedURLException{

             DesiredCapabilities dr=null;

             dr=DesiredCapabilities.firefox();

             dr.setBrowserName("firefox");

             dr.setPlatform(Platform.LINUX);

             RemoteWebDriver driver=new RemoteWebDriver(new URL("http://ap-jenkdx-dev:4444/wd/hub"), dr);

             driver.navigate().to("https://www.google.co.in");

             driver.findElement(By.xpath("//*[@id='gs_htif0']")) .sendKeys("Search me");

             driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]")) .click();

             driver.close();

}
}
