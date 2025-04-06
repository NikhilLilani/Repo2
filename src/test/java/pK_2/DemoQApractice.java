package pK_2;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoQApractice
{
	WebDriver driver;
	MyTestScreenshot ss=new MyTestScreenshot();
	
  @Test(dataProvider = "excelData")
  public void Registrationform(String Firstname, String Lastname,String Email,String Mobile,String Subjects , String Currentaddress,String State, String city) throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "./Browser/chromedriver.exe");
		driver= new ChromeDriver(); // This will open the Browser
		driver.get("https://demoqa.com/automation-practice-form"); //This will open the given URL.
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(Firstname);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(Lastname);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(Email);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300);");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(Mobile);
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
		js.executeScript("window.scrollBy(0, 300);");
	
		
		driver.findElement(By.xpath("//*[@id='subjectsContainer']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys(Subjects+Keys.ARROW_DOWN+Keys.RETURN);
		Actions act=new Actions(driver);
		act.sendKeys(driver.findElement(By.xpath("//input[@id='subjectsInput']")),Subjects);
		act.build().perform(); //1st step over
		//act.sendKeys(Keys.ARROW_DOWN);
		//act.build().perform(); //2nd step over
		//act.sendKeys(Keys.ARROW_DOWN);
		//act.build().perform(); //3rd step over
		act.sendKeys(Keys.ENTER);
		act.build().perform();  //4th step over
		Thread.sleep(3000);
		
		
		//js.executeScript("window.scrollBy(0, 500);");
		
		//driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys("C:\\Automation workspace\\Sample images\\aerem.jpg");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(Currentaddress);
		Thread.sleep(4000);
		
		ss.takePageScreenshot_onPass(driver, "formbeforesubmit1");
		
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
		
		//driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(1000);
		ss.takePageScreenshot_onPass(driver, "formaftersubmit");
		Thread.sleep(1000);
		//Git Changes by divya
		driver.close();	
  }
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
    	new Object[] { "Rohan", "Mehra", "rohan@gmail.com", "8787879896", "maths" , "Mumbai","NCR", "Delhi" },  // This is the data which will be passed in parameters.
        //new Object[] { "Sa@##$", "Divyak" }, //This is inValid user name and valid 
    };
  }
  @DataProvider(name = "excelData")
  public Object[][] excelDataProvider() throws IOException {

      // We are creating an object from the excel sheet data by calling a method that
      // reads data from the excel stored locally in our system
      Object[][] arrObj = getExcelData(
              "C:\\Automation workspace\\Maven_1\\Test Data\\Details.xlsx","Sheet1");
      return arrObj;
}

  // This method handles the excel - opens it and reads the data from the
  // respective cells using a for-loop & returns it in the form of a string array
  public String[][] getExcelData(String fileName, String sheetName) throws IOException {
      String[][] data = null;
      try {

          FileInputStream fis = new FileInputStream(fileName);
          XSSFWorkbook workbook = new XSSFWorkbook(fis);
          XSSFSheet sheet = workbook.getSheet(sheetName);
          XSSFRow row = sheet.getRow(0);
          int noOfRows = sheet.getPhysicalNumberOfRows();
          int noOfCols = row.getLastCellNum();
          Cell cell;
          data = new String[noOfRows - 1][noOfCols];

          for (int i = 1; i < noOfRows; i++) {
              for (int j = 0; j < noOfCols; j++) {
                  row = sheet.getRow(i);
                  cell = row.getCell(j);
                  data[i - 1][j] = cell.getStringCellValue();
              }
          }
      } catch (Exception e) {
          System.out.println("The exception is: " + e.getMessage());
      }
      return data;
  }
}
