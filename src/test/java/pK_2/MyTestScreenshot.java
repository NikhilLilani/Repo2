package pK_2;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class MyTestScreenshot {

	public MyTestScreenshot() {
		// TODO Auto-generated constructor stub
	}
	public void takePageScreenshot_onPass(WebDriver w,String tc)
	{
		System.setProperty("webdriver.chrome.driver","./Browsers/chromedriver.exe");
		TakesScreenshot ts=(TakesScreenshot)w;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"/Test case screenshots/"+tc+".png";
		
		//String destination="file:///C:/java%20project/Sel_Jenkins_proj1/Test case screenshots/"+tc+".png";
	File finaldestination=new File(destination);
	
	try
	{
		FileHandler.copy(source,finaldestination);
		String imgpath=finaldestination.toString();
		Reporter.log("<img src='"+imgpath+"' height='400' width='700' />");
		//Reporter.log("Saved <a href='" + imgpath + "'>"+tc+"</a>");
		//Reporter.log("Saved <a href='" + "http://localhost:8080/job/OrangeHRMDemoQA_JenkinsTest/Sel_Jenkins_proj1$Sel_Jenkins_proj1/ws"+"/Test case screenshots/"+tc+".png" + "'>"+tc+"</a>");

	}
	catch(Exception e)
	{}
	}

}
