/*
 * Copyright © 2019, Discovery Networks International
 * Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package com.discovery.discoveryplus.appium.testScenarios;

import org.testng.annotations.Test;
import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.discovery.discoveryplus.appium.baseTest.BaseTest;
import com.discovery.discoveryplus.appium.locators.PageLocators;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestScenarios extends BaseTest {
	PageLocators locators;
	DesiredCapabilities caps = new DesiredCapabilities();
	ExtentReports extent;
	ExtentTest logger;
	double Starttime;
	
	@BeforeTest
	public void init() throws MalformedURLException {
		
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/ExtentReport.html", true);
		extent.addSystemInfo("User Name", "QA");
		extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
		setup();	
		locators = new PageLocators(driver);
	}
	
	
	@Test(priority = 1)
	public void verifyIfSplashScreenIsShownTest() throws Throwable {
		
		 logger = extent.startTest("verifyIfSplashScreenIsShownTest");
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 locators.checkSplashScreenIsDisplayed();
	}
	
	
	@Test(priority = 2)
	public void verifySelectionOfSeasonsTest() throws Throwable {
		
		logger = extent.startTest("verifySelectionOfSeasonsTest");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.findElement(By.id("com.discovery.discoveryplus:id/share_txt"));
		if (driver.findElements(By.id("com.discovery.discoveryplus:id/season_count_textview")).size() != 0) {
			
			Thread.sleep(3000);
			locators.tapOnSeasons();
		} else {
			
			throw new SkipException("Skipping - This content does not have seasons");
		}
	}
	
	
	@Test(priority = 3)
	public void verifySelectionofEpisodesTabTest() throws Throwable {
		
		logger = extent.startTest("verifySelectionofEpisodesTabTest");
	    locators.tapOnEpisodesTab();
	    locators.swipeUp();
		Thread.sleep(3000);
		locators.swipeDown();		
	}
	
	
	@Test(priority = 4)
	public void verifySelectionShortsTabTest() throws Throwable {
		
		logger = extent.startTest("verifySelectionShortsTabTest");
		locators.swipe();
		Thread.sleep(3000);
		locators.tapOnShortsTab();
		locators.swipeUp();
		Thread.sleep(3000);
		locators.swipeDown();
	}
	
		
	@Test(priority = 5)
	public void verifyTraditionalLoginTest() throws Throwable {
		
		logger = extent.startTest("verifyTraditionalLoginTest");
		Thread.sleep(5000);
		locators.tapOnPlay();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		if (driver.findElements(By.id("android:id/button1")).size() != 0) {
			locators.tapOnPopUpLogin();
			locators.enterEmailId();
			locators.enterPassword();
			locators.tapOnShowPassword();
			driver.hideKeyboard();
			Thread.sleep(1500);
			locators.tapOnLogin();
		
		} else {
			
			throw new SkipException("Skipping - This content is Non-Premium. Hence Login is not required ");
			
		}
	}
	
	
	@Test(priority = 6)
	public void verifyPortraitVideoPlayTest() throws Throwable {
		
		logger = extent.startTest("verifyPortraitVideoPlayTest");
		Thread.sleep(17000);
		locators.tapOnPlayerCordinate();
		String initialTime=driver.findElement(By.id("com.discovery.discoveryplus:id/time_current")).getAttribute("text");
		Thread.sleep(4000);
		locators.tapOnPlayerCordinate();
		String finalTime=driver.findElement(By.id("com.discovery.discoveryplus:id/time_current")).getAttribute("text");
		Assert.assertNotEquals(finalTime, initialTime,"Test case Failed as Video is not playing");
		
	}
	
	@Test(priority = 7)
	public void verifyPortraitVideoPauseTest() throws Throwable {
		 
		logger = extent.startTest("verifyPortraitVideoPauseTest");
		locators.pauseVideo();
		
	}
	
	
	@Test(priority = 8)
	public void verifyTapOnPortraitVideoForwardTest() throws Throwable {
		
		logger = extent.startTest("verifyTapOnPortraitVideoForwardTest");
		locators.forwardVideo();
				
	}
	
	
	@Test(priority = 9)
	public void verifyTapOnPortraitVideoRewindTest() throws Throwable {
		
		logger = extent.startTest("verifyTapOnPortraitVideoRewindTest");
		locators.rewindVideo();
				
	}
	
	
	@Test(priority = 10)
	public void verifyPortraitSeekBarScrollTest() throws Throwable {
		
		logger = extent.startTest("verifyPortraitSeekBarScrollTest");
		locators.seekVideo();
	}
	
	
	@Test(priority = 11)
	public void verifyOrientationToLandscapeTest() throws Throwable {
		
		logger = extent.startTest("verifyOrientationToLandscapeTest");
	
		Thread.sleep(5000);
		locators.tapOnPlayerCordinate();
		driver.findElement(By.id("com.discovery.discoveryplus:id/fullscreen")).click();
		Thread.sleep(5000);
		locators.tapOnPlayerCordinate();
		driver.findElement(By.id("com.discovery.discoveryplus:id/btn_prev_episode")).isDisplayed();
		
	}
	
	
	@Test(priority = 12)
	public void verifyLandscapeVideoPlayTest() throws Throwable {
		
		logger = extent.startTest("verifyLandscapeVideoPlayTest");
		Thread.sleep(10000);
		locators.tapOnPlayerCordinate();
		locators.seekback();
		Thread.sleep(6000);
		locators.tapOnPlayerCordinate();
		driver.findElement(By.id("com.discovery.discoveryplus:id/play_pause_button")).click();
		String initialTime=driver.findElement(By.id("com.discovery.discoveryplus:id/time_current")).getAttribute("text");
		Thread.sleep(5000);
		locators.tapOnPlayerCordinate();
		String finalTime=driver.findElement(By.id("com.discovery.discoveryplus:id/time_current")).getAttribute("text");
		Assert.assertNotEquals(finalTime, initialTime,"Test case Failed as Video is not playing");
		
	}
	
	
	@Test(priority = 13)
	public void verifyLandscapeVideoPauseTest() throws Throwable {
		
		logger = extent.startTest("verifyLandscapeVideoPauseTest");
		locators.pauseVideo();
		
	}
	
	
	@Test(priority = 14)
	public void verifyTapOnLandscapeVideoForwardTest() throws Throwable {
		
		logger = extent.startTest("verifyTapOnLandscapetVideoForwardTest");
		locators.forwardVideo();
				
	}
	
	
	@Test(priority = 15)
	public void verifyTapOnLandscapeVideoRewindTest() throws Throwable {
		
		logger = extent.startTest("verifyTapOnLandscapeVideoRewindTest");
		locators.rewindVideo();
	}
	
	
	@Test(priority = 16)
	public void verifyLandscapeSeekBarScrollTest() throws Throwable {
		
		logger = extent.startTest("verifyLandscapeSeekBarScrollTest");
		locators.seekVideo();
		Thread.sleep(3000);
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result) {
		
	    if (result.getStatus() == ITestResult.SUCCESS) {
	    	logger.log(LogStatus.PASS, "Test Case Passed is "+result.getName());
	    } else if (result.getStatus() == ITestResult.FAILURE) {
	    	logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
	    	logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	    } else if (result.getStatus() == ITestResult.SKIP) {
	    	logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	    }
	
	    extent.endTest(logger);
	}
	
	 @AfterTest
	 public void endReport() {
	 
	    extent.flush();
	    extent.close();
	    driver.quit();
	  
	   }

	 
}
