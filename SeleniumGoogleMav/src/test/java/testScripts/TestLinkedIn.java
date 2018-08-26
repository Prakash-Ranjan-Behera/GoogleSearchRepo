package testScripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import pom.GooglePO;
import pom.LinkedInGoogleResultPO;

public class TestLinkedIn extends BaseTest {

WebDriverWait wait;
	
	@Test(priority=1)
	public void testLinkedIn()
	{
		try {
			GooglePO googlePO = new GooglePO(driver);
			googlePO.search("linkedIn");
			LinkedInGoogleResultPO linkedInPO = new LinkedInGoogleResultPO(driver);
			System.out.println("Total number of links are "+ linkedInPO.allLinksSize());
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(linkedInPO.clickLinkedInLink(0)));
			linkedInPO.clickLinkedInLink(0).click();
			Thread.sleep(2000);
			String eTitle = "Sign Up | LinkedIn";
			linkedInPO.checkTitle(eTitle);
			String aTitle = driver.getTitle();
			Assert.assertEquals(eTitle, aTitle);
			
		} catch (InterruptedException e) {
			Reporter.log("Exception generated", true);
		}
	}

}
