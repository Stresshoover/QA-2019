package ru.beru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage extends Page {
    private By deliveryBy = By.xpath("//span[contains(text(),'Доставка')]/following-sibling::span");;
    private By productsBy = By.xpath("//span[contains(text(),'Товары')]/following-sibling::span");
    private By totalBy = By.xpath("//span[text()='Итого']/following-sibling::span");
    private By addMoreBy = By.xpath("//span[text()='+']");
    private By deliveryTextBy = By.cssSelector("span._3EX9adn_xp");;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Assert delivery is not free")
    public void assertDelivery() {
        Assert.assertTrue(getText(deliveryTextBy).contains("До бесплатной доставки осталось"));
    }

    @Step("Assert total price")
    public void assertTotalPrice() {
       Assert.assertEquals(
               Integer.parseInt(getText(productsBy).replaceAll("\\D","")) +
                       Integer.parseInt(getText(deliveryBy).replaceAll("\\D","")),
               Integer.parseInt(getText(totalBy).replaceAll("\\D",""))
       );
    }

    @Step("Add product")
    public void addProduct() {
        while(Integer.parseInt(getText(productsBy).replaceAll("\\D","")) <= 2999) {
            click(addMoreBy);
        }
    }

    @Step("Assert delivery is free")
    public void assertFreeDelivery() {
        Assert.assertTrue(getText(deliveryTextBy).contains("бесплатную"));
    }

    @Step("Assert total price with free delivery")
    public void assertTotalPriceAfter() {
        Assert.assertEquals(
                Integer.parseInt(getText(productsBy).replaceAll("\\D","")),
                Integer.parseInt(getText(totalBy).replaceAll("\\D",""))
        );
    }
}
