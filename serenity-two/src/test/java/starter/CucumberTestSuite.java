package starter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import pages.AddProducts;
import pages.Checkout;
import pages.Fillout;
import pages.GotoCart;
import pages.HomePage;

@RunWith(SerenityRunner.class)
public class CucumberTestSuite {

    @Managed
    WebDriver driver;

    @Steps
    HomePage home;

    @Steps
    AddProducts add;

    @Steps
    GotoCart cart;

    @Steps
    Fillout fill;

    @Steps
    Checkout checkout;

    @Test
    public void pruebadeweb() throws InterruptedException
    {
        driver.get("https://www.saucedemo.com/");
        home.verifyTitle();
        home.enterCredentials();
        home.verifyLogin();

        add.addFirstProduct();
        add.verifyFirstProduct();
        add.addSecondProduct();
        add.verifySedcondProduct();

        cart.gotoCart();
        cart.verifyList();

        fill.gotoCheckout();
        fill.filloutInfo();

        checkout.complete();
        checkout.verifyPurchase();
        
    }


}