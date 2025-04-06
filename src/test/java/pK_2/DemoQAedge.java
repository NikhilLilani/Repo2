package pK_2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoQAedge
{
	WebDriver driver;
	MyTestScreenshot ss=new MyTestScreenshot();
  @Test(dataProvider = "dp")
  public void Registrationform(String Firstname, String Lastname,String Email,String Mobile,String Subjects , String Currentaddress,String State, String city) throws InterruptedException {
	  System.setProperty("webdriver.edge.driver", "./Browser/msedgedriver.exe");
		Thread.sleep(4000);
		
		// Use EdgeOptions to configure browser settings
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");

		//  Force Edge to Use a Fresh Temporary Profile
		options.addArguments("user-data-dir=C:\\TempEdgeProfile"); 

		//  Disable Sign-in and Campaign Features to Avoid Errors
		options.addArguments("--disable-features=EdgeSignin,MsEdgeCampaigns,NurturingBrowserCampaignHistory");

		//  Run Edge in Private Mode
		options.addArguments("--inprivate");

		//  Disable Unwanted Extensions and Services
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-background-mode");
		options.addArguments("--no-first-run");

		// Start Edge with these options
		driver = new EdgeDriver(options);

        
     // Initialize WebDriverWait
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        
		/*
		 * driver= new EdgeDriver(options); // This will open the Browser
		 * driver.get("https://demoqa.com/automation-practice-form"); //This will open
		 * the given URL.
		 * driver.navigate().to("https://demoqa.com/automation-practice-form");
		 * driver.manage().window().maximize(); Thread.sleep(4000);
		 */
        
        // fill the form
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(Firstname);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(Lastname);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(Mobile);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[text()='Sports']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
		Thread.sleep(1000);
		
		//select[@class='react-datepicker__month-select']
		Select month = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
		//month.selectByIndex(1);
		month.selectByValue("5");
		//month.selectByVisibleText("December"); //different way to select month of the calendar
		Thread.sleep(1000);
		Select year = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
		year.selectByVisibleText("1994");
		driver.findElement(By.xpath("(//div[text()='12'])[1]")).click();
		
		driver.findElement(By.xpath("//*[@id='subjectsContainer']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys(Subjects+Keys.ARROW_DOWN+Keys.RETURN);
		Actions act=new Actions(driver);
		act.sendKeys(driver.findElement(By.xpath("//input[@id='subjectsInput']")),Subjects);
		act.build().perform(); //1st step over
//		act.sendKeys(Keys.ARROW_DOWN);
//		act.build().perform(); //2nd step over
//		act.sendKeys(Keys.ARROW_DOWN);
//		act.build().perform(); //3rd step over
		act.sendKeys(Keys.ENTER);
		act.build().perform();  //4th step over
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys("C:\\Automation workspace\\Sample images\\aerem.jpg");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(Currentaddress);
		Thread.sleep(4000);
		
		ss.takePageScreenshot_onPass(driver, "formbeforesubmit1");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0, 500);"); // scroll down to bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", ""); // scroll dynammically vertically till the page height
		//js.executeScript("window.scrollBy(0, -1000);"); // scroll up related to line 53
		Thread.sleep(2000);
		
		Actions act1=new Actions(driver);
		act1.sendKeys(driver.findElement(By.xpath("//input[@id='react-select-3-input']")),State);
		act1.build().perform(); //1st step over
		act1.sendKeys(Keys.ARROW_DOWN);
		act1.build().perform(); //3rd step over
		act1.sendKeys(Keys.ENTER);
		act1.build().perform();  //4th step over
		Thread.sleep(2000);
		Actions act2=new Actions(driver);
		act2.sendKeys(driver.findElement(By.xpath("//input[@id='react-select-4-input']")),city);
		act2.build().perform(); //1st step over
		act2.sendKeys(Keys.ARROW_DOWN);
		act2.build().perform(); //3rd step over
		act2.sendKeys(Keys.ENTER);
		act2.build().perform();  //4th step over
		Thread.sleep(2000);
		
		ss.takePageScreenshot_onPass(driver, "formbeforesubmit");
		
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(1000);
		
		ss.takePageScreenshot_onPass(driver, "formaftersubmit");

		
		
		
  }
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
    	new Object[] { "Rohan", "Mehra", "rohan@gmail.com", "8787879896", "maths" , "Mumbai","NCR", "Delhi" },  // This is the data which will be passed in parameters.
        //new Object[] { "Sa@##$", "Divyak" }, //This is inValid user name and valid 
    };
  }
}

