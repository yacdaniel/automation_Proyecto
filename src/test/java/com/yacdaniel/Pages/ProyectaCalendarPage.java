package com.yacdaniel.Pages;

import com.yacdaniel.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by elmo on 8/26/16.
 */
public class ProyectaCalendarPage extends UI{
    public ProyectaCalendarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='fc_container']/div/div[2]/div[3]/span[1]/span[2]")
    protected WebElement cambiarVista;


    public ProyectaCalendarPage cambiarVista(){
        cambiarVista.click();
        WebElement verComoLista = getWebdriver().findElement(By.xpath("//*/div[contains(text(),'Ver como lista')]"));
        return (ProyectaCalendarPage) navigateToNextPage(verComoLista, ProyectaCalendarPage.class);
    }

    public boolean isProyectaCalendarLoaded(){
        return Utils.waitForElementPresent(getWebdriver(), By.xpath("//*[@id='fc_container']/div/div[2]/div[3]/span[1]/span[2]"), 300);
    }
}
