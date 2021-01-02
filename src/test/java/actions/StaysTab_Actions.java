package actions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import elements.StaysTab_Elements;
import steps.CommonSteps;

public class StaysTab_Actions {

	private WebDriver driver;
	private StaysTab_Elements e;
	private CommonActions actions;

	public StaysTab_Actions(CommonSteps commonsteps,CommonActions actions) {
		this.driver = commonsteps.getDriver();
		this.actions = actions;
		e = new StaysTab_Elements(driver);
	}

	public boolean clickStaysTab() {
		
		return actions.elementIsClicked(e.staysTab);
	}
	
	
	public void enterLocationDestination(String city, String location) {
		e.goingTo.click();
		e.locationDestination.sendKeys(city);

		for (WebElement loc : e.listOfDestinations) {

			if (loc.getText().equals(location)) {
				System.out.println(loc.getText());
				loc.click();
			}
		}

		if (!e.goingTo.getText().equals(location))
			System.out.println("couldnt find match");
	}

	public void iterateThroughCalendar(String date) {
		
		List<WebElement> enabledDatesList = e.enabledDates;
		
		int i = 0;
		while(true) {
			
			if(i==enabledDatesList.size()-1) {
				e.calendarNextMonthArrow.click();
				i=0;
			}
			if (enabledDatesList.get(i).getAttribute("aria-label").contains(date)) {
				enabledDatesList.get(i).click();
				e.calendarDoneButton.click();
				break;
			}
				
			i++;
		}
		
	}
	
	public void enterCheckInDate(String checkInDate){
		e.checkInDateBox.click();
		iterateThroughCalendar(checkInDate);

	}

	public void enterCheckOutDate(String checkOutDate) {
		e.checkOutDateBox.click();
		iterateThroughCalendar(checkOutDate);
		

	}

	public void clickAddFlight() {
		boolean a = actions.elementIsClicked(e.addFlightCheckBox);
		System.out.println(a);
	}
	
	public void enterLeavingFromAirport(String city) {
		e.leavingFrom.click();
		e.locationOrigin.sendKeys(city);
	}
	
	

	public void clickAddCar() {
		// click carCheckBox

	}

	public void multiplacesToStay() {
		// click multiples to stay

	}

	public boolean clickSearchButton() {
		return actions.elementIsClicked(e.searchButton);
		
	}

}