package partyInboxTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        WebElement loginBar = driver.findElement(By.xpath("//input[@name='email']"));
        loginBar.sendKeys(username);

        WebElement passwordBar = driver.findElement(By.xpath("//input[@name='password']"));
        passwordBar.sendKeys(password);

        WebElement logInButton = driver.findElement(By.xpath("//input[@class='button']"));
        logInButton.click();
    }
}
