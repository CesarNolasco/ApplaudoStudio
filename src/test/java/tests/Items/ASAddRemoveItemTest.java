package tests.Items;

import org.testng.annotations.Test;
import BaseClasses.BaseTest;
import pages.Item.ASAddItemToCart;
import pages.Item.ASRemoveItemFromCart;


public class ASAddRemoveItemTest extends BaseTest {


    @Test(description = "Add item to shopping cart")
    public void AS_AddRemoveItemToShoppingCart() {

        final String ITEM_NAME = "Faded Short Sleeve T-shirts";
        final String ITEM_COUNT_HA = "1 Product";
        ASAddItemToCart apAddItemToCart = new ASAddItemToCart();
        ASRemoveItemFromCart apRemoveItemFromCart = new ASRemoveItemFromCart();

        apAddItemToCart
                .waitForLinkToBeVisible()
                .selectItemFromTheList(ITEM_NAME)
                .clickAddToCart()
                .clickCloseModal();

        apRemoveItemFromCart
                .clickViewShoppingCart()
                .verifyNumbersOfItemCart(ITEM_COUNT_HA)
                .clickRevomeItemFromShoppingCart();

    }

}
