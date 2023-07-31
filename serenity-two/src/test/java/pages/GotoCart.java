package pages;


import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class GotoCart extends PageObject{

    @Step("Ir a la pagina de Compras")
    public void gotoCart()

    {
        WebElementFacade element = element(By.xpath("//a[@class='shopping_cart_link']"));
        element.click();
    }

    @Step("Verificar que los productos esten en la lista")
    public void verifyList()
    {
        WebElementFacade element = element(By.xpath("//div[normalize-space()='Sauce Labs Bike Light']"));
        String actualText = element.getText();
        assertThat(actualText).isEqualTo("Sauce Labs Bike Light");

        WebElementFacade element2 = element(By.xpath("//div[normalize-space()='Sauce Labs Backpack']"));
        String actualText2 = element2.getText();
        assertThat(actualText2).isEqualTo("Sauce Labs Backpack");


    }

}
