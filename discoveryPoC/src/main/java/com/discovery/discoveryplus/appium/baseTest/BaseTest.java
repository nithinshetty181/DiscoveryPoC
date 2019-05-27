/*
 * Copyright © 2019, Discovery Networks International
 * Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package com.discovery.discoveryplus.appium.baseTest;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class BaseTest {
	
	
	public static AppiumDriver<MobileElement> driver;
	
	public void setup() throws MalformedURLException{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName","Android");
		caps.setCapability("deviceName","ce12171cc9d3790b05");
		caps.setCapability("appPackage","com.discovery.discoveryplus");
		caps.setCapability("appActivity","com.discovery.discoveryplus.LauncherActivity");
		driver=new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
					
	}
	
}

