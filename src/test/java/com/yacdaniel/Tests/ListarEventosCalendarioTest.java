package com.yacdaniel.Tests;

import com.yacdaniel.Pages.ProyectaCalendarPage;
import com.yacdaniel.Pages.ProyectaHomePage;
import com.yacdaniel.Pages.ProyectaLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

/**
 * Created by elmo on 8/26/16.
 */
public class ListarEventosCalendarioTest extends SampleSauceTestBase{
    private ProyectaHomePage proyectaHomePage;
    private ProyectaCalendarPage proyectaCalendarPage;
    private ProyectaLoginPage proyectaLoginPage;

    @Test(dataProvider = "hardCodedBrowsers")
    public void verificarListadoEventos(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        this.createDriver(browser, version, os, method.getName());//saucelabs
        WebDriver driver = this.getWebDriver();//sauce labs
        driver.get("http://proyecta.uned.ac.cr/auth.aspx");
        proyectaLoginPage = PageFactory.initElements(driver, ProyectaLoginPage.class);
        Assert.assertTrue(proyectaLoginPage.isProyectaLoginPageLoaed(), "Proyecta Pagina no cargo");
        proyectaLoginPage.setEmail("yacdaniel@gmail.com");
        proyectaLoginPage.setPassword("pwd");
        proyectaHomePage = proyectaLoginPage.clickLogin();
        Assert.assertTrue(proyectaHomePage.isPoyectaHomePageLoaded(), "Proyecta Pagina inicio no cargo");
        proyectaCalendarPage = proyectaHomePage.clickCalendar();
        Assert.assertTrue(proyectaCalendarPage.isProyectaCalendarLoaded(), "Proyecta Pagina Calendar no cargo");
        proyectaCalendarPage = proyectaCalendarPage.cambiarVista();
        //Assert.assertTrue(proyectaCalendarPage.isProyectaCalendarLoaded(), "Proyecta Pagina Calendar no cargo");
        //for (int i = 0; i < 4; i++) {
        //    String xpathTemp = "//*[@id='fc_container']/div/div[2]/div[3]/span[3]/span["+(1+i)+"]/span/span";
        //    System.out.println(xpathTemp);
        //    WebElement temp = getWebDriver().findElement(By.xpath(xpathTemp));
        //    proyectaCalendarPage = (ProyectaCalendarPage) proyectaCalendarPage.navigateToNextPage(temp, ProyectaCalendarPage.class);
        //    Assert.assertTrue(proyectaCalendarPage.isProyectaCalendarLoaded(), "Proyecta Pagina Calendar no cargo");
        //    WebElement noEventos = getWebDriver().findElement(By.xpath("//*/div[contains(text(),'No hay eventos')]"));
        //    //Assert.assertTrue(noEventos.getText().equals("No hay eventos para mostrar."), "No se obtuvo de manera correcta el mensaje para eventos");
        //}
    }
//TODO
    //FIX abajo
}
