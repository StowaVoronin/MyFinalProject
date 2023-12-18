package partyInboxTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        WebElement profileLink = driver.findElement(By.id("user-icone"));
        profileLink.click();
    }

    public void goToCatalog() {
        WebElement catalogMenu = driver.findElement(By.xpath("//a[@class='top_link']"));
        catalogMenu.click();

    }
}
