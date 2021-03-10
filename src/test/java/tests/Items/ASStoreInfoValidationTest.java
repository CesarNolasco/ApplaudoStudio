package tests.Items;

import BaseClasses.BaseTest;
import BaseClasses.BaseTest;
import org.testng.annotations.Test;
import pages.Item.ASSearchItem;
import pages.Item.ASStoreInformation;


public class ASStoreInfoValidationTest extends BaseTest {

    @Test(description = "Validate store information Test")
    public void AS_ValidateStoreInformation() {

        ASStoreInformation asStoreInformation = new ASStoreInformation();

        asStoreInformation
                .moveDown()
                .checkStoreInformation();
    }
}
