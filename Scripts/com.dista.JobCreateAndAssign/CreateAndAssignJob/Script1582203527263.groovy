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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.Keys as Keys

//for(def row=1;row<=findTestData('CreateJobTestData').getAllData()	; row++){
CustomKeywords.'loginKeyword.AppLogin.getLogin'()

Thread.sleep(3000)

WebUI.mouseOver(findTestObject('CreateJobDevRepo/Page_Admin Utilities/span_Create Job'))

WebUI.mouseOver(findTestObject('CreateJobDevRepo/Page_Admin Utilities/select Create job from sideBar'))

//WebUI.mouseOver(findTestObject('CreateJobDevRepo/Page_Admin Utilities/navBar'))
WebUI.click(findTestObject('CreateJobDevRepo/Page_Admin Utilities/span_Select_Create Job'))

Thread.sleep(3000)

/*WebUI.selectOptionByIndex(findTestObject('Object Repository/NewDev/select_Select TemplateBuscar trabajoSearch _4ed098'), 
    '4', FailureHandling.CONTINUE_ON_FAILURE)*/
WebUI.selectOptionByLabel(findTestObject('NewDev/select_Select TemplateBuscar trabajoSearch _4ed098'), 'Alta de trabajo - Operaciones V2', 
    false)

/*WebUI.selectOptionByIndex(findTestObject('NewDev/select_Select TemplateBuscar trabajoSearch _4ed098'), 4)*/
CustomKeywords.'createJob.JobCreate.createJobEntity'()

CustomKeywords.'jobassign.AssignJob.assignJob'()



