package Fleet_PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RecentLawsuitsPage {
	WebDriver driver;
	public RecentLawsuitsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;  
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//div[@class='blog-pagination-right']/a[1]"))
	WebElement LastpageNumber;
	
	@FindBy(xpath=("//a[@class='active']"))
	WebElement currentpageNumber;
	
	@FindBy(xpath=("//div[@class='post-item ']//div//div//div[2]//div"))
	public List<WebElement> objects;
	
	@FindBy(xpath=("//a[@class='next-link']"))
	WebElement ele;
	
	ArrayList<String> a = new ArrayList();
	int currentpagecount;
	int lastpagecount;
	
	public int Currentpagecount() {
		
		String currentpage = currentpageNumber.getText();
		currentpagecount = Integer.parseInt(currentpage);	
		return currentpagecount;
	}
	
	public  int LastPagecount() {
	//String count =  LastpageNumber.getText();
	//lastpagecount = Integer.parseInt(count);
	lastpagecount = 3;
	
	return lastpagecount;
	}
	

	public void goTo() {
			driver.get("https://www.accessibility.com/digital-lawsuits");
	}
	
	public void clicknext() {
		try {
			WebElement ele = driver.findElement(By.xpath("//a[@class='next-link']"));	
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);		
			}
			catch(Exception e){
				System.out.println("This is the last page");
			}
	}
	
	public int getRecentLawsuitsdetails() {

		 while(currentpagecount <= lastpagecount){
					
					List<WebElement> string = objects;
				
					
					for (WebElement s : string) {
						String details = s.getText();
						String plaintiff = "";
						String Defendant = "";
					
						String[] details1 = details.split("Filing ");
						try {
						plaintiff = details1[0].trim();
						}
						catch(Exception e) {
							System.out.println("plaintiff is empty");
						}
						String[] details2 = details.split("Defendant");
						try {
						Defendant = "Defendant" + details2[1];
						}
						catch(Exception e) {
							System.out.println("Defendant is empty");
						}
									
						a.add(plaintiff);
						a.add(Defendant);
						//System.out.println(a.getText());
						for(int j=0;j<a.size();j++) {
							System.out.println(a.get(j));		
						} 
						
						
				}
					

					currentpagecount++;
					clicknext();
					}
		return currentpagecount;
	}
	
}
