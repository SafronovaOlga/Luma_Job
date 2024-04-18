package runner;

import com.microsoft.playwright.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public  class BaseTest {
   private WebDriver driver;
    private final Playwright playwright = Playwright.create();
    private final Browser browser = BaseUtils.createPWBrowser(playwright);
    private BrowserContext context;
    private Page page;
    @BeforeSuite
    void createPlaywrightBrowser() {
        if(!browser.isConnected()) {
            System.exit(1);
        }
    }

    @BeforeMethod
    protected void beforeMethod() {
        driver = BaseUtils.createDriver();
        context = BaseUtils.createContext(browser);
        page = context.newPage();
    }

    @AfterMethod
    protected void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
        if (page != null) {
            page.close();
        }
        if (context != null) {
            context.close();
        }
    }
    
    @AfterSuite(alwaysRun = true)
    void closeBrowser() {
        if (browser.isConnected()) {
            browser.close();
        }
        if(playwright != null) {
            playwright.close();
        }
    }
    
    protected WebDriver getDriver() {
        return driver;
    }

    protected Page getPage() {
        return page;
    }
}