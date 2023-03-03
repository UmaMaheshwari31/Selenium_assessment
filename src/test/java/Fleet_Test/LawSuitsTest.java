package Fleet_Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Fleet_PageObjects.RecentLawsuitsPage;
import Fleet_TestComponents.BaseTest;

public class LawSuitsTest extends BaseTest {
	
	@Test
	public void LawSuits () throws IOException {
		
		
		RecentLawsuitsPage recentLawsuitsPage	= launchApplication();
		int lastpagecount = recentLawsuitsPage.LastPagecount();
		int currentpagecount = recentLawsuitsPage.Currentpagecount();
		
		int pagecount = recentLawsuitsPage.getRecentLawsuitsdetails();
		
		int actualpagecount = pagecount-1;
		Assert.assertEquals(lastpagecount, actualpagecount);
				
		}
		
		
	}


