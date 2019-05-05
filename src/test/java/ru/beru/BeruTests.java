package ru.beru;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class BeruTests extends DriverSetup {

    @DataProvider(name = "regions")
    public Object[][] createData(){
        return new Object[][] { { "Хвалынск" }, { "Саратов" } };
    }

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

    @Test
    public void thirdTest() {
        HomePage homePage = new HomePage(getDriver(), getWait());
        homePage.clickCatalogBtn();
        homePage.chooseToothbrushes();

        (new IntermediateProductPage(getDriver(), getWait())).chooseElectricToothbrushes();

        ProductPage productPage = new ProductPage(getDriver(), getWait());
        productPage.enterPriceRange();
        productPage.clickShowMoreBtn();
        productPage.assertProductsPrices();
        productPage.addProductToCart();
        productPage.goToCart();

        CartPage cartPage = new CartPage(getDriver(), getWait());
        cartPage.assertDelivery();
        cartPage.assertTotalPrice();
        cartPage.addProduct();
        cartPage.assertFreeDelivery();
        cartPage.assertTotalPriceAfter();
    }
}
