import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'mobileAppLoginKeyword.AppLogin.makeAppLogin'()

Mobile.tap(findTestObject('AssetLoginLogout/android.widget.ImageButton0'), 0)

Mobile.tap(findTestObject('AssetLoginLogout/android.widget.TextView0 - PERFIL'), 0)

String assetName = findTestData('TestData/AssetDetails').getValue('Name', 1)
String appAssetname = Mobile.getText(findTestObject('AssetDetailsRepo/android.widget.TextView0 - Test'), 0)

boolean isNameMatches = Mobile.verifyMatch(appAssetname, assetName, false)
if(isNameMatches){
	println(assetName+" Asset name verified")
}

String assetNumber = findTestData('TestData/AssetDetails').getValue('Number', 1)
String appAssetNumber = Mobile.getText(findTestObject('AssetDetailsRepo/android.widget.TextView0 - 5500'), 0)

boolean isNumMatches = Mobile.verifyMatch(appAssetNumber, assetNumber, false)
if(isNumMatches){
	println(assetNumber+" Asset number verified")
}

String assetAddress = findTestData('TestData/AssetDetails').getValue('Address', 1)
String appAssetAddress = Mobile.getText(findTestObject('AssetDetailsRepo/android.widget.TextView0 - Pimpri'), 0)
boolean isAddressMatches = Mobile.verifyMatch(assetAddress, appAssetAddress, false)
if(isAddressMatches){
	println(assetAddress+" Asset address verified")
}

String assetMobile = findTestData('TestData/AssetDetails').getValue('Mobile', 1)
String appAssetMobile = Mobile.getText(findTestObject('AssetDetailsRepo/android.widget.TextView0 - 8888848641'), 0)
boolean isMobileMatches = Mobile.verifyMatch(assetMobile, appAssetMobile, false)
if(isMobileMatches){
	println(assetMobile+" Asset Mobile number verified")
}