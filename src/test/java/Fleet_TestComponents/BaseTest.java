package Fleet_TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Fleet_PageObjects.RecentLawsuitsPage;




public class BaseTest {
	
	WebDriver driver ;
	public RecentLawsuitsPage recentLawsuitsPage;
	
	public WebDriver initializeDriver() throws IOException {
	System.setProperty("webdriver.chrome.driver", "C:/Program Files/Exe files/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
}

public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
	TakesScreenshot ts	= (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File desc = new File(System.getProperty("user.dir")+"//reports//"+testCaseName + ".png");
	FileUtils.copyFile(src, desc);
	return System.getProperty("user.dir")+"//reports//"+testCaseName + ".png";
}



@BeforeMethod(alwaysRun=true)
public RecentLawsuitsPage launchApplication() throws IOException {
	driver = initializeDriver();
	recentLawsuitsPage = new RecentLawsuitsPage(driver);
	recentLawsuitsPage.goTo();
	return recentLawsuitsPage;
}

@AfterMethod(alwaysRun=true)
public void tearDown() {
	driver.close();

}
}
