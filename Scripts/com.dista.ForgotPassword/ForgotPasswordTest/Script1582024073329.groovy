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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.openBrowser('')

String webURL = findTestData('TestData/LoginData').getValue("URL", 1)
WebUI.navigateToUrl(webURL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/ForgotPasswordRepo/button_Forgot Password'))

WebUI.setText(findTestObject('Object Repository/ForgotPasswordRepo/input_Log In_userid'),findTestData('TestData/LoginData').getValue(2, 1))

WebUI.click(findTestObject('Object Repository/ForgotPasswordRepo/button_Send Email'))

//WebUI.click(findTestObject('Object Repository/ForgotPasswordRepo/div_An email with the new password was sent_8956f0'))

WebUI.setText(findTestObject('Object Repository/ForgotPasswordRepo/input_Log In_userid'),findTestData('TestData/LoginData').getValue(2, 1))

Thread.sleep(40000)
  //Code to read mail 

WebUI.setText(findTestObject('Object Repository/ForgotPasswordRepo/input_Log In_hide-password'),findTestData('TestData/ForgotPasswordData').getValue(3, 1))

WebUI.click(findTestObject('Object Repository/ForgotPasswordRepo/button_Log In'))

WebUI.setText(findTestObject('Object Repository/ForgotPasswordRepo/input_Log In_hide-password'),findTestData('TestData/LoginData').getValue(3, 1))

//WebUI.setText(findTestObject('Object Repository/ForgotPasswordRepo/input_Log In_userid'), 'anant.thube@mediaagility.com')

//WebUI.setEncryptedText(findTestObject('Object Repository/ForgotPasswordRepo/input_Log In_hide-password'), 'TYTko8KE49gfcXj+6IcXYw==')

//WebUI.click(findTestObject('Object Repository/ForgotPasswordRepo/button_Log In'))

WebUI.setText(findTestObject('Object Repository/ForgotPasswordRepo/input_Reset Password_confirm-password'),findTestData('TestData/LoginData').getValue(3, 1))

WebUI.click(findTestObject('Object Repository/ForgotPasswordRepo/button_Reset Password'))

if(WebUI.verifyElementVisible(findTestObject('Object Repository/ForgotPasswordRepo/div_Password has been reset successfully'))){

WebUI.setText(findTestObject('Object Repository/ForgotPasswordRepo/input_Log In_userid'),findTestData('TestData/LoginData').getValue(2, 1))

WebUI.setText(findTestObject('Object Repository/ForgotPasswordRepo/input_Log In_hide-password'),findTestData('TestData/LoginData').getValue(3, 1))

WebUI.click(findTestObject('Object Repository/ForgotPasswordRepo/button_Log In'))
}
else
{
	println("try again")
}