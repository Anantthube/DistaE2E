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


WebUI.openBrowser('')

WebUI.navigateToUrl(findTestData('null').getValue(1, 1))

WebUI.maximizeWindow()

WebUI.setText(findTestObject('LoginObjectsRepo/Page_Login/input_Log In_userid'), findTestData('null').getValue(
        2, 1))

WebUI.setText(findTestObject('LoginObjectsRepo/Page_Login/input_Log In_hide-password'), findTestData('null').getValue(
        3, 1))

WebUI.click(findTestObject('LoginObjectsRepo/Page_Login/button_Log In'))

//WebElement toastMessage = WebUI.acceptAlert('Object Repository/LoginObjects/Page_Login/Toast message');


//if(WebUI.(findTestObject('LoginObjectsRepo/Page_Login/Toast message')

//element = WebUI.getAttribute(findTestObject('LoginObjectsRepo/Page_Login/Toast message'), "test")

WebUI.waitForElementVisible(findTestObject('ForWaitUtility/ToWaitFor'), 30)
