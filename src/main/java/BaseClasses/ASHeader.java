package BaseClasses;

import org.openqa.selenium.JavascriptExecutor;


public class ASHeader extends BasePageCommon {


    public ASHeader scrollToBotton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return this;
    }

}
