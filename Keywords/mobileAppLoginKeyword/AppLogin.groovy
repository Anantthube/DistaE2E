package mobileAppLoginKeyword

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
	public void makeAppLogin(){

		Mobile.startApplication('C:\\Users\\Anant\\Desktop\\Dista_Dish_dev.apk',true) // QA Apk

		/*Mobile.startApplication('C:\\Users\\Anant\\Desktop\\DistaAutomationData\\APKs\\Dev\\Dista__DISH__Operation_v13__dista-dish-dev.appspot.com.apk',true)*/         // Dev Apk

		//Mobile.startApplication('kobiton-store:50507', true)            // to run on Kobiton cloud on specified device

		Thread.sleep(5000)
		//println (findTestData('TestData/DistaAppLogin').getValue(1, 1))

		String assetID = findTestData('TestData/DistaAppLogin').getValue("AssetID", 1)
		Mobile.sendKeys(findTestObject('NewAssetLoginElements/android.widget.EditText0'),assetID)

		Mobile.tap(findTestObject('NewAssetLoginElements/android.widget.Button0 - SIGUIENTE'), 0)

		String assetPassword = findTestData('TestData/DistaAppLogin').getValue("AssetPassword", 1)
		Mobile.sendKeys(findTestObject('NewAssetLoginElements/android.widget.EditText0 (1)'),assetPassword)

		Mobile.tap(findTestObject('NewAssetLoginElements/android.widget.Button0 - ENTRAR'), 0)

		if(Mobile.verifyElementVisible(findTestObject('NewAssetLoginElements/android.widget.Button0 - ALLOW'),0,FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('NewAssetLoginElements/android.widget.Button0 - ALLOW'), 0)
		}
		else{
			println("Element is not visible")
		}

		if(Mobile.verifyElementVisible(findTestObject('NewAssetLoginElements/Enterar/android.widget.Button0 - ENTRAR'),0,FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('NewAssetLoginElements/Enterar/android.widget.Button0 - ENTRAR'), 0)
		}
		else{
			println("Element is not visible")
		}

		Thread.sleep(3000)

		if (Mobile.verifyElementVisible(findTestObject('NewMobileRepo/android.widget.Button0 - OK'),0,FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('MobileLoginRepo/android.widget.Button0 - OK'), 0)
		}
		else{
			println("Element is not visible")
		}
		if(Mobile.verifyElementVisible(findTestObject('MobileLoginRepo/android.widget.ImageView0'), 0,FailureHandling.OPTIONAL)){
			Mobile.tap(findTestObject('MobileLoginRepo/android.widget.ImageView0'), 0)
		}
		else{
			println("Navigated to Dashboard")
		}
	}
}
