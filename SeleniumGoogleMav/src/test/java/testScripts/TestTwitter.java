package testScripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import pom.GooglePO;
import pom.TwitterGoogleResultPO;

public class TestTwitter extends BaseTest{

WebDriverWait wait;
	
	@Test(priority=1)
	public void testTwitter()
	{
		try {
			GooglePO googlePO = new GooglePO(driver);
			googlePO.search("twitter");
			TwitterGoogleResultPO twitterPO = new TwitterGoogleResultPO(driver);
			System.out.println("Total number of links are "+ twitterPO.allLinksSize());
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(twitterPO.clickTwitterLink(0)));
			twitterPO.clickTwitterLink(0).click();
			Thread.sleep(2000);
			String eTitle = "Login on Twitter";
			twitterPO.checkTitle(eTitle);
			String aTitle = driver.getTitle();
			Assert.assertEquals(eTitle, aTitle);
			
		} catch (InterruptedException e) {
			Reporter.log("Exception generated", true);
		}
	}

}
