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

WebUI.callTestCase(findTestCase('com.dista.Login.test/LoginTest'), [('URL') : '', ('Username') : '', ('Password') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBulkjobUpload/Page_Admin Utilities/div_Bulk Upload'))

WebUI.click(findTestObject('Object Repository/NewBulkjobUpload/Page_Bulk Upload/span_Collapse all_fancytree-checkbox fa fa-_bd3b53'))

WebUI.click(findTestObject('Object Repository/NewBulkjobUpload/Page_Bulk Upload/button_Apply'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBulkjobUpload/Page_Bulk Upload/select_Select moduleStore  trade zoneUser M_3360b0'), 
    Select Module, true)

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBulkjobUpload/Page_Bulk Upload/select_Select TemplateBuscar trabajoalerts _9c7b4e'), 
    'Select Template', true)

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBulkjobUpload/Page_Bulk Upload/select_Select EventBULK JOB UPLOAD EVENTBUL_854aa5'), 
    'Select Event', true)

