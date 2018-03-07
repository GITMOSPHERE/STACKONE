
package MainPack;

import UIAct.actioner;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;


public class fblogin extends actioner {
		// TODO Auto-generated method stub
	Scenario scenario;

	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}

	GetdatafromExcel datatab = new GetdatafromExcel();
		@Given("^I want to launch fb url$")
		public void i_want_to_launch_fb_url() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			actioner.openBrowser("IE");
			actioner.navigateTo("www.facebook.com");
			System.out.println("Am launcing the browser");
		    		
		}
		@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
		public void User_enters_input_values(String arg1,String arg2) throws Throwable 
		{
		    // Write code here that turns the phrase above into concrete actions
			System.out.println("Into the facebook login form");
			actioner.input(arg1,arg2);
		//	throw new PendingException();
		}

		@And("^clicks login button$")
		public void clicks_login_button() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			actioner.click("LOGIN");
		  //  throw new PendingException();
		}

		@And("^then user clicks logout button$")
		public void then_user_clicks_logout_button() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			actioner.click("LOGOUT");
			System.out.println("Am OUT");
		    //throw new PendingException();
		}

	}


