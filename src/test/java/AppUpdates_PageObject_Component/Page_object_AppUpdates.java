package AppUpdates_PageObject_Component;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class Page_object_AppUpdates {
	
	public AndroidDriver driver;
	
	public Page_object_AppUpdates(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
			
	}
	
	@FindBy(id="com.sonimtech.sonimupdater:id/btn_check_updates")
    public WebElement check_updates_btn;
	
	@FindBy(xpath="//*[contains(@text, 'OK')]")
	public WebElement App_DownloadPopup;
	
	@FindBy(xpath="//*[contains(@text, 'OK')]")
	public WebElement App_Download_OK_btn;
	
	@FindBy(xpath="//*[starts-with(@text, 'Downloading updates')]")
	public WebElement DownloadingUpdates_Status;
	
	@FindBy(xpath="//*[contains(@text, 'Settings')]")
	public WebElement settings_option;
	
	@FindBy(xpath="//*[contains(@text, 'Check for updates on device start up')]")
	public WebElement Settings_Window_options_onDeviceStartup;
	
	@FindBy(xpath="//*[contains(@text, 'Check for updates over Mobile Data')]")
	public WebElement Settings_Window_options_overMobileData;
	
	@FindBy(xpath="//*[contains(@text, 'Preferred network for downloads')]")
	public WebElement Settings_Window_preferredNetwork;
	
	@FindBy(xpath="//*[contains(@text, 'Wi-Fi and Mobile Data')]")
	public WebElement Settings_Window_preferredNetwork_WiFinMobileData;
	
	@FindBy(xpath="//*[contains(@text, 'Wi-Fi only')]")
	public WebElement Settings_Window_preferredNetwork_WiFiOnly;
	
	@FindBy(xpath="//*[contains(@text, 'About')]")
	public WebElement About_option;
	
	
	@FindBy(xpath="//*[contains(@text, 'Version')]")
	public WebElement About_Window;
	
	@FindBy(xpath="//*[contains(@text, 'OK')]")
	public WebElement About_Window_OK_btn;
	
	@FindBy(id="android:id/message")
	public WebElement prompt_msg;
	
	@FindBy(xpath="//*[contains(@text, 'Applications')]")
	public WebElement Applications_Folder;
	
	@FindBy(xpath="//*[contains(@text, 'App Updates')]")
	public WebElement AppUpdatesStandAloneClient;
	
	@FindBy(id="android:id/alertTitle")
	public WebElement updateAlert;
	
	@FindBy(xpath="//*[starts-with(@text, 'Please update App Updates,')]")
	public WebElement App_UpdatesApp_Download_prompt;
	
	@FindBy(xpath="//*[contains(@text, 'Settings')]")
	public WebElement Settings_App;
	
	@FindBy(xpath="//*[contains(@text, 'Date & time')]")
	public WebElement DateNTime_option;
	
	@FindBy(xpath="//*[contains(@text, 'Automatic date & time')]")
	public WebElement AutomaticDatnTime_option;
	
	@FindBy(xpath="//*[contains(@text, 'Automatic time zone')]")
	public WebElement AutomaticTimeZone_option;
	
	@FindBy(xpath="//*[contains(@text, 'Set date')]")
	public WebElement SetDate_option;
	
	@FindBy(xpath="//*[@class='android.widget.EditText'][@resource-id='android:id/numberpicker_input'][@bounds='[92,153][156,201]']")
	public WebElement Number_Picker;
	
	@FindBy(xpath="//*[contains(@text, 'Done')]")
	public WebElement done_btn;
	
	@FindBy(xpath="//*[contains(@text, 'Cancel')]")
	public WebElement Cancel_btn;
	
	//Please update App Updates, App should have been updated by 15/06/2016 11:59:59 PM.
	
	
	public void checkUpdates()
	{
		check_updates_btn.click();
	}
	
	public String getappDownloadPopUpMsg()
	{
		return App_DownloadPopup.getText();
	}
	
	public void AppDownload_Ok_Btn_press()
	{
		App_Download_OK_btn.click();
	}
	
	public void openSettings()
	{
		settings_option.click();
	}
	

	public void CheckUpdatesonDeviceStartUp()
	{
		Settings_Window_options_onDeviceStartup.click();
	}
	
	public void CheckUpdatesOverMobileData()
	{
		Settings_Window_options_overMobileData.click();
	}
	
	public void selectPreferNetwork()
	{
		Settings_Window_preferredNetwork.click();
	}
	
	public void preferWiFinMobileData()
	{
		Settings_Window_preferredNetwork_WiFinMobileData.click();
	}
	
	public void preferWiFionly()
	{
		Settings_Window_preferredNetwork_WiFiOnly.click();
	}
	
	public void openAbout()
	{
		About_option.click();
	}
	
	public String getAboutwindowText()
	{
		return About_Window.getText();
	}
	
	public void AboutPressOKbtn()
	{
		About_Window_OK_btn.click();
	}
	
	public String getPromptMsg()
	{
		return prompt_msg.getText();
		
	}
	
	public void openApplicationsfolder()
	{
		Applications_Folder.click();
	}
	
	public void LaunchAppUpdatesstandAloneClient()
	{
		AppUpdatesStandAloneClient.click();
	}
	
	public String getAlertmsg()
	{
		return updateAlert.getText();
	}
	
	public String getAppUpdatesAppdownloadprompt()
	{
		return App_UpdatesApp_Download_prompt.getText();
	}
	
	public void click_Settings()
	{
		Settings_App.click();
	}
	
	public void clickonDatenTime()
	{
		DateNTime_option.click();
	}
	
	public void clickSetDate()
	{
		SetDate_option.click();
	}
	
	
	public void clickondonebtn()
	{
		done_btn.click();
	}
	
	public void ClickcancelBtn()
	{
		Cancel_btn.click();
	}
	
}
