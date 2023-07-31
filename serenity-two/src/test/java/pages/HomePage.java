package pages;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Assert;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class HomePage extends PageObject{

    @Step("Este paso verifica que este en la primera pagina")
    public void verifyTitle()

    {
        String title=getDriver().getTitle();
        Assert.assertTrue(title.contains("Swag Labs"));
    }

    @Step("Este paso permite ingresar las credenciales")
    public void enterCredentials()
    {
        $(By.id("user-name")).type("standard_user");
        $(By.id("password")).typeAndEnter("secret_sauce");

    }

    @Step("Este paso verifica que el usuario pueda entrar al dashborad")
    public void verifyLogin() throws InterruptedException
    {
        Thread.sleep(2000);
        WebElementFacade element = element(By.xpath("//span[@class='title']"));
        String actualText = element.getText();
        assertThat(actualText).isEqualTo("Products");

    }

}
