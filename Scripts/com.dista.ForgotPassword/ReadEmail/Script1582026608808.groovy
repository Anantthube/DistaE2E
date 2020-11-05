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

/*String emailMsg = CustomKeywords.'com.testwithhari.katalon.plugins.Gmail.readLatestEMailBodyContent'(findTestData('TestData/ForgotPasswordData').getValue(
        1, 1), findTestData('TestData/ForgotPasswordData').getValue(2, 1), 'Dista')*/    

String emailMsg = CustomKeywords.'com.testwithhari.katalon.plugins.Gmail.readLatestEMailBodyContent'(findTestData('TestData/ForgotPasswordData')
.getValue("Email", 1), findTestData('TestData/ForgotPasswordData').getValue("Password", 1),'Dista')

String actualCode = (emailMsg.split('is *')[1]).substring(1, 9).trim()

println(actualCode)


