package com.yacdaniel.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by elmo on 8/26/16.
 */
public class ProyectaCRMEmpresasPage extends UI {

    @FindBy(css = ".crm-pageHeaderText.text-overflow")
    private WebElement nombreEmpresa;

    public ProyectaCRMEmpresasPage(WebDriver driver) {
        super(driver);
    }

    public String getNombreEmpresa(){
        return nombreEmpresa.getText();
    }
}
