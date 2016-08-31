package com.yacdaniel.Tests;

import com.yacdaniel.Pages.*;
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
public class SalirTest extends SampleSauceTestBase {

    private ProyectaHomePage proyectaHomePage;
    private ProyectaLoginPage proyectaLoginPage;
    private ProyectaEditProfile proyectaEditProfile;
    private ProyectaPerfilPage proyectaPerfilPage;

    @Test(dataProvider = "hardCodedBrowsers")
    public void verificarSalir(String browser, String version, String os, Method method)
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
        proyectaLoginPage = proyectaHomePage.clickSalir();
        Assert.assertTrue(proyectaLoginPage.isProyectaLoginPageLoaed(), "Proyecta Pagina Login no cargo");


    }
}
