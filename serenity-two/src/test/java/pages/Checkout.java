package pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class Checkout extends PageObject{

    @Step("Finalizar la compra")
    public void complete()

    {
        WebElementFacade element = element(By.id("continue"));
        element.click();
        WebElementFacade element2 = element(By.id("finish"));
        element2.click();
    }

    @Step("Verificar texto de compra exitoso")
    public void verifyPurchase()
    {
        WebElementFacade element = element(By.xpath("//h2[normalize-space()='Thank you for your order!']"));
        String actualText = element.getText();
        assertThat(actualText).isEqualTo("Thank you for your order!");

    }
}
