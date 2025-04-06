package pK_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class launchtheurl {
	WebDriver driver;
  @Test
  public void Login() {
	  System.setProperty("webdriver.chrome.driver", "./Browser/chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://partner.aerem.co/");
  }
}
