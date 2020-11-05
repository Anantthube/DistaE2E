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

CustomKeywords.'loginKeyword.AppLogin.getLogin'()

CustomKeywords.'sideBarSelectionforJobDashboard.SelectJobDashboard.selectJobDashboardLevel'()

CustomKeywords.'levelKeyword.LevelSelect.selecLevel'()
Thread.sleep(3000)

String jobSearchElement = "//th[contains(text(),'Order')]//following::input[@st-search='jobCode']"
TestObject jobSearchField = new TestObject('objectName')
jobSearchField.addProperty('xpath', ConditionType.EQUALS, jobSearchElement)

String jobCode = findTestData('TestData/DistaCreateJobData').getValue("jobCode", 1)
String jobStatus = "//th[contains(text(),'Status')]//following::span[1]"
TestObject getJobStatus = new TestObject('objectName')
getJobStatus.addProperty('xpath', ConditionType.EQUALS, jobStatus)

WebUI.setText(jobSearchField, jobCode)
String currentJobStatus = WebUI.getText(getJobStatus)
println("job status is "+currentJobStatus)
String actualStatusOfJob = findTestData('TestData/WebJobStatusChange').getValue("JobState", 1)
if(currentJobStatus.equalsIgnoreCase(actualStatusOfJob)){
	String actions = '//td[contains(text(),"'+jobCode+'")]//following::button[1]'
	TestObject actionsButton = new TestObject('objectName')
	actionsButton.addProperty('xpath', ConditionType.EQUALS, actions)
	WebUI.click(actionsButton)

	String getJobStartValue = findTestData('TestData/WebJobStatusChange').getValue("Start", 1)
	String jobStartElem = '//span[contains(text(),"'+getJobStartValue+'")]'
	TestObject jobStart = new TestObject('objectName')
	jobStart.addProperty('xpath', ConditionType.EQUALS, jobStartElem)
	WebUI.scrollToElement(jobStart, 0)
	WebUI.click(jobStart)
	
	String okButton = "//button[@ng-click='modal.confirm()']"
	TestObject clickOK = new TestObject('objectName')
	clickOK.addProperty('xpath', ConditionType.EQUALS, okButton)
	WebUI.click(clickOK)
	
	Thread.sleep(3000)	
	
	WebUI.click(actionsButton)
	String arriving = findTestData('TestData/WebJobStatusChange').getValue("Arriving", 1)
	String arrivingJOb = '//span[contains(text(),"'+arriving+'")]'
	TestObject jobArriving = new TestObject('objectName')
	jobArriving.addProperty('xpath', ConditionType.EQUALS, arrivingJOb)
	WebUI.click(jobArriving)
	WebUI.click(clickOK)
	
	Thread.sleep(3000)
	
	
	WebUI.click(actionsButton)
	String working = findTestData('TestData/WebJobStatusChange').getValue("working", 1)
	String workingJOb = '//span[contains(text(),"'+working+'")]'
	TestObject jobworking = new TestObject('objectName')
	jobworking.addProperty('xpath', ConditionType.EQUALS, workingJOb)
	WebUI.click(jobworking)
	
	WebUI.click(clickOK)
	
	
}
else{
	println("Retry")
}
	