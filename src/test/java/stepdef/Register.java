package stepdef;

import base.Base;
import framework.Elements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AccountSuccessPage;
import pages.HeaderSection;
import pages.RegisterPage;


public class Register {

    HeaderSection headerSection = new HeaderSection();
    RegisterPage registerPage = new RegisterPage();
    AccountSuccessPage accountSuccessPage = new AccountSuccessPage();

    @Given("I launch the application")
    public void i_launch_the_application() {

        Base.driver.get(Base.reader.getUrl());

    }

    @And("I navigate to Account Registration page")
    public void i_navigate_to_account_registration_page() {
        Elements.click(HeaderSection.myAccountLink);
        Elements.click(HeaderSection.register);
    }

    @When("I provide all the below valid details")
    public void i_provide_all_the_below_valid_details(io.cucumber.datatable.DataTable dataTable) {

        RegisterPage.enterAllDetails(dataTable, "unique");

    }

    @And("I select the Privacy Policy")
    public void i_select_the_privacy_policy() {

        Elements.click(RegisterPage.privacyPolicy);

    }

    @And("I click on Continue Button")
    public void i_click_on_continue_button() {
        Elements.click(RegisterPage.continueButton);
    }

    @Then("I should see that the User account has successfully created")
    public void i_should_see_that_the_user_account_has_successfully_created() {

        Assert.assertTrue(Elements.isDisplayed(AccountSuccessPage.successBreadCrumb));
    }

    @Then("I should see that the User Account is not created")
    public void i_should_see_that_the_user_account_is_not_created() {
        Assert.assertTrue(Elements.isDisplayed(RegisterPage.registerBreadcrumb));
    }
    @And("I should see the error message informing the User to fill the mandatory fields")
    public void i_should_see_the_error_message_informing_the_user_to_fill_the_mandatory_fields() {
        Assert.assertTrue(Elements.isDisplayed(RegisterPage.firstNameWarning));
        Assert.assertTrue(Elements.isDisplayed(RegisterPage.lastNameWarning));
        Assert.assertTrue(Elements.isDisplayed(RegisterPage.emailWarning));
        Assert.assertTrue(Elements.isDisplayed(RegisterPage.telephoneWarning));
        Assert.assertTrue(Elements.isDisplayed(RegisterPage.passwordWarning));
        Assert.assertTrue(Elements.isDisplayed(RegisterPage.mainWarning));
    }

    @And("I subscribe to Newsletter")
    public void i_subscribe_to_newsletter() {
    Elements.click(RegisterPage.yesToNewsLetter);
    }

    @When("I provide the below duplicate details")
    public void i_provide_the_below_duplicate_details(io.cucumber.datatable.DataTable dataTable) {
        RegisterPage.enterAllDetails(dataTable, "duplicate");
    }
    @Then("I should see that the User is restricted from creating duplicate account")
    public void i_should_see_that_the_user_is_restricted_from_creating_duplicate_account() {

        Assert.assertTrue(Elements.VerifyTextEquals(RegisterPage.mainWarning,"Warning: E-Mail Address is already registered!"));
    }
}
