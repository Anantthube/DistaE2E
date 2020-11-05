package loginKeyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class AppLogin {
	@Keyword
	public void getLogin(){

		WebUI.openBrowser('')

		String webURL = findTestData('TestData/LoginData').getValue("URL", 1)
		WebUI.navigateToUrl(webURL)

		WebUI.maximizeWindow()

		String userName = findTestData('TestData/LoginData').getValue("Username", 1)
		WebUI.setText(findTestObject('LoginObjectsRepo/Page_Login/input_Log In_userid'),userName)

		String password = findTestData('TestData/LoginData').getValue("Password", 1)
		WebUI.setText(findTestObject('LoginObjectsRepo/Page_Login/input_Log In_hide-password'),password)


		WebUI.click(findTestObject('LoginObjectsRepo/Page_Login/button_Log In'))
		WebUI.waitForElementVisible(findTestObject('ForWaitUtility/ToWaitFor'), 30)
	}
}
