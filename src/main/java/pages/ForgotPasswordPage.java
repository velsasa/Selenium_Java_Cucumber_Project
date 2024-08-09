package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

    public ForgotPasswordPage(){
        PageFactory.initElements(Base.driver, this);
    }

    @FindBy(id = "input-email")
    public static WebElement emailField;

    @FindBy(css = "input[type='submit'][value='Continue']")
    public static WebElement continueButton;

}
