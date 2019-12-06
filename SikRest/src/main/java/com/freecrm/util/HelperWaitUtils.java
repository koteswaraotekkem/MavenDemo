package com.freecrm.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.freecrm.base.CRMTestBase;
import com.google.common.base.Function;

public class HelperWaitUtils {
	public static final String TIME_OUT_EXCEPTION_LOG = "Could not find the expected element";

	public static void clearAndSetText(WebDriver driver, By locator, String text) {
		driver.findElement(locator).clear();
		sleepInSeconds(9);
		driver.findElement(locator).sendKeys(text);
	}

	public static void clickOnElement(WebDriver driver, By locator) {
		driver.findElement(locator).click();

	}
	
	public static void sleepInSeconds(int seconds){
		
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void waitForElementToBeClickable(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}

	public static void fluentWait(WebDriver driver,
			ExpectedCondition<WebElement> condition, Integer timeout) {
		timeout = timeout != null ? timeout : 5;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeout, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		wait.until(condition);
	}

	public static Boolean waitForIsDisplayed(WebDriver driver, By locator,
			Integer timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(locator));
		} catch (TimeoutException exception) {
			System.out.println((TIME_OUT_EXCEPTION_LOG));
			return false;
		}
		return true;
	}

	public static Boolean waitForIsClickable(WebDriver driver, final By locator) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30,
				TimeUnit.SECONDS).pollingEvery(5, TimeUnit.MILLISECONDS);
		// wait.until(new ExpectedCondition<Boolean>() {
		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				try {
					List<WebElement> clickables = wdriver.findElements(locator);
					if (clickables.isEmpty()) {
						return false;
					}
					return clickables.get(0).isDisplayed();
				} catch (StaleElementReferenceException e) {
					System.out.println((e.getMessage() + "\n"));
					System.out.println(("Trying again ..."));
					return false;

				}
			}

		};
		try {
			wait.until(function);
		} catch (TimeoutException e) {
		}
		return true;
	}

}
