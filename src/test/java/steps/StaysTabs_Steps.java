package steps;

import java.util.Map;
import org.junit.Assert;
import actions.CommonActions;
import actions.StaysTab_Actions;
import io.cucumber.datatable.DataTable;
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
		Assert.assertEquals(commonActions.getCurrentUrl(), expectedUrl);
		Assert.assertTrue(staysTabActions.clickStaysTab());
	}

	@When("I fill in {string} {string} {string} {string}")
	public void i_fill_in_stay_form(String city, String district, String checkIn, String checkout) throws Exception {
		
		staysTabActions.enterLocationDestination(city, district);
		staysTabActions.enterCheckInDate(checkIn);
		Thread.sleep(2000);
		staysTabActions.enterCheckOutDate(checkout);

		Thread.sleep(2000);

	}

	@When("i press add flight box and i enter city information")
	public void i_press_add_flight_box_and_i_enter_city_information(DataTable dataTable) {
		Map<String, String> asa = dataTable.asMap(String.class, String.class);
		System.out.println(asa);
		String ct = asa.get("city");
		staysTabActions.clickAddFlight();
		staysTabActions.enterLeavingFromAirport(ct);

	}

	@Then("I am navigated to Search Hotels Page")
	public void i_am_navigated_to_search_hotels_page() {

		Assert.assertTrue(staysTabActions.clickSearchButton());

	}

}
