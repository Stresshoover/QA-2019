package ru.beru;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class BeruTests extends DriverSetup {

    @Test
    public void firstTest() {
        HomePage homePage = new HomePage(getDriver(), getWait());
        homePage.clickLoginBtn();

        LoginPage loginPage = new LoginPage(getDriver(), getWait());
        loginPage.enterLogin();
        loginPage.clickSubmitBtn();
        loginPage.enterPassword();
        loginPage.clickSubmitBtn();

        homePage.assertLoginBtnChange();
    }
}
