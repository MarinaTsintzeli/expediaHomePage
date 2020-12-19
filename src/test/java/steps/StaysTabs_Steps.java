package steps;

import org.junit.Assert;

import actions.CommonActions;
import actions.StaysTab_Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StaysTabs_Steps {

	private CommonActions commonActions;
	private StaysTab_Actions staysTabActions;

	public StaysTabs_Steps(CommonActions commonActions, StaysTab_Actions staysTabActions) {

		this.commonActions = commonActions;
		this.staysTabActions = staysTabActions;
	}

	@Given("I am on home page")
	public void i_am_on_home_page() {
		String expectedUrl = "https://www.expedia.com/";
		commonActions.getUrl(expectedUrl);
		Assert.assertEquals(commonActions.getCurrentUrl(), "marimar");
	}

	@When("I fill in {string} {string} {string} {string}")
	public void i_fill_in_stay_form(String city, String district, String checkIn, String checkout) throws Exception {
		Assert.assertTrue(staysTabActions.clickStaysTab());
		staysTabActions.enterLocationDestination(city, district);
		staysTabActions.enterCheckInDate(checkIn);
		Thread.sleep(2000);
		staysTabActions.enterCheckOutDate(checkout);
	
		Thread.sleep(2000);

	}

	@Then("I am navigated to Search Hotels Page")
	public void i_am_navigated_to_search_hotels_page() {

		Assert.assertTrue(staysTabActions.clickSearchButton());
	
	}

}
