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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.Keys as Keys

CustomKeywords.'loginKeyword.AppLogin.getLogin'()

String selectClient = '//input[@placeholder=\'Select client\']'
TestObject client = new TestObject('objectName')
client.addProperty('xpath', ConditionType.EQUALS, selectClient)

String chooseClient = '//span[contains(text(),\'Dista Test\')]'
TestObject clientSelect = new TestObject('objectName')
clientSelect.addProperty('xpath', ConditionType.EQUALS, chooseClient)

WebUI.click(client)
WebUI.click(clientSelect)

WebUI.click(findTestObject('Dista-ai-dev/OK_button'))
WebUI.click(findTestObject('Dista-ai-dev/India_level'))
WebUI.click(findTestObject('Dista-ai-dev/Apply'))

WebUI.mouseOver(findTestObject('CreateJobDevRepo/Page_Admin Utilities/span_Create Job'))

WebUI.click(findTestObject('Dista-ai-Dev/BulkUploadRepo/select_Bulkupload'))

Thread.sleep(3000)

String bulkupload = '//div[@class=\'app-title text-uppercase ng-binding\']'
TestObject scrollToBU = new TestObject('objectName')
scrollToBU.addProperty('xpath', ConditionType.EQUALS, bulkupload)

String module = findTestData('AllTestData/BulkUploadSelection').getObjectValue('Select Module', 1)
String entity = findTestData('AllTestData/BulkUploadSelection').getObjectValue('Select Entity', 1)
String template = findTestData('AllTestData/BulkUploadSelection').getObjectValue('Select Template', 1)
String event = findTestData('AllTestData/BulkUploadSelection').getObjectValue('Select Event', 1)

WebUI.mouseOver(scrollToBU)

Thread.sleep(3000)

WebUI.selectOptionByLabel(findTestObject('NewDev/select_Select TemplateBuscar trabajoSearch _4ed098'),module, 
    false)

Thread.sleep(5000)

WebUI.selectOptionByLabel(findTestObject('Dista-ai-Dev/BulkUploadRepo/select_template'),template, false)

WebUI.selectOptionByLabel(findTestObject('Dista-ai-Dev/BulkUploadRepo/select_event'),event, false)

//WebUI.click(findTestObject('Dista-ai-Dev/BulkUploadRepo/select_uploadFileButton'))

WebUI.uploadFile(findTestObject('Dista-ai-Dev/BulkUploadRepo/select_uploadFileButton'), 'C:\\Users\\Anant\\Desktop\\DistaAutomationData\\BulkUpload19-03.csv')

Thread.sleep(2000)

WebUI.click(findTestObject('Dista-ai-Dev/BulkUploadRepo/UploadButton'))

