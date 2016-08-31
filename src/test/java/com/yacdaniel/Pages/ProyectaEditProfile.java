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
public class ProyectaEditProfile extends UI {
    public ProyectaEditProfile(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "profileFirstName")
    private WebElement profileName;

    @FindBy(id = "profileSecondName")
    private WebElement profileSecondName;

    @FindBy(id = "profileActionButton")
    private WebElement guardarBoton;

    public String getProfileName() {
        return profileName.getAttribute("value");
    }

    public void setProfileName(String name) {
        profileName.clear();
        profileName.sendKeys(name);
    }

    public String getProfileSecondName() {
        return profileSecondName.getAttribute("value");
    }

    public void setProfileSecondName(String  secondName) {
        profileSecondName.clear();
        profileSecondName.sendKeys(secondName);
    }

    public ProyectaPerfilPage savePerfil(){
        return (ProyectaPerfilPage) navigateToNextPage(guardarBoton, ProyectaPerfilPage.class);
    }

    public boolean isProyectaEditProfileLoaded(){
        return Utils.waitForElementPresent(getWebdriver(), By.id("titleEditProfile"), 300);
    }
}
