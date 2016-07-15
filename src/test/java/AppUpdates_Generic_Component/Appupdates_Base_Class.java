package AppUpdates_Generic_Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;

public class Appupdates_Base_Class {
	
	public static Process process;
	public static AndroidDriver driver;
	
	static Appupdates_UtilityClass c1 = new Appupdates_UtilityClass();
	
	public static void Start_Server() throws IOException, InterruptedException
	{
		String start_server = "E:\\Appium\\workspace\\node.exe E:\\Appium\\workspace\\node_modules\\appium\\bin\\appium.js";
		process = Runtime.getRuntime().exec(start_server);
		Thread.sleep(10000);
		
		if(process!=null)
		{
			System.out.println("Appium Server is Started");
		}
		else
		{
			System.out.println("Server is not started");
		}
		
		Thread.sleep(12000);
		
	}

	public static void Init_App() throws IOException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", c1.Reading_Properties("Device_Name"));
		capabilities.setCapability("platformName", c1.Reading_Properties("Platform_Name"));
		capabilities.setCapability("platformVersion", c1.Reading_Properties("Platform_Version"));
		
		capabilities.setCapability("appPackage", c1.Reading_Properties("Package_Name"));
		capabilities.setCapability("appActivity", c1.Reading_Properties("Activity_Name"));
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	}
	
	public static void Explicit_Wait(WebElement ele, long T1)
	{
		WebDriverWait wait = new WebDriverWait(driver, T1);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void Snapshot_screen() throws IOException
	{
		Date date = new Date();
		SimpleDateFormat d_format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		File file = new File(d_format.format(date)+".png");
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File ScreenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ScreenshotAs, new File("C:\\workspace\\Eclipse\\Projects\\Sonim_Apps\\Screenshots\\"+file));
		
	}

	public static void Stop_Server() throws InterruptedException
	{
		if (process!=null)
		{
			process.destroy();
			Thread.sleep(10000);
			System.out.println("Appium Server is stopped");
		}
			
	}
	
	public static void rebootDevice() throws IOException, InterruptedException 
	{
		String command = "adb reboot";
	    Process process2 = Runtime.getRuntime().exec(command);
	    process2.waitFor();
	}
	
	public static void DPADdownKeys() throws IOException, InterruptedException 
	{
		String command = "adb shell input keyevent KEYCODE_DPAD_DOWN";
	    Process process3 = Runtime.getRuntime().exec(command);
	    process3.waitFor();
	}
	
}
