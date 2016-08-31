package com.yacdaniel.Pages;

import com.yacdaniel.Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by elmo on 8/25/16.
 */
public class UI {

    private WebDriver driver;

    public UI(WebDriver driver){
        this.driver = driver;
    }


    public WebDriver getWebdriver(){
        return driver;
    }

    public UI navigateToNextPage(WebElement elementToClickOn, Class<?> pageToNavigateTo){
        Utils.waitForElementDisplayed(this.driver, elementToClickOn);
        elementToClickOn.click();
        return (UI) PageFactory.initElements(this.driver, pageToNavigateTo);
    }

}
