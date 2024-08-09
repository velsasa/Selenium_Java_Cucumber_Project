package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    public SearchResultsPage(){
        PageFactory.initElements(Base.driver, this);
    }

    @FindBy(linkText = "Samsung SyncMaster 941BW")
    public static WebElement samsungSyncMasterSearchResult;

    @FindBy(css = "input[id='button-search']+h2+p")
    public static WebElement noResultsMessage;
}
