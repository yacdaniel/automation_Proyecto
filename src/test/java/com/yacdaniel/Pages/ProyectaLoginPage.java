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
public class ProyectaLoginPage extends UI{

    public ProyectaLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login")
    private WebElement emailLogin;

    @FindBy(id = "pwd")
    private WebElement pwdLogin;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    public void setEmail(String email){
        emailLogin.clear();
        emailLogin.sendKeys(email);
    }

    public static ProyectaLoginPage getPage(WebDriver driver) {
        return PageFactory.initElements(driver, ProyectaLoginPage.class);
    }

    public void setPassword(String password){//test123
        pwdLogin.clear();
        pwdLogin.sendKeys(password);
    }


    public ProyectaHomePage clickLogin(){
        return (ProyectaHomePage) navigateToNextPage(loginButton, ProyectaHomePage.class);
    }

    public boolean isProyectaLoginPageLoaed(){
        return Utils.waitForElementPresent(getWebdriver(), By.id("loginButton"), 300);
    }

    public String getEmailLoginText() {
        return emailLogin.getAttribute("value");
    }

    public String getPwdLoginText() {
        return pwdLogin.getAttribute("value");
    }
}
