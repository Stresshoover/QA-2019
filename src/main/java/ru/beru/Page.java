package ru.beru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement findElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element);
    }

    public void click(By elementBy) {
        findElement(elementBy).click();
    }

    public void sendKeys(By element, String keys) {
        findElement(element).sendKeys(keys);
    }

    public String getText(By element) {
        return findElement(element).getText();
    }

    public String getTitle(By element) {
        return findElement(element).getAttribute("title");
    }
}
