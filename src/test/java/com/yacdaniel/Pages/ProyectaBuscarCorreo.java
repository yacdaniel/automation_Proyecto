package com.yacdaniel.Pages;

import com.yacdaniel.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by elmo on 8/26/16.
 */
public class ProyectaBuscarCorreo extends UI {
    @FindBy(xpath = "//*[@id='peopleFilter']/div[1]/div[7]/div[3]/input")
    private WebElement inputBuscar;

    @FindBy(css = ".advansed-filter-state.btn-start-filter")
    private WebElement buscar;

    public ProyectaBuscarCorreo(WebDriver driver) {
        super(driver);
    }

    public ProyectaBuscarCorreo buscar(String name){
        inputBuscar.clear();
        inputBuscar.sendKeys(name);
        return (ProyectaBuscarCorreo) navigateToNextPage(buscar, ProyectaBuscarCorreo.class);
    }

    public String getEmail(){
        WebElement email = getWebdriver().findElement(By.xpath("//*[@id='peopleData']/tbody/tr/td[5]/div[1]/span"));
        return  email.getText();
    }

    public boolean isProyectaBuscarCorreoLoaded(){
        return Utils.waitForElementPresent(getWebdriver(), By.cssSelector(".header.text-overflow"), 300);
    }
}
