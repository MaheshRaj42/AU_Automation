package AppUpdates_Scenario_Component;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import com.sun.glass.events.KeyEvent;

import AppUpdates_Generic_Component.Appupdates_Base_Class;
import AppUpdates_PageObject_Component.Page_object_AppUpdates;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;

public class Test_Class extends Appupdates_Base_Class{

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
	
		  Start_Server();

		  Init_App();
		  Page_object_AppUpdates AU_POB = new Page_object_AppUpdates(driver);
		  AU_POB.checkUpdates();
		  Explicit_Wait(AU_POB.App_UpdatesApp_Download_prompt, 25);
		  
		  for (int i=1; i<=10; i++)
		  {
			  if(AU_POB.App_UpdatesApp_Download_prompt.isDisplayed())
			  {
				  String AppUpdatesAppPrompt = AU_POB.getAppUpdatesAppdownloadprompt();
				  AU_POB.App_Download_OK_btn.click();
				  driver.sendKeyEvent(AndroidKeyCode.HOME);
				  System.out.println("TC_ID-AU_06 - AppUpdates app is downloaded :"+AppUpdatesAppPrompt);
				  
				  break;  
			  }
			  
			  else
			  {
				  System.out.println("App Updates app is not available for download");
				  
			  }
		  }
		
		   }
		  
		  
				  
			  }
			 
