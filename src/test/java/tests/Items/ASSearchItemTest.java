package tests.Items;

import BaseClasses.BaseTest;
import org.testng.annotations.Test;
import pages.Item.ASSearchItem;

public class ASSearchItemTest extends BaseTest {

    @Test(description = "Search an existing item Test")
    public void AS_SearchItemShoppingCart() throws InterruptedException {

        final String ITEM_NAME = "Faded Short Sleeve T-shirts";
        final String SEARCH_RESULT_SA = "1 result has been";
        final String SEARCH_RESULT_HA = "1 result has been found.";

        ASSearchItem asSearchItem = new ASSearchItem();

        asSearchItem
                .waitForLinkToBeVisible()
                .setTextItemSearch(ITEM_NAME)
                .clickSearchButton()
                //SoftAssert example
                .verifyNumbersSearchedItemCartSA(SEARCH_RESULT_SA)
                .verifySearchedItemDisplayed()
                //Hard Assert example
                .verifyNumbersSearchedItemCartHA(SEARCH_RESULT_HA);
    }

    @Test(description = "Search a non existing item Test")
    public void AS_SearchNonExistingItemShoppingCart() throws InterruptedException {

        final String ITEM_NAME = "Zara";
        final String SEARCH_RESULT = "0 results have been found.";

        ASSearchItem asSearchItem = new ASSearchItem();

        asSearchItem
                .waitForLinkToBeVisible()
                .setTextItemSearch(ITEM_NAME)
                .clickSearchButton()
                .verifySearchedNonExistingItemMessage(SEARCH_RESULT);
    }

}
