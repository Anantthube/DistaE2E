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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType

CustomKeywords.'loginKeyword.AppLogin.getLogin'()

CustomKeywords.'levelKeyword.LevelSelectToCreateJob.selecLevel'()

String JobCode = findTestData('TestData/DistaCreateJobData').getValue("jobCode", 1)

String xpath = ('//td[contains(text(),"' + JobCode) + '")]//following::button[1]'
TestObject to = new TestObject('objectName')
to.addProperty('xpath', ConditionType.EQUALS, xpath)
WebUI.click(to)

if (WebUI.verifyElementVisible(findTestObject('JobStateVerifyRepo/AssignOption'),FailureHandling.CONTINUE_ON_FAILURE)) {
	
	//WebUI.setText(to, JobCode)
	//WebUI.setText(findTestObject('JobStateVerifyRepo/SearchJobField'), JobCode)

    WebUI.click(findTestObject('JobStateVerifyRepo/AssignOption'))
    WebUI.click(findTestObject('JobStateVerifyRepo/SearchAssetField'))
    WebUI.click(findTestObject('JobStateVerifyRepo/SelectAvailableAsset')) 
	//String dynamicXpath = GlobalVariable.assetNumber
	String AssetNum = '//span[contains(text(),"'+GlobalVariable.assetNumber+'")]'   
	TestObject assetNum = new TestObject('objectName')
	assetNum.addProperty('xpath', ConditionType.EQUALS, AssetNum)
	WebUI.scrollToElement(assetNum, 0)
	WebUI.click(assetNum)
	//To click OK button when asset is selected in the dropdown
	WebUI.click(findTestObject('JobStateVerifyRepo/JobAssignPopUp_button_OK'))
	
	Thread.sleep(8000L)
            
} else {
    println('Check with some other job')

	// to confirm what to do in this scenario
}
    
