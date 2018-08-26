package testScripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import pom.FacebookGoogleResultPO;
import pom.GooglePO;

public class TestFacebook extends BaseTest {

WebDriverWait wait;
	
	@Test(priority=1)
	public void testFacebook()
	{
		try {
			GooglePO googlePO = new GooglePO(driver);
			googlePO.search("facebook");
			FacebookGoogleResultPO fbPO = new FacebookGoogleResultPO(driver);
			System.out.println("Total number of links are "+ fbPO.allLinksSize());
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(fbPO.clickFBLink(0)));
			fbPO.clickFBLink(0).click();
			Thread.sleep(2000);
			String eTitle = "Facebook – log in or sign up";
			fbPO.checkTitle(eTitle);
			String aTitle = driver.getTitle();
			Assert.assertEquals(eTitle, aTitle);
			
			
		} catch (InterruptedException e) {
			Reporter.log("Exception generated", true);
		}
	}

}
