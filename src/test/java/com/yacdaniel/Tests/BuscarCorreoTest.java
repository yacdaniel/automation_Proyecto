package com.yacdaniel.Tests;

import com.yacdaniel.Pages.ProyectaBuscarCorreo;
import com.yacdaniel.Pages.ProyectaCorreoPage;
import com.yacdaniel.Pages.ProyectaHomePage;
import com.yacdaniel.Pages.ProyectaLoginPage;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

/**
 * Created by elmo on 8/26/16.
 */
public class BuscarCorreoTest extends SampleSauceTestBase {
    private ProyectaLoginPage proyectaLoginPage;
    private ProyectaHomePage proyectaHomePage;
    private ProyectaBuscarCorreo proyectaBuscarCorreo;

    @Test(dataProvider = "hardCodedBrowsers")
    public void verificarBuscarCorreo(String browser, String version, String os, Method method)
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
        proyectaBuscarCorreo = proyectaHomePage.clickPersonas();
        Assert.assertTrue(proyectaBuscarCorreo.isProyectaBuscarCorreoLoaded(), "Proyecta Pagina Personas no cargo");
        proyectaBuscarCorreo = proyectaBuscarCorreo.buscar("andrés garita");
        Assert.assertTrue(proyectaBuscarCorreo.isProyectaBuscarCorreoLoaded(), "Proyecta Pagina Personas no cargo");
        Assert.assertTrue(proyectaBuscarCorreo.getEmail().equals("garitamc7@gmail.com"), "El correo encontrado no es correcto");

    }
}
