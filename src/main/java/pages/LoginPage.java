package pages;

import base.Base;
import framework.Elements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Base.driver, this);
    }

    @FindBy(id = "input-email")
    public static WebElement emailField;

    @FindBy(id = "input-password")
    public static WebElement passwordField;

    @FindBy(css = "input[type='submit'][value='Login']")
    public static WebElement loginButton;

    @FindBy(css = "div[class$='alert-dismissible']")
    public static WebElement mainWarning;

    @FindBy(linkText = "Forgotten Password")
    public static WebElement forgotPassword;

    public static void doLogin(String email, String password){
        Elements.TypeText(LoginPage.emailField, email);
        Elements.TypeText(LoginPage.passwordField, password);
        Elements.click(LoginPage.loginButton);
    }

}
