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
public class ProyectaPerfilPage extends UI {

    public ProyectaPerfilPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userMenu")
    private WebElement menuEdit;



    @FindBy(css = ".top-logo>img")
    private WebElement logoInicio;


    public ProyectaEditProfile clickEdit(){
        menuEdit.click();
        WebElement editar = getWebdriver().findElement(By.xpath("//*[contains(text(),'Editar')]"));
        return (ProyectaEditProfile) navigateToNextPage(editar, ProyectaEditProfile.class);

    }

    public ProyectaHomePage clickLogo(){
        logoInicio.click();
        ProyectaHomePage proyectaHomePage = PageFactory.initElements(this.getWebdriver(), ProyectaHomePage.class);
        return  proyectaHomePage;
    }
    public boolean isProyectaPerfilPageLoaded(){
        return Utils.waitForElementPresent(getWebdriver(), By.xpath("//*[@id='studioPageContent']/div[2]/table/tbody/tr/td[2]/div[1]/span"), 300);
    }
}
