/*
 * Copyright © 2019, Discovery Networks International
 * Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package com.discovery.discoveryplus.appium.locators;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class PageLocators {
		AppiumDriver<MobileElement> driver;
	
		public By premium_badge= By.id("com.discovery.discoveryplus:id/premium_badge");
		public By videoPlayButton= By.id("com.discovery.discoveryplus:id/play_circle_imageview");
	    public By emailId= By.id("com.discovery.discoveryplus:id/user_name_et");
		public By password=By.id("com.discovery.discoveryplus:id/password_et");
		public By loginBtn=By.id("com.discovery.discoveryplus:id/login_btn");
		public By episodes=By.xpath("//b.a.a.a.c[@content-desc='Episodes']/android.widget.TextView");
		public By shorts=By.xpath("//b.a.a.a.c[@content-desc='Shorts']/android.widget.TextView");
		public By start=By.id("com.discovery.discoveryplus:id/share_txt");
		public By end=By.id("com.discovery.discoveryplus:id/description_textview");
		public By Splash=By.id("com.discovery.discoveryplus:id/launcher_layout");
		public By seasons=By.id("com.discovery.discoveryplus:id/season_recycler_view");
		public By eyeIcon=By.id("com.discovery.discoveryplus:id/text_input_password_toggle");
		public By popUpLogin=By.id("android:id/button1");
		
		public PageLocators(AppiumDriver<MobileElement> driver) {
			this.driver= driver;
		}
		
		public void checkSplashScreenIsDisplayed() {
			
			driver.findElement(Splash);
		}
		
		public void checkPremiumBadgeIsDisplayed() {
			
			driver.findElement(premium_badge).isDisplayed();

		 }
		
		public void tapOnSeasons() throws Throwable{
			
			String season=driver.findElement(By.id("com.discovery.discoveryplus:id/season_count_textview")).getText();
			char first=season.charAt(0);	 
			TouchAction ta = new TouchAction(driver);
			ta.press(PointOption.point(686, 683)).moveTo(PointOption.point(686, 645)).release().perform();
		    if(driver.findElements(By.xpath("//android.widget.Button")).size()!= 0) {
				
		    	driver.findElements(By.xpath("//android.widget.Button"));
		    	
		    } else {
		    	
		    	ta.press(PointOption.point(686, 683)).moveTo(PointOption.point(686, 645)).release().perform();
			}
		    
			if (first=='1') {
				
				
				driver.findElement(seasons).isDisplayed();
				driver.findElements(By.xpath("//android.widget.Button")).get(0).click();
				
			} else if (first=='2') {
				
				driver.findElement(seasons).isDisplayed();
				driver.findElements(By.xpath("//android.widget.Button")).get(0).click();
				Thread.sleep(1500);
				driver.findElements(By.xpath("//android.widget.Button")).get(1).click();

				
			} else if (first>'2') {
				
				driver.findElement(seasons).isDisplayed();
				Thread.sleep(1500);
				driver.findElements(By.xpath("//android.widget.Button")).get(0).click();
				Thread.sleep(1500);
				driver.findElements(By.xpath("//android.widget.Button")).get(1).click();
				Thread.sleep(1500);
				driver.findElements(By.xpath("//android.widget.Button")).get(2).click();
			
			}
		
		}
		
		public void swipe() throws Throwable {
			
			Thread.sleep(1500);
			TouchAction ta = new TouchAction(driver);
		    ta.press(PointOption.point(686, 683)).moveTo(PointOption.point(678, 660)).release().perform();
		}
		
		public void tapOnEpisodesTab() throws Throwable {
			
			 Thread.sleep(1500);
			 TouchAction ta = new TouchAction(driver);
	    	 ta.press(PointOption.point(686, 683)).moveTo(PointOption.point(686, 645)).release().perform();
	    	 
	    	 Thread.sleep(1500);
			 if (driver.findElement(episodes).isDisplayed()) {
				
				driver.findElement(episodes);
				
			} else {
				
		    	ta.press(PointOption.point(686, 683)).moveTo(PointOption.point(686, 645)).release().perform();
			}
		}
		
		public void swipeUp() throws Throwable {
			
			 Thread.sleep(1500);	
			 TouchAction ta = new TouchAction(driver);
		     ta.press(PointOption.point(518, 1478)).moveTo(PointOption.point(704, 729)).release().perform();
		
		}
			 
		public void swipeDown() throws Throwable {
			
			 Thread.sleep(1500);	
			 TouchAction ta = new TouchAction(driver);
			 ta.press(PointOption.point(664, 669)).moveTo(PointOption.point(606, 1102)).release().perform();
		}
		
		public void tapOnShortsTab() throws Throwable {
			
			 Thread.sleep(1500);
			 TouchAction ta = new TouchAction(driver);
	    	 ta.press(PointOption.point(686, 683)).moveTo(PointOption.point(686, 645)).release().perform();
	    	 
	    	 Thread.sleep(1500);
	    	 
			 if (driver.findElement(shorts).isDisplayed()) {
		    	
				driver.findElement(shorts).click();
				
			} else {
				
				swipe();
				driver.findElement(shorts).click();
			}
			
			
		}

		public void tapOnPlay() {
			
			driver.findElement(videoPlayButton).click();
			
		}
			
		public void tapOnPopUpLogin() {
			
			driver.findElement(popUpLogin).click();
		}
		
		public void enterEmailId() {
			
			driver.findElement(emailId).sendKeys("discoindiatest@discovery.com");
		}
		
		public void enterPassword() {
			
			driver.findElement(password).sendKeys("test");
		}
			
		public void tapOnShowPassword() {
			
			driver.findElement(eyeIcon).isDisplayed();
			driver.findElement(eyeIcon).click();
			
		}
		public void tapOnLogin() {
			
			driver.findElement(loginBtn).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(start).isDisplayed();
			
		}
		
		public void tapOnPlayerCordinate() {
			
			TouchAction ta = new TouchAction(driver);
			ta.press(PointOption.point(527, 298)).release().perform();
			
		}
				
		public void cordinates() {
			
			TouchAction ta = new TouchAction(driver);
			ta.press(PointOption.point(527, 298)).release().perform();
		}
		
		
		public void seekbar() {
			
			WebElement slider=driver.findElement(By.id("com.discovery.discoveryplus:id/mediacontroller_progress"));
			int start = slider.getLocation().getX();
			int end = slider.getSize().getWidth();
			int yAxis = slider.getLocation().getY();
			TouchAction act=new TouchAction(driver);
			int moveTo=(int)(end*1);
		    act.press(PointOption.point(start, yAxis)).moveTo(PointOption.point(moveTo, yAxis)).release().perform();
		}
		
		public void seekback() {
			
			WebElement slider=driver.findElement(By.id("com.discovery.discoveryplus:id/mediacontroller_progress"));
			int start = slider.getLocation().getX();
			int end = slider.getSize().getWidth();
			int yAxis = slider.getLocation().getY();
			TouchAction act=new TouchAction(driver);
		    act.press(PointOption.point(end, yAxis)).moveTo(PointOption.point(start, yAxis)).release().perform();
			
		}
		
		public void pauseVideo() throws Throwable {
			
			Thread.sleep(8000);
			tapOnPlayerCordinate();
			driver.findElement(By.id("com.discovery.discoveryplus:id/play_pause_button")).click();
			String initialTime=driver.findElement(By.id("com.discovery.discoveryplus:id/time_current")).getAttribute("text");
			Thread.sleep(5000);
			tapOnPlayerCordinate();
			String finalTime=driver.findElement(By.id("com.discovery.discoveryplus:id/time_current")).getAttribute("text");
			Assert.assertEquals(finalTime, initialTime,"Test failed Failed as Video is not paused");
			
		}
		
		public void forwardVideo() throws Throwable {
			
			Thread.sleep(8000);
			tapOnPlayerCordinate();
			String initialTime=driver.findElement(By.id("com.discovery.discoveryplus:id/time_current")).getAttribute("text");
			driver.findElement(By.id("com.discovery.discoveryplus:id/forward")).click();
			Thread.sleep(10000);
			tapOnPlayerCordinate();
			String finalTime=driver.findElement(By.id("com.discovery.discoveryplus:id/time_current")).getAttribute("text");
			Assert.assertNotEquals(finalTime, initialTime,"Test case Failed as Video is not Forwarded for 10 secs");
					
		}
		
		public void rewindVideo() throws InterruptedException {
			
			Thread.sleep(5000);
			tapOnPlayerCordinate();
			String initialTime=driver.findElement(By.id("com.discovery.discoveryplus:id/time_current")).getAttribute("text");
			driver.findElement(By.id("com.discovery.discoveryplus:id/rewind")).click();
			Thread.sleep(10000);
			tapOnPlayerCordinate();
			String finalTime=driver.findElement(By.id("com.discovery.discoveryplus:id/time_current")).getAttribute("text");
			Assert.assertNotEquals(finalTime, initialTime,"Test failed Failed as Video is not rewinded for 10 secs");
					
		}
		
		public void seekVideo() throws InterruptedException {
			
			Thread.sleep(8000);
			tapOnPlayerCordinate();
			String currenttime=driver.findElement(By.id("com.discovery.discoveryplus:id/time_current")).getAttribute("text");
		    seekbar();
		    Thread.sleep(8000);
		    tapOnPlayerCordinate();
			String afterseek=driver.findElement(By.id("com.discovery.discoveryplus:id/time_current")).getAttribute("text");
			Assert.assertNotEquals(currenttime, afterseek, "Test failed Failed as Duration is same even after seek" );
		}
	}



