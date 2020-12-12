package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import steps.CommonSteps;

public class CommonActions {

	private WebDriver driver;
	private WebDriverWait wait;

	public CommonActions(CommonSteps steps) {
		this.driver = steps.getDriver();
	}

	public void getUrl(String url) {
		driver.get(url);

	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public boolean elementIsClicked(WebElement element) {

		try {

			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			return true;
		} catch (Exception e) 
		{
			return false;
		}
	}
	
	public boolean elementIsNotVisible(WebElement element) {
		{
			try {

				wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.invisibilityOf(element));
				return true;
			} catch (Exception e) 
			{
				return false;
			}
		}
	}
}
