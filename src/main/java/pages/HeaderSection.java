package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderSection {

    public HeaderSection(){
        PageFactory.initElements(Base.driver, this); // every time automatically initialize web elements below
    }

    @FindBy(xpath = "//span[text()=\"My Account\"]")
    public static WebElement myAccountLink;

    @FindBy(linkText="Register")
    public static WebElement register;

    @FindBy(linkText = "Login")
    public static WebElement login;

    @FindBy(name = "search")
    public static WebElement searchBoxField;

    @FindBy(css = "button[class$='btn-lg']")
    public static WebElement searchButton;

}
