package pages.Item;

import BaseClasses.BasePageCommon;
import org.openqa.selenium.By;

public class ASAddItemToCart extends BasePageCommon {

    private static final String ADD_TO_CART_LOC = "//span[contains(.,'Add to cart')]";
    private static final String ITEM_NAME_lOC = ("//a[@class='product-name'][contains(.,'%s')]");
    // private static final String STATIC_IMG_LOC = ("//img[contains(@class,'logo img-responsive')]");
    private static final String STATIC_WOMEN_LOC = ("//a[contains(@title,'Women')]");
    private static final String CLOSE_MODAL_LOC = ("//span[contains(@class,'cross')]");


    public ASAddItemToCart clickAddToCart() {
        actions.click(ADD_TO_CART_LOC);
        return this;
    }

    public ASAddItemToCart clickCloseModal() {
        actions.click(CLOSE_MODAL_LOC);
        actions.sleep(5000);
        return this;
    }

    public ASAddItemToCart selectItemFromTheList(String itemName) {
        actions.sleep(5000);
        actions.click(ITEM_NAME_lOC, itemName);
        actions.sleep(5000);
        return this;
    }

    public ASAddItemToCart waitForLinkToBeVisible() {
        actions.getDriver().findElement(By.xpath(STATIC_WOMEN_LOC)).isDisplayed();
        return this;
    }

}
