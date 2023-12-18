package partyInboxTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstSection {
    private WebDriver driver;

    public FirstSection(WebDriver driver) {
        this.driver = driver;
    }

    public void setUpFilter() {
        WebElement filter = driver.findElement(By.xpath("//div[@class='filter select']"));
        filter.click();

        WebElement chooseFilter = driver.findElement(By.xpath("//option[@value='p.price-DESC']"));
        chooseFilter.click();

        try {
            // Introduce a 5-second wait
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    public boolean areProductsInDescendingOrder() {
        List<WebElement> productElements = driver.findElements(By.xpath("//div[@class='products-list']//div[@class='product']"));

        List<Double> productPrices = new ArrayList<>();

        // Print header for clarity
        System.out.println("Collected Prices:");

        // Regular expression to match numeric values
        Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");

        for (WebElement element : productElements) {
            // Extracting the numerical value from the price element (assuming it's a number)
            String priceText = element.findElement(By.xpath(".//div[@class='price']")).getText();

            // Use regular expression to find the numeric part
            Matcher matcher = pattern.matcher(priceText);
            if (matcher.find()) {
                double priceValue = Double.parseDouble(matcher.group());
                productPrices.add(priceValue);

                // Print each collected price
                System.out.println(priceValue);
            }
        }

        // Check if the prices are in descending order
        for (int i = 0; i < productPrices.size() - 1; i++) {
            if (productPrices.get(i) < productPrices.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

}