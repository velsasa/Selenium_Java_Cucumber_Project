package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

    public AccountSuccessPage(){
        PageFactory.initElements(Base.driver, this);
    }

    @FindBy(linkText = "Success")
    public static WebElement successBreadCrumb;
}
