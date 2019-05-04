package ru.beru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends Page {
    private By loginBtn = By.cssSelector("span.header2-nav-item__icon.header2-nav-item__icon_type_profile");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Click login button on home page")
    public void clickLoginBtn() {
        click(loginBtn);
    }

    @Step("Assert login button change")
    public void assertLoginBtnChange() {
        Assert.assertEquals(
                getTitle(loginBtn),
                "Мой профиль"
        );
    }

    @Step("Click change region button")
    public void clickChangeRegionBtn() {
       click(By.xpath("//span[text()='Регион: ']//span[@class='link__inner']"));
    }

    @Step("Enter region")
    public void enterRegion(String region) {
        sendKeys(By.cssSelector("form.region-select-form input"), region);
        click(By.cssSelector("div.region-suggest__list-item"));
    }

    @Step("Click continue with new region button")
    public void clickContinueWithNewRegionBtn(){
       click(By.xpath("//div[@class='header2-region-popup']//button"));
    }

    @Step("Assert region change")
    public void assertRegionChange(String region){
        Assert.assertEquals(
                getText(By.xpath("//span[text()='Регион: ']//span[@class='link__inner']")),
                region
        );
    }

    @Step("Click settings button")
    public void clickSettingsBtn() {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(loginBtn)).build().perform();
        click(By.cssSelector("li.header2-user-menu__item.header2-user-menu__item_type_settings"));
    }

    @Step("Click catalog button")
    public void clickCatalogBtn() {
        click(By.cssSelector("div.n-topmenu-new-vertical__left > div > button"));
    }

    @Step("Choose toothbrushes in catalog")
    public void chooseToothbrushes() {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(By.linkText("Бытовая техника"))).build().perform();
        click(By.linkText("Зубные щетки и ирригаторы"));
    }
}
