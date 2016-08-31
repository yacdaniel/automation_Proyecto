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
 * Created by elmo on 8/25/16.
 */
public class CambiarNombreApellidosTest extends SampleSauceTestBase {
    private ProyectaHomePage proyectaHomePage;
    private ProyectaLoginPage proyectaLoginPage;
    private ProyectaEditProfile proyectaEditProfile;
    private ProyectaPerfilPage proyectaPerfilPage;

    @Test(dataProvider = "hardCodedBrowsers")
    public void verificarCambioNombreApellido(String browser, String version, String os, Method method)
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
        proyectaPerfilPage = proyectaHomePage.clickPerfil();
        Assert.assertTrue(proyectaPerfilPage.isProyectaPerfilPageLoaded(), "Proyecta Pagina Perfil no cargo");
        proyectaEditProfile = proyectaPerfilPage.clickEdit();
        Assert.assertTrue(proyectaEditProfile.isProyectaEditProfileLoaded(), "Proyecta Pagina Edit Perfil no cargo");
        proyectaEditProfile.setProfileName("yac");
        proyectaEditProfile.setProfileSecondName("hur");
        proyectaPerfilPage = proyectaEditProfile.savePerfil();
        Assert.assertTrue(proyectaPerfilPage.isProyectaPerfilPageLoaded(), "Proyecta Pagina Perfil no cargo");
        WebElement nameCambiado = getWebDriver().findElement(By.xpath("//*[@id='studioPageContent']/div[2]/table/tbody/tr/td[2]/div[1]/span"));
        String nameCambiadoString = nameCambiado.getText();
        Assert.assertTrue(nameCambiadoString.equals("yac hur"), "El nombre y apellido no se modifico despues de guardar:" +
                "Se esperaba *yac hur* y se encontro"+"*"+nameCambiadoString+"*");


    }
}
