package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import library.BasePage;

public class FacebookGoogleResultPO extends BasePage {

	public FacebookGoogleResultPO(WebDriver driver) {
		super(driver);
	}
	
	@FindBys({
	@FindBy(xpath="//a")
	})private List<WebElement> allLinks;
	
	public int allLinksSize()
	{
		return allLinks.size();
	}
	
	public WebElement getAllLinks(int i)
	{
		return allLinks.get(i);
	}

	
	@FindBys({
		@FindBy(xpath="//h3/a")
		})private List<WebElement> fbLinks;
		
		public int fbLinksSize()
		{
			return fbLinks.size();
		}
		
		public WebElement clickFBLink(int i)
		{
			return fbLinks.get(i);
		}
}
