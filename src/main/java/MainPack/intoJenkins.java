package MainPack;

import UIAct.actioner;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class intoJenkins extends GetdatafromExcel {	

	Scenario scenario;
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}

	GetdatafromExcel datatab = new GetdatafromExcel();
	
	@Given("^I want to launch localhost URL$")
	public void i_want_to_launch_localhost_URL() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	actioner.openBrowser("IE");
	actioner.navigateTo("http://localhost:8080/login?from=%2F");
	System.out.println("Am launcing the browser");
}

@When("^entered the \"([^\"]*)\" and \"([^\"]*)\" in the login page$")
public void entered_the_and_in_the_login_page(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	
	System.out.println("Into the Jenkis login form");
	
	System.out.println(scenario.getName());
	String test1= datatab.get(scenario.getName(), arg1);
	System.out.println(test1);
	
	actioner.input(datatab.get(scenario.getName(), arg1),datatab.get(scenario.getName(), arg2));
}

@And("^click login button$")
public void click_login_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	actioner.click("Jenkins LIaccess");
//	
}

@Then("^click logout button$")
public void click_logout_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	actioner.click("Jenkins LOaccess");
	
}

}
