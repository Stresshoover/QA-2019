package ru.beru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ProductPage extends Page {
    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Enter price range")
    public void enterPriceRange() {
        sendKeys(By.xpath("//input[@name='Цена от']"), "999");
        sendKeys(By.xpath("//input[@name='Цена до']"), "1999");
        waitForVisibility(By.cssSelector("div.NZiH_Kn8Fj"));
    }

    @Step("Click show more button")
    public void clickShowMoreBtn() {
        WebElement showMoreBtn = findElement(By.xpath("//div[@class='n-pager-more__button pager-loader_preload']"));
        while(showMoreBtn.isDisplayed()) {
            showMoreBtn.click();
            waitForVisibility(By.cssSelector("div.grid-snippet.grid-snippet_react.b-zone.b-spy-visible"));
        }
    }

    @Step("Assert shown products prices")
    public void assertProductsPrices() {
        for (WebElement element : driver.findElements(By.cssSelector("div.n-snippet-list div.grid-snippet"))) {
            int price = Integer.parseInt(element.findElement(By.cssSelector("span._1u3j_pk1db span"))
                    .getText().replaceAll("\\s",""));

            Assert.assertTrue(price >= 999 && price <= 1999);
        }
    }

    @Step("Add second to last product to cart")
    public void addProductToCart() {
        List<WebElement> products = driver.findElements(By.cssSelector("button._4qhIn2-ESi._3OWdR9kZRH.THqSbzx07u"));
        products.get(products.size() - 2).click();
    }

    @Step("Go to cart")
    public void goToCart() {
        click(By.cssSelector("span.header2-nav-item__icon.header2-nav-item__icon_type_cart"));
    }
}
