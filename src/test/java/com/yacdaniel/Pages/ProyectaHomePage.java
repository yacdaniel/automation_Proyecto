package com.yacdaniel.Pages;

import com.yacdaniel.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by elmo on 8/25/16.
 */
public class ProyectaHomePage extends UI{


    public ProyectaHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='studioPageContent']/div[1]/ul/li[3]/span")
    private WebElement buttonProfile;

    @FindBy(xpath = "//*[@id='studioPageContent']/div[1]/ul/li[4]/a")
    private WebElement buttonCalendar;

    @FindBy(partialLinkText = "Correo")
    private WebElement linkCorreo;

    @FindBy(partialLinkText = "CRM")
    private WebElement linkCRM;

    @FindBy(partialLinkText = "Personas")
    private WebElement linkPersonas;

    public ProyectaPerfilPage clickPerfil(){
        buttonProfile.click();
        WebElement perfil = getWebdriver().findElement(By.xpath("//*[contains(text(),'Perfil')]"));
        return (ProyectaPerfilPage) navigateToNextPage(perfil, ProyectaPerfilPage.class);

    }

    public ProyectaLoginPage clickSalir(){
        buttonProfile.click();
        WebElement salir = getWebdriver().findElement(By.xpath("//*[contains(text(),'Salir')]"));
        return (ProyectaLoginPage) navigateToNextPage(salir, ProyectaLoginPage.class);
    }

    public ProyectaCalendarPage clickCalendar(){
        return (ProyectaCalendarPage) navigateToNextPage(buttonCalendar, ProyectaCalendarPage.class);
    }

    public ProyectaCorreoPage clickCOrreo(){
        return (ProyectaCorreoPage) navigateToNextPage(linkCorreo, ProyectaCorreoPage.class);
    }

    public ProyectaBuscarCorreo clickPersonas(){
        return (ProyectaBuscarCorreo) navigateToNextPage(linkPersonas, ProyectaBuscarCorreo.class);
    }
    public ProyectaCRMPage clickCRM(){
        return (ProyectaCRMPage) navigateToNextPage(linkCRM, ProyectaCRMPage.class);
    }

    public boolean isPoyectaHomePageLoaded(){
        return Utils.waitForElementPresent(getWebdriver(), By.cssSelector(".header-base.big"), 300);
    }

}
