package BaseClasses;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected Actions actions;
    protected ASHeader asHeader;
    protected WebDriver webDriver;

    protected static String CHROME_DRIVER_PATH;

    /**
     * @BeforeMethod is used to state that the method under it will be executed before each test case.
     * Required.
     */

    @BeforeMethod
    @Parameters({"baseUrl", "hostOs"})
    public void setUp(String baseUrl, String hostOs) {


        switch (hostOs) {
            case "linux":
            CHROME_DRIVER_PATH = "src/main/resources/drivers/linux/chromedriver.exe";
                break;
            default:
            CHROME_DRIVER_PATH = "src/main/resources/drivers/windows/chromedriver.exe";
      break;
        }

        webDriver = WebDriverFactory.initWebDriver(WebDriverFactory.WebDriverType.CHROME, CHROME_DRIVER_PATH);
        WebDriverActionsManager.setWebDriverActions(webDriver);
        webDriver.get(baseUrl);
       actions = WebDriverActionsManager.getWebDriverActions();
       asHeader = new ASHeader();
    }

    /**
     * @AfterMethod annotation is used to state that the method under it will be executed after each test case.
     * Required.
     */
    @AfterMethod
    public void tearDown() {
        WebDriverActionsManager.closeDriver();
    }
}

