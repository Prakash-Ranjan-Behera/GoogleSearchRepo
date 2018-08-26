package testScripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import pom.GooglePO;
import pom.InstaGoogleResultPO;

public class TestInstagram extends BaseTest {

WebDriverWait wait;
	
	@Test(priority=1)
	public void testInstagram()
	{
		try {
			GooglePO googlePO = new GooglePO(driver);
			googlePO.search("instagram");
			InstaGoogleResultPO instaPO = new InstaGoogleResultPO(driver);
			System.out.println("Total number of links are "+ instaPO.allLinksSize());
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(instaPO.clickInstaLink(0)));
			instaPO.clickInstaLink(0).click();
			Thread.sleep(2000);
			String eTitle = "Instagram";
			instaPO.checkTitle(eTitle);
			String aTitle = driver.getTitle();
			Assert.assertEquals(eTitle, aTitle);
			
		} catch (InterruptedException e) {
			Reporter.log("Exception generated", true);
		}
	}
}
