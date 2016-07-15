package AppUpdates_Scenario_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import AppUpdates_Generic_Component.Appupdates_Base_Class;
import AppUpdates_PageObject_Component.Page_object_AppUpdates;
import io.appium.java_client.android.AndroidKeyCode;

@Test
public class Scenario_AppUpdates extends Appupdates_Base_Class {
	
	static Logger log = Logger.getLogger(Scenario_AppUpdates.class);
	SoftAssert sAssert = new SoftAssert();
	
	public void testAppUpdates1() throws IOException, InterruptedException {
		
		log.info("Executing the Test Cases");
		
		Start_Server();
		Init_App();
		
		Page_object_AppUpdates AU_POB = new Page_object_AppUpdates(driver);
		
		//TC_ID-AU_01 - R-3.1.1
		AU_POB.checkUpdates();
		Thread.sleep(5000);
		
		if (AU_POB.App_DownloadPopup.isDisplayed())
		{
		AU_POB.AppDownload_Ok_Btn_press();
		System.out.println("TC_ID-AU_01 - Able to connect to server and check for updates");
		Thread.sleep(10000);
		}

		else
		{
			System.out.println("There are no apps to download");
		}
		driver.sendKeyEvent(AndroidKeyCode.HOME);
		Stop_Server();
		
	}
		
		
	public void testAppUpdates2() throws InterruptedException, IOException {
		
	//TC_ID-AU_02 - R-3.1.2
		Start_Server();
		Init_App();
		Page_object_AppUpdates AU_POB = new Page_object_AppUpdates(driver);
		
		driver.sendKeyEvent(AndroidKeyCode.MENU);
		Explicit_Wait(AU_POB.About_option, 25);
		AU_POB.openAbout();
		String aboutwindowText = AU_POB.getAboutwindowText();
		System.out.println("TC_ID-AU_02 - Result of Check for About info "+aboutwindowText);
	    AU_POB.About_Window_OK_btn.click();
	    driver.sendKeyEvent(AndroidKeyCode.HOME);
	    Stop_Server();
	    
	}
		
	
	public void testAppUpdates3() throws InterruptedException, IOException {
		//TC_ID-AU_03 - R-3.1.2
	    Start_Server();
	    Init_App();
	    Page_object_AppUpdates AU_POB = new Page_object_AppUpdates(driver);
	    
	    driver.sendKeyEvent(AndroidKeyCode.MENU);
		Explicit_Wait(AU_POB.settings_option, 25);
		AU_POB.openSettings();
		boolean onDeviceStartUP = AU_POB.Settings_Window_options_onDeviceStartup.isDisplayed();
		boolean overMobileData = AU_POB.Settings_Window_options_overMobileData.isDisplayed();
		boolean preferred_Nw = AU_POB.Settings_Window_preferredNetwork.isDisplayed();
		
		if (AU_POB.Settings_Window_preferredNetwork.isDisplayed())
		{
			AU_POB.Settings_Window_preferredNetwork.click();
			
			boolean preferred_Nw1 = AU_POB.Settings_Window_preferredNetwork_WiFinMobileData.isDisplayed();
			boolean preferred_Nw2 = AU_POB.Settings_Window_preferredNetwork_WiFiOnly.isDisplayed();
			if ((preferred_Nw1==true) && (preferred_Nw2==true) )
			{
				System.out.println("preferred_Nw have 2 options: WiFinMobileData: "+AU_POB.Settings_Window_preferredNetwork_WiFinMobileData.getText()+ "WiFi Only: "+AU_POB.Settings_Window_preferredNetwork_WiFiOnly.getText());
			}
		}
		
		String pref_nw = ("preferred_Nw have 2 options: WiFinMobileData: "+AU_POB.Settings_Window_preferredNetwork_WiFinMobileData.getText()+ "WiFi Only: "+AU_POB.Settings_Window_preferredNetwork_WiFiOnly.getText());
		String Settings_output = "onDevicestartupvalue:"+onDeviceStartUP + " OverMobileData:"+overMobileData + " Preferred_Nw:"+pref_nw;
		
		if(((onDeviceStartUP == true) && (overMobileData == true) && (preferred_Nw == true)))
		{
			System.out.println("TC_ID-AU_03 - Result of Check for settings options:"+Settings_output);
			log.info("Passed as Expected options are Displayed");
		}
		else
		{
			System.out.println("TC_ID-AU_03 - Result of Check for settings options: Failed ");
		}
		driver.sendKeyEvent(AndroidKeyCode.HOME);
		Stop_Server();
		
	}

	
	public void testAppUpdates4() throws IOException, InterruptedException {
	
	      //TC_ID-AU_04 - R-3.1.4
		Start_Server();
		Init_App();
		
		Page_object_AppUpdates AU_POB = new Page_object_AppUpdates(driver);
	  AU_POB.checkUpdates();
	  if(AU_POB.prompt_msg.isDisplayed())
	  {
		  String promptMsg = AU_POB.getPromptMsg();
		  System.out.println("TC_ID-AU_04 - Result of Check for propmt message is :"+promptMsg);
		  log.info("Passed as Propmt message is displayed"+promptMsg);
	  }
	  else
	  {
		  System.out.println("TC_ID-AU_04 - Result of Check for propmt message is: Failed ");
	  }
	  Stop_Server();
	  
	}
	  
	public void testAppUpdates5() throws InterruptedException, IOException {
		  
	     //TC_ID-AU_05 - R-3.2.1
	  Start_Server();
	  Page_object_AppUpdates AU_POB = new Page_object_AppUpdates(driver);
	  
	  driver.sendKeyEvent(AndroidKeyCode.HOME);
	  Explicit_Wait(AU_POB.Applications_Folder, 25);
	  AU_POB.openApplicationsfolder();
	  
	  if(AU_POB.AppUpdatesStandAloneClient.isDisplayed())
	  {
		  AU_POB.LaunchAppUpdatesstandAloneClient();
		  System.out.println("TC_ID-AU_05 - App Updates Stand Alone client is available");
		  log.info("Passed as App Updates app is displayed"+AU_POB.AppUpdatesStandAloneClient.getText());
	  }
	  else
	  {
		  System.out.println("TC_ID-AU_05 - App Updates Stand Alone client is not displayed");
	  }
	  driver.sendKeyEvent(AndroidKeyCode.HOME);
	  Stop_Server();
	  
	  }
	  
	
	public void testAppUpdates6() throws InterruptedException, IOException {
	      //TC_ID-AU_06 - R-3.2.2
	      Start_Server();
	      Init_App();
	      
	      Page_object_AppUpdates AU_POB = new Page_object_AppUpdates(driver);
	      
	      driver.sendKeyEvent(AndroidKeyCode.MENU);
		  Explicit_Wait(AU_POB.settings_option, 25);
		  AU_POB.openSettings();
		  
		  if(AU_POB.Settings_Window_options_onDeviceStartup.isDisplayed())
		  {
			 boolean onDeviceStartUp_selection = AU_POB.Settings_Window_options_onDeviceStartup.isSelected();
			 if(onDeviceStartUp_selection == false) 	 
			 {
			 AU_POB.Settings_Window_options_onDeviceStartup.click();
			 rebootDevice();
			 }
			 else if(onDeviceStartUp_selection == true)
			 {
				 rebootDevice();
			 }
			 Explicit_Wait(AU_POB.updateAlert, 200);
			  String Update_alertmsg_After_Reboot = AU_POB.getAlertmsg();
			  System.out.println("TC_ID-AU_06 - Apps are downloaded after reboot"+Update_alertmsg_After_Reboot);
			  log.info("Passed as apps are downloaded after reboot"+Update_alertmsg_After_Reboot);
			
		  }
		  else
			 {
				 System.out.println("TC_ID-AU_06 - Apps are not downloaded after reboot");
			 }
		  driver.sendKeyEvent(AndroidKeyCode.HOME);
		  Stop_Server();
		  
	}
	
	public void testAppUpdates7() throws InterruptedException, IOException {
		      //TC_ID-AU_07 - R-3.2.3
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
				  log.info("Passed as App Updates app is capable of self update :"+AppUpdatesAppPrompt);
				  break;  
			  }
			  
			  else
			  {
				  System.out.println("App Updates app is not available for download");
				  
			  }
		  }
		  driver.sendKeyEvent(AndroidKeyCode.HOME);
		  Stop_Server();
		
	}
	
	
	public void testAppUpdates8() throws InterruptedException, IOException {
		  
		//TC_ID-AU_08 - R-3.2.5
		  Start_Server();
		  Init_App();
		  
		  Page_object_AppUpdates AU_POB = new Page_object_AppUpdates(driver);
		  
		  AU_POB.checkUpdates();
		  Explicit_Wait(AU_POB.Cancel_btn, 50);
		  if(AU_POB.Cancel_btn.isDisplayed())
		  {
			  AU_POB.ClickcancelBtn();
			  driver.sendKeyEvent(AndroidKeyCode.HOME);
			  Explicit_Wait(AU_POB.Settings_App, 50);
			  AU_POB.Settings_App.click();
			  Thread.sleep(5000);
			  
			  for (int i=1; i<=20; i++)
			  {	  
					  DPADdownKeys();
			  }	 
			
		   AU_POB.DateNTime_option.click();
		   AU_POB.SetDate_option.click();
		   Thread.sleep(4000);
		   AU_POB.Number_Picker.click();
		   for (int i=1; i<=8; i++)
			  {	  
					  DPADdownKeys();
			  }	 
		   AU_POB.clickondonebtn();
		   Explicit_Wait(AU_POB.Cancel_btn, 100);
		   if(AU_POB.Cancel_btn.isDisplayed())
		   {
			   AU_POB.ClickcancelBtn();
			   System.out.println("TC_ID-AU_08 - CIC is successfully done");
		   }
		   else
		   {
			   System.out.println("TC_ID-AU_08 - CIC is not performed");
		   }
		   Stop_Server();	  
		  
		  }
	  
			sAssert.assertAll();
		
			}


	
}

			