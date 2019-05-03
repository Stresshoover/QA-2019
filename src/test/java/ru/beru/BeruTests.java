package ru.beru;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class BeruTests {

    @Test
    public void firstTest() {
        System.setProperty("webdriver.opera.driver", "operadriver.exe");
        WebDriver driver = new OperaDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);

        driver.get("https://beru.ru/");

        driver.findElement(By.xpath("//span[@title='Войти в аккаунт']")).click();

        driver.findElement(By.name("login")).sendKeys("minglow@inbox.ru");
        driver.findElement(By.cssSelector("button.control.button2.button2_view_classic." +
                "button2_size_l.button2_" +
                "theme_action.button2_width_max." +
                "button2_type_submit.passp-form-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwd")));
        driver.findElement(By.name("passwd")).sendKeys("vytye;yfgjvjom");
        driver.findElement(By.cssSelector("button.control.button2.button2_view_classic." +
                                          "button2_size_l.button2_" +
                                          "theme_action.button2_width_max." +
                                          "button2_type_submit.passp-form-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.header2-nav-item__icon.header2-nav-item__icon_type_profile")));
        Assert.assertEquals(driver.findElement(By.cssSelector("span.header2-nav-item__icon.header2-nav-item__icon_type_profile")).getAttribute("title"),"Мой профиль");
        driver.quit();
    }
}
