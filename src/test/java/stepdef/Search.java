package stepdef;

import framework.Elements;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.HeaderSection;
import pages.SearchResultsPage;

public class Search {

    HeaderSection headerSection = new HeaderSection();
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @When("I search for a product {string}")
    public void i_search_for_a_product(String product) {
        Elements.TypeText(HeaderSection.searchBoxField, product);
        Elements.click(HeaderSection.searchButton);
    }
    @Then("I should see the product in the search results")
    public void i_should_see_the_product_in_the_search_results() {
        Assert.assertTrue(Elements.isDisplayed(SearchResultsPage.samsungSyncMasterSearchResult));
    }

    @Then("I should see a message informing {string}")
    public void i_should_see_a_message_informing(String message) {
        Assert.assertTrue(Elements.VerifyTextEquals(SearchResultsPage.noResultsMessage, message));
    }

}
