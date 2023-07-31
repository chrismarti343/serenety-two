package pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class Fillout extends PageObject{

    @Step("Usuario va a la apgina de checkout")
    public void gotoCheckout()

    {
        WebElementFacade element = element(By.id("checkout"));
        element.click();
    }

    @Step("Llenar informacion")
    public void filloutInfo()
    {
        $(By.id("first-name")).type("Christian");
        $(By.id("last-name")).type("Martinez");
        $(By.id("postal-code")).type("172148");

    }

}
