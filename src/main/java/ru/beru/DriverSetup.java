package ru.beru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverSetup {
    private static EventFiringWebDriver driver;
    private static WebDriverWait wait;

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.opera.driver", "operadriver.exe");

        driver = new EventFiringWebDriver(new OperaDriver());
        driver.register(new WebDriverEventListener());
        driver.get("https://beru.ru/");
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 30);
    }

    @AfterMethod
    public void teardown() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.header2-nav__user")));

        if (driver.findElement(By.cssSelector("div.header2-nav__user")).getText().equals("Мой профиль")) {
            driver.findElement(By.className("header2-nav__user")).click();
            driver.findElement(By.xpath("//a[text()='Выход']")).click();
        }

        driver.quit();
    }
}
