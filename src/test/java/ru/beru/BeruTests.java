package ru.beru;

import org.testng.annotations.DataProvider;
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

    @DataProvider(name = "regions")
    public Object[][] createData(){
        return new Object[][] { { "Хвалынск" }, { "Саратов" } };
    }


    @Test(dataProvider = "regions")
    public void secondTest(String region) {
        HomePage homePage = new HomePage(getDriver(), getWait());
        homePage.clickChangeRegionBtn();
        homePage.enterRegion(region);
        homePage.clickContinueWithNewRegionBtn();
        homePage.assertRegionChange(region);

        homePage.clickLoginBtn();
        LoginPage loginPage = new LoginPage(getDriver(), getWait());
        loginPage.enterLogin();
        loginPage.clickSubmitBtn();
        loginPage.enterPassword();
        loginPage.clickSubmitBtn();

        homePage.clickSettingsBtn();
        SettingsPage settingsPage = new SettingsPage(getDriver(), getWait());
        settingsPage.assertRegionEqualsDeliveryRegion();
    }
}
