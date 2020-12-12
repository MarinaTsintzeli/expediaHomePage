package elements;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaysTab_Elements {
	
	private WebDriver driver;

	@FindBy(xpath = "//span[text()='Stays']")
	public WebElement staysTab;

	@FindBy(xpath = "//button[@data-stid='location-field-destination-menu-trigger']")
	public WebElement goingTo;

	@FindBy(id = "location-field-destination")
	public WebElement locationDestination;
	
	@FindBy(xpath="//li[@class='uitk-typeahead-result-item has-subtext']//div[@class='truncate']//span")
	public List<WebElement> listOfDestinations;
	
	@FindBy(id = "d1-btn")
	public WebElement checkInDateBox;
	
	@FindBy(id = "d2-btn")
	public WebElement checkOutDateBox;
	
	@FindBy(xpath = "//button[@class='uitk-new-date-picker-day']")
	public List<WebElement> enabledDates;
	
	@FindBy(xpath = "//button[@class='uitk-button uitk-button-small uitk-flex-item uitk-button-paging'][2]")
	public WebElement calendarNextMonthArrow;
	
	@FindBy(xpath = "//span[text()='Done']")
	public WebElement calendarDoneButton;
	
	@FindBy(id = "add-flight-switch")
	public WebElement addFlightCheckBox;
	
	@FindBy(id = "add-car-switch")
	public WebElement addCarCheckBox;
	
	@FindBy(id = "multiProp")
	public WebElement multiPlacesToStayCheckBox;
	
	@FindBy(xpath = "//button[@data-testid='submit-button']")
	public WebElement searchButton;
	
	public StaysTab_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
