package pages.Item;

import BaseClasses.BasePageCommon;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class ASSearchItem extends BasePageCommon {

    SoftAssert softAssert = new SoftAssert();
    private static final String SEARCH_TEXTFIELD_LOC = "//input[@class='search_query form-control ac_input'][contains(@id,'top')]";
    private static final String SEARCH_BTN_LOC = "//button[@type='submit'][contains(.,'Search')]";
    private static final String POPULAR_LINK_LOC = "//a[@data-toggle='tab'][contains(.,'Popular')]";
    private static final String SEARCHED_TEXT_LOC = "//span[@class='lighter'][contains(.,'Faded Short Sleeve T-shirts')]";
    private static final String GRID_LINK_LOC = "//i[contains(@class,'icon-th-large')]";
    private static final String STATIC_WOMEN_LOC = ("//a[contains(@title,'Women')]");
    private static final String ITEM_COUNTS_LOC = "//span[@class='heading-counter']";



    public ASSearchItem setTextItemSearch(String itemName) throws InterruptedException {
        actions.waitForVisible(POPULAR_LINK_LOC);
        actions.click(SEARCH_TEXTFIELD_LOC);
        actions.sleep(6000);
        actions.getDriver().navigate().refresh();
        actions.setText(SEARCH_TEXTFIELD_LOC, itemName);
        return this;
    }

    public ASSearchItem clickSearchButton() {
        actions.click(SEARCH_BTN_LOC);
        return this;
    }

    public ASSearchItem verifySearchedItemDisplayed() {
        actions.waitForVisible(GRID_LINK_LOC);
        actions.getDriver().findElement(By.xpath(SEARCHED_TEXT_LOC)).isDisplayed();
        return this;
    }

    public ASSearchItem waitForLinkToBeVisible() {
        actions.getDriver().findElement(By.xpath(STATIC_WOMEN_LOC)).isDisplayed();
        return this;
    }

    public ASSearchItem verifyNumbersSearchedItemCartHA(String itemCount) {
        actions.waitForVisible(GRID_LINK_LOC);
        Assert.assertEquals(actions.getText(ITEM_COUNTS_LOC), itemCount);
        actions.sleep(5000);
        return this;
    }

    public ASSearchItem verifyNumbersSearchedItemCartSA(String itemCount) {
        actions.waitForVisible(GRID_LINK_LOC);
        softAssert.assertEquals(actions.getText(ITEM_COUNTS_LOC), itemCount);
        actions.sleep(5000);
        return this;
    }

    public ASSearchItem verifySearchedNonExistingItemMessage(String itemCount) {
        Assert.assertEquals(actions.getText(ITEM_COUNTS_LOC), itemCount);
        actions.sleep(5000);
        return this;
    }
}