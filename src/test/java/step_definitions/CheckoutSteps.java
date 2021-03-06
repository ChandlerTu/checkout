package step_definitions;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import implementation.Checkout;

public class CheckoutSteps {

	int bananaPrice;
	Checkout checkout;

	@Given("^the price of a \"([^\"]*)\" is (\\d+)c$")
	public void thePriceOfAIsC(String name, int price) throws Exception {
		bananaPrice = price;
	}

	@When("^I checkout (\\d+) \"(.*?)\"$")
	public void iCheckout(int itemCount, String itemName) throws Throwable {
		checkout = new Checkout();
		checkout.add(itemCount, bananaPrice);
	}

	@Then("^the total price should be (\\d+)c$")
	public void theTotalPriceShouldBeC(int total) throws Throwable {
		assertEquals(total, checkout.total());
	}

}