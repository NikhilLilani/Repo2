package pK_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class workflow {
	WebDriver driver;
	MyTestScreenshot ss=new MyTestScreenshot();
  @Test (enabled=true)
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "./Browser/chromedriver.exe");
		driver= new ChromeDriver(); // This will open the Browser
		driver.get("https://somecorp-alpha.cloudeagle.us/app/signin");
		//driver.get("https://demoqa.com/automation-practice-form"); //This will open the given URL.
		driver.manage().window().maximize();
		Thread.sleep(4000);
	
	    driver.findElement(By.name("emailField")).sendKeys("cetesting10+sa_somecorp@gmail.com");
	    driver.findElement(By.name("passField")).sendKeys("fNo(KuAGZ#8{--)AF\'");
	    driver.findElement(By.cssSelector(".style_color-white1__NPBmj")).click();
	    try {
	      Thread.sleep(6000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    driver.findElement(By.cssSelector(".apphome_toggleNav__0fp07 > .icon_iconSvg__6ww0b")).click();
	    try {
	      Thread.sleep(3000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    driver.findElement(By.xpath(" //label[text()=\'Workflows\']")).click();
	    try {
	      Thread.sleep(6000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    driver.get("https://somecorp-alpha.cloudeagle.us/app/workflow");
	    try {
	      Thread.sleep(6000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    driver.findElement(By.xpath("//div[3]/div/div/div/div[3]/div/div")).click();
	    try {
	      Thread.sleep(6000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    driver.findElement(By.xpath("//span[text()=\'my req name\']")).click();
	    try {
	      Thread.sleep(3000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    driver.findElement(By.xpath("//*[@id=\"mentions_input\"]")).click();
	    driver.findElement(By.cssSelector(".activity-mention-input__control > #mentions_input")).sendKeys("This is test comment ");
	    try {
	      Thread.sleep(3000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    driver.findElement(By.xpath("//h7[contains(.,\'Send\')]")).click();
	    try {
	      Thread.sleep(3000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	  
  }
}
