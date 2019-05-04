package ru.beru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends Page {
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Click login button on home page")
    public void clickLoginBtn() {
        click(By.xpath("//span[@title='Войти в аккаунт']"));
    }

    @Step("Assert login button change")
    public void assertLoginBtnChange() {
        Assert.assertEquals(
                getTitle(By.cssSelector("span.header2-nav-item__icon.header2-nav-item__icon_type_profile")),
                "Мой профиль"
        );
    }
}
