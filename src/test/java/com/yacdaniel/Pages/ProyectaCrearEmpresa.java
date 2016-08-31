package com.yacdaniel.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by elmo on 8/26/16.
 */
public class ProyectaCrearEmpresa extends UI {
    @FindBy(css = ".textEdit.generalField")
    private WebElement nombreEmpresa;

    @FindBy(css = "#cbxNotify_ContactManager")
    private WebElement notificarGerente;

    @FindBy(css = "#ctl00_ctl00_PageContent_BTPageContent_ctl00_saveContactButton")
    private WebElement guardarEmpresa;

    public ProyectaCrearEmpresa(WebDriver driver) {
        super(driver);
    }

    public void setNombreEmpresa(String nombre){
        nombreEmpresa.clear();
        nombreEmpresa.sendKeys(nombre);
    }

    public String getNombreEmpresa(){
        return nombreEmpresa.getAttribute("value");
    }

    public void setNotificarGerente(){
        notificarGerente.click();
    }

    public boolean getEstadoNotificar(){
        return notificarGerente.isSelected();
    }

    public ProyectaCRMEmpresasPage guardarEmpresa(){
        JavascriptExecutor jse = (JavascriptExecutor) getWebdriver();
        jse.executeScript("window.scrollBy(0,2550)", "");
        return (ProyectaCRMEmpresasPage) navigateToNextPage(guardarEmpresa, ProyectaCRMEmpresasPage.class);
    }





}
