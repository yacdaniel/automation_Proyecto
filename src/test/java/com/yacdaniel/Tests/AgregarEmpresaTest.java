package com.yacdaniel.Tests;

import com.yacdaniel.Pages.*;
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
public class AgregarEmpresaTest extends SampleSauceTestBase {
    private ProyectaLoginPage proyectaLoginPage;
    private ProyectaHomePage proyectaHomePage;
    private ProyectaCRMPage proyectaCRMPage;
    private ProyectaCrearEmpresa proyectaCrearEmpresa;
    private ProyectaCRMEmpresasPage proyectaCRMEmpresasPage;

    @Test(dataProvider = "hardCodedBrowsers")
    public void verificarEMpresaCreada(String browser, String version, String os, Method method)
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
        proyectaCRMPage = proyectaHomePage.clickCRM();
        Assert.assertTrue(proyectaCRMPage.isProyectaCRMPageLoaded(), "Proyecta Pagina CRM no cargo");
        proyectaCrearEmpresa = proyectaCRMPage.crearNuevaEmpresa();
        proyectaCrearEmpresa.setNombreEmpresa("Mi empresa Automation");
        proyectaCrearEmpresa.setNotificarGerente();
        Assert.assertTrue(proyectaCrearEmpresa.getEstadoNotificar(),"No se pudo seleccionar el checkbox");
        proyectaCRMEmpresasPage = proyectaCrearEmpresa.guardarEmpresa();
        Assert.assertTrue(proyectaCRMEmpresasPage.getNombreEmpresa().equals("Mi empresa Automation"), "No se pudo guardar empresa");


    }
}
