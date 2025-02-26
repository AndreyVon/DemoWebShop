package com.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductHelper extends BaseHelper {
    public ProductHelper(WebDriver driver) {
        super(driver);
    }

    public void deleteProduct() {
        click(By.cssSelector("td [type='checkbox']"));
        click(By.cssSelector("[name='updatecart']"));
    }

    public void clousedAssertInBay() {
        click(By.cssSelector("[class='close']"));
    }

    public void buyProduct(By locator) {
        click(locator);
        clousedAssertInBay();
        pause(500);
        click(By.cssSelector("li:nth-child(3) [class='ico-cart']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("[class='cart-item-row']")));
    }
}
