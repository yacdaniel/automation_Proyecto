package com.yacdaniel.Utils;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;


public class Utils {
	
	 /**
     * This method allows to select
     * an option in a drop-down.
     *
     * @param selector    Selector to wait for
     * @param option     option to wait for in the drop-down
     * @param driver WebDriver
     * @param expectedPage expected page after select the option in the drop-down
     * @return Select the option set by the user and return the expected page.
     */
	
	 public static <T> T selectDropDownOption(By selector, String option, WebDriver driver, Class<T> expectedPage)
	 {
		 new Select(driver.findElement(selector)).selectByVisibleText(option);                 
		 return PageFactory.initElements(driver, expectedPage);
	 }
	 
	 /**
	     * This method waits up to a number of seconds for an
	     * element to appear in the page.
	     *
	     * @param driver     WebDriver 
	     * @param byElement     Element to wait for
	     * @param noOfSecToWait Max time to wait
	     * @return true = if the element was displayed in the page.
	     *         false = the element was not displayed in the page.
	     */
	  
	 public static boolean waitForElementPresent(WebDriver driver, final By byElement, int noOfSecToWait) {
	        boolean isElementPresent = true;

	        try {
	            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	                    .withTimeout(noOfSecToWait, TimeUnit.SECONDS)
	                    .ignoring(NoSuchElementException.class);

	            wait.until(new Function<WebDriver, WebElement>() {
	                public WebElement apply(WebDriver d) {
	                    d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	                    WebElement we = d.findElement(byElement);
	                    return we;
	                }
	            });
	        } catch (TimeoutException te) {
	            isElementPresent = false;
	        } catch (Exception e) {
	            isElementPresent = false;
	        }
	        return isElementPresent;
	    }
	public static boolean waitForElementDisplayed(WebDriver driver, final WebElement element) {
		boolean isElementEnabled = true;
		if(element!=null){
			try {
				(new WebDriverWait(driver, 30))
						.until(new ExpectedCondition<Object>() {
							public Boolean apply(WebDriver d) {
								return element.isDisplayed();
							}
						});

			} catch (TimeoutException te) {
				isElementEnabled = false;
			}
		} else {
			isElementEnabled = false;
		}
		return isElementEnabled;
	}
}