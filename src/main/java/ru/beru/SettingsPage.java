package ru.beru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SettingsPage extends Page {
    public SettingsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Assert region is the same as delivery region")
    public void assertRegionEqualsDeliveryRegion() {
        Assert.assertEquals(
                getText(By.xpath("//div[@class='layout layout_type_maya']//span[@class='link__inner']")),
                getText(By.xpath("//h2[contains(text(),'Ваш город ')]/span/span"))
        );
    }
}
