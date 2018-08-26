package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import library.BasePage;

public class InstaGoogleResultPO extends BasePage{

	public InstaGoogleResultPO(WebDriver driver) {
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
			})private List<WebElement> instaLinks;
			
			public int instaLinksSize()
			{
				return instaLinks.size();
			}
			
			public WebElement clickInstaLink(int i)
			{
				return instaLinks.get(i);
			}

}
