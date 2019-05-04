package ru.beru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IntermediateProductPage extends Page{
    public IntermediateProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Choose electric toothbrushes")
    public void chooseElectricToothbrushes() {
        click(By.linkText("Электрические зубные щетки"));
    }
}
