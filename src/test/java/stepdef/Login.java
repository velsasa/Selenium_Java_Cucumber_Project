package stepdef;

import framework.Elements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ForgotPasswordPage;
import pages.HeaderSection;
import pages.LoginPage;
import pages.MyAccountPage;

public class Login {

    HeaderSection headerSection = new HeaderSection();
    LoginPage loginPage = new LoginPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Given("I navigate to Account Login page")
    public void i_navigate_to_account_login_page() {
        Elements.click(HeaderSection.myAccountLink);
        Elements.click(HeaderSection.login);
    }
    @When("I login to the Application using Username {string} and Password {string}")
    public void i_login_to_the_application_using_username_and_password(String email, String password) {

        LoginPage.doLogin(email, password);

    }
    @Then("I should see that the User is able to login successfully")
    public void i_should_see_that_the_user_is_able_to_login_successfully() {
        Assert.assertTrue(Elements.isDisplayed(MyAccountPage.registerAffiliateAccount));
    }

    @Then("I should see an error message that the credentials are invalid")
    public void i_should_see_an_error_message_that_the_credentials_are_invalid() {
     Assert.assertTrue(Elements.VerifyTextEquals(LoginPage.mainWarning, "Warning: No match for E-Mail Address and/or Password."));
    }

    @When("I reset the forgotten password for email {string}")
    public void i_reset_the_forgotten_password_for_email(String email) {
        Elements.click(LoginPage.forgotPassword);
        Elements.TypeText(ForgotPasswordPage.emailField, email);
        Elements.click(ForgotPasswordPage.continueButton);
    }

    @Then("I should see a message informing the User that data information related to reset password have been sent to email address")
    public void i_should_see_a_message_informing_the_user_that_data_information_related_to_reset_password_have_been_sent_to_email_address() {
        Assert.assertTrue(Elements.VerifyTextEquals(LoginPage.mainWarning, "An email with a confirmation link has been sent your email address."));
    }

}
