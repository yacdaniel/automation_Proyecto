package com.yacdaniel.Pages;

import com.yacdaniel.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by elmo on 8/26/16.
 */
public class ProyectaCRMPage extends UI {
    @FindBy(css = ".main-button-text")
    private WebElement menuCrearNuevo;

    public ProyectaCRMPage(WebDriver driver) {
        super(driver);
    }

    public ProyectaCrearEmpresa crearNuevaEmpresa(){
        menuCrearNuevo.click();
        WebElement empresa = getWebdriver().findElement(By.xpath("//*[contains(text(),'Empresa')]"));
        return (ProyectaCrearEmpresa) navigateToNextPage(empresa, ProyectaCrearEmpresa.class);
    }


    public boolean isProyectaCRMPageLoaded(){
        return Utils.waitForElementPresent(getWebdriver(), By.cssSelector(".main-button-text"), 300);
    }
}
