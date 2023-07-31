package pages;

import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;


public class AddProducts extends PageObject {

    @Step("Este paso agrega el primer producto al carrito")
    public void addFirstProduct()

    {
        WebElementFacade element = element(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
        element.click();
    }

    @Step("Este paso verifica que el primer producto este agregado en el carrito")
    public void verifyFirstProduct()
    {
        WebElementFacade element = element(By.xpath("//span[@class='shopping_cart_badge']"));
        String actualText = element.getText();
        assertThat(actualText).isEqualTo("1");

    }

    @Step("Este paso agrega el primer producto al carrito")
    public void addSecondProduct()

    {
        WebElementFacade element = element(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        element.click();
    }

    @Step("Este paso verifica que el primer producto este agregado en el carrito")
    public void verifySedcondProduct()
    {
        WebElementFacade element = element(By.xpath("//span[@class='shopping_cart_badge']"));
        String actualText = element.getText();
        assertThat(actualText).isEqualTo("2");

    }


}
