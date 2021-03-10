package pages.Item;


import BaseClasses.BasePageCommon;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.asserts.SoftAssert;


public class ASRemoveItemFromCart extends BasePageCommon {

    SoftAssert softAssert = new SoftAssert();

    private static final String VIEW_SHOPPING_CART_LOC = ("//a[contains(@title,'View my shopping cart')]");
    private static final String REMOVE_ITEM_LINK_LOC = ("//i[contains(@class,'icon-trash')]");
    private static final String CHECKOUT_CART_lOC = ("(//i[contains(@class,'icon-chevron-right right')])[3]");
    private static final String ITEM_COUNTS_LOC = ("//*[@id='summary_products_quantity']");
    private static final String SUMMARYLINK_LOC = ("//span[contains(.,'01. Summary')]");


    public ASRemoveItemFromCart clickViewShoppingCart() {
        actions.click(VIEW_SHOPPING_CART_LOC);
        actions.getDriver().findElement(By.xpath(CHECKOUT_CART_lOC)).isDisplayed();
        return this;
    }

    public ASRemoveItemFromCart clickRevomeItemFromShoppingCart() {
        actions.getDriver().findElement(By.xpath(CHECKOUT_CART_lOC)).isDisplayed();
        actions.click(REMOVE_ITEM_LINK_LOC);
        actions.sleep(10000);
        return this;
    }

    /**
     * Hard Assert example
     **/
    public ASRemoveItemFromCart verifyNumbersOfItemCart(String itemCount) {
        actions.waitForVisible(SUMMARYLINK_LOC);
        Assert.assertEquals(actions.getText(ITEM_COUNTS_LOC), itemCount);
        return this;
    }

}
