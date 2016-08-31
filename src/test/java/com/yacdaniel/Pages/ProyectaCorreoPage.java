package com.yacdaniel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by elmo on 8/26/16.
 */
public class ProyectaCorreoPage extends UI {

    public ProyectaCorreoPage(WebDriver driver) {
        super(driver);
    }


    public String añadirCuentaMensaje(){
        WebElement añadirEmail = getWebdriver().findElement(By.cssSelector(".button.huge.create-button"));
        añadirEmail.click();

        //left email empty

        WebElement contraseña = getWebdriver().findElement(By.cssSelector("#password"));
        contraseña.clear();
        contraseña.sendKeys("soyunaContraseña");

        WebElement añadir = getWebdriver().findElement(By.id("save"));
        añadir.click();

        WebElement error = getWebdriver().findElement(By.xpath("//*[@id='mail_EMailContainer']/span"));
        return error.getText();
    }
}
