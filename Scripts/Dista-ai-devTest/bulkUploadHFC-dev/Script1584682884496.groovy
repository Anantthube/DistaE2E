import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.Keys as Keys
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

CustomKeywords.'loginKeyword.AppLogin.getLogin'()

String hamMenu = "//a[@class='navbar-btn sidebar-toggle cursor-pointer']"
TestObject menu = new TestObject('objectName')
menu.addProperty('xpath', ConditionType.EQUALS, hamMenu)

Thread.sleep(3000)

WebUI.click(findTestObject('Dista-ai-dev/India_level'))
WebUI.click(findTestObject('Dista-ai-dev/Apply'))

WebUI.click(menu)

WebUI.click(findTestObject('Dista-ai-Dev/BulkUploadRepo/select_Bulkupload'))

Thread.sleep(3000)

WebUI.uploadFile(findTestObject('Dista-ai-Dev/BulkUploadRepo/select_uploadFileButton'), 
	'C:\\Users\\Anant\\Desktop\\DistaAutomationData\\hfs-dev-bulkupload-test.csv')

Thread.sleep(2000)

WebUI.click(findTestObject('Dista-ai-Dev/BulkUploadRepo/UploadButton'))

//WebUI.doubleClick(findTestObject('Dista-ai-Dev/BulkUploadRepo/UploadButton'))

Thread.sleep(8000)
	






