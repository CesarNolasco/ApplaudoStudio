package pages.Item;

import BaseClasses.ASHeader;
import BaseClasses.BasePageCommon;
import org.openqa.selenium.By;


public class ASStoreInformation extends BasePageCommon {

    ASHeader asHeader = new ASHeader();
    private final static String STORE_INFORMATION_LBL_LOC = "//h4[contains(.,'Store information')]";
    private final static String STORE_ADDRESS_LBL_LOC = "//*[@id=\"block_contact_infos\"]//div//ul//li[contains(.,'Selenium Framework, Research Triangle Park')]";
    private final static String STORE_PHONE_NUMBER_LBL_LOC = "//span[contains(.,'(347) 466-7432')]";
    private final static String STORE_EMAIL_LBL_LOC = "//a[contains(.,'support@seleniumframework.com')]";
    private final static String LOCATION_ICON_LOC = "//i[contains(@class,'icon-map-marker')]";


    public ASStoreInformation clickLocationIcon() {
        actions.click(LOCATION_ICON_LOC);
        return this;
    }

    public ASStoreInformation moveDown() {
        asHeader.scrollToBotton();
        actions.sleep(6000);
        return this;
    }

    public void waitForStoreInformationLabelForVisible() {
        actions.waitForVisible(STORE_INFORMATION_LBL_LOC);
    }

    public void verifyStoreAddress() {
        actions.getDriver().findElement(By.xpath(STORE_ADDRESS_LBL_LOC)).isDisplayed();
    }

    public void verifyStorePhoneNumber() {
        actions.getDriver().findElement(By.xpath(STORE_PHONE_NUMBER_LBL_LOC)).isDisplayed();
    }

    public void verifyStoreEmail() {
        actions.getDriver().findElement(By.xpath(STORE_EMAIL_LBL_LOC)).isDisplayed();
    }

    public ASStoreInformation checkStoreInformation() {

        waitForStoreInformationLabelForVisible();
        clickLocationIcon();
        verifyStoreAddress();
        verifyStorePhoneNumber();
        verifyStoreEmail();
        actions.sleep(10000);
        return this;
    }

}
