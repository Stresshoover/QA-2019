package ru.beru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Enter login")
    public void enterLogin() {
        sendKeys(By.id("passp-field-login"), "minglow@inbox.ru");
    }

    @Step("Enter password")
    public void enterPassword() {
        sendKeys(By.id("passp-field-passwd"), "vytye;yfgjvjom");
    }

    @Step("Click submit button on login page")
    public void clickSubmitBtn() {
        click(By.className("button2_type_submit"));
    }
}
