package partyInboxTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PartyInboxTest extends BaseTest {

    @Test(priority = 10)
    public void loginWithInvalidCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid_username", "invalid_password");

        // Check if login failed as expected
        boolean isNotLoggedIn = driver.findElements(By.xpath("//div[@class='block block-account']")).isEmpty();
        Assert.assertTrue(isNotLoggedIn, "Login with invalid credentials succeeded, but it was expected to fail");
    }




    @Test(priority = 20)
    public void loginWithValidCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("stowa.voronin@gmail.com", "D7600679d");

        boolean isLoggedIn = driver.findElement(By.xpath("//li[@class='asmenine-info']")).isDisplayed();
        Assert.assertTrue(isLoggedIn, "Login with valid credentials failed");
    }


    @Test(priority = 30)
    public void checkPriceFilter() {
        HomePage homePage = new HomePage(driver);
        homePage.goToCatalog();

        FirstSection firstSection = new FirstSection(driver);
        firstSection.setUpFilter();

        boolean arePricesSorted = firstSection.areProductsInDescendingOrder();
        Assert.assertTrue(arePricesSorted, "Prices on the first section page are not in descending order");
    }

}