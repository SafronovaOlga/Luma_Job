package selpw;import com.microsoft.playwright.Locator;import com.microsoft.playwright.Page;import com.microsoft.playwright.options.AriaRole;import org.testng.annotations.Test;import runner.BaseTest;import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;public class VerifyDescendingSortByPricePWTest extends BaseTest{        private Locator textExact (String text){        return getPage().getByText(text, new Page.GetByTextOptions().setExact(true));    }        private Locator link (String text){        return getPage().getByRole( AriaRole.LINK, new Page.GetByRoleOptions().setName(text));    }        private void openMenTopsPagePW() throws InterruptedException{//        getPage().getByLabel("Соглашаюсь",new Page.GetByLabelOptions());//        // "Consent"//        //getPage().locator("p.fc-button-label").click();//        getPage().navigate("https://magento.softwaretestingboard.com");//       // getPage().locator(".fc-primary-button > p").click();//        getPage().getByLabel("Соглашаюсь",new Page.GetByLabelOptions()).click();//        openBaseUrlPW();        textExact("Men").click();        link("Tops").click();        link("Bottoms").click();    }        @Test    public void testDescendingSortByPricePlayWright() throws InterruptedException{                openMenTopsPagePW();    }        @Test    public void testNavigationBarPW(){        String [] expectedListOfNavBar = {"What's New", "Women", "Men", "Gear", "Training", " Sale"} ;        //        getPage().getByLabel("Consent",new Page.GetByLabelOptions());//        getPage().navigate("https://magento.softwaretestingboard.com/");                openBaseUrlPW();        Locator navBar = getPage().locator(".nav-sections .navigation >ul>li>a");                assertThat(navBar).hasCount(6);        assertThat(navBar).containsText(expectedListOfNavBar);    }    }