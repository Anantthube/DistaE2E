package createJob

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.codehaus.groovy.tools.shell.completion.KeywordSyntaxCompletor
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Keys as Keys

import internal.GlobalVariable


public class JobCreate {
	@Keyword
	public void createJobEntity(){

		/*	for (def rowNum = 1; rowNum >= findTestData('TestData/DistaCreateJobData').getRowNumbers(); rowNum++) {*/
		WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input_Nmero de ODT_jobCode'),
				findTestData('TestData/DistaCreateJobData').getValue(1, 1))

		WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input_Nmero de ODT virtual_secondoryUniqueId'), findTestData(
				'TestData/DishCreateJobData').getValue(1, 1))

		WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input_Fecha y hora programada_expectedTime'), findTestData(
				'TestData/DishCreateJobData').getValue(2, 1))

		WebUI.click(findTestObject('CreateJobDevRepo/Page_Create Job/div_SelectSkillset'))

		WebUI.check(findTestObject('CreateJobDevRepo/Page_Create Job/div_Operaciones - Operaciones'))

		WebUI.scrollToElement(findTestObject('CreateJobDevRepo/Page_Create Job/input__customerId'), 0)

		WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__customerId'), findTestData('TestData/DistaCreateJobData').getValue(
				5, 1))

		WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__customerName'), findTestData('TestData/DistaCreateJobData').getValue(
				6, 1))

		WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__streetName'), findTestData('TestData/DistaCreateJobData').getValue(
				7, 1))

		WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__buildingNumber'), findTestData('TestData/DistaCreateJobData').getValue(
				8, 1))

		WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__postCode'), findTestData('TestData/DistaCreateJobData').getValue(
				9, 1))

		WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__colony'), findTestData('TestData/DistaCreateJobData').getValue(
				10, 1))

		WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__municipality'), findTestData('TestData/DistaCreateJobData').getValue(
				11, 1))

		WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__city'), findTestData('TestData/DistaCreateJobData').getValue(
				12, 1))


		WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input_Ubicacin del cliente_dropLocation'), findTestData(
				'TestData/DishCreateJobData').getValue(14, 1))

		Thread.sleep(4000)

		WebUI.sendKeys(findTestObject('CreateJobDevRepo/Page_Create Job/input_Ubicacin del cliente_dropLocation'), Keys.chord(
				Keys.DOWN, Keys.ENTER))

		Thread.sleep(2000)

		WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__state'), findTestData('TestData/DistaCreateJobData').getValue(
				13, 1))
		WebUI.scrollToElement(findTestObject('CreateJobDevRepo/CreateJobButton/CreateJobbutton'), 0)

		WebUI.click(findTestObject('CreateJobDevRepo/CreateJobButton/CreateJobbutton'))

		Thread.sleep(15000)
		/*
		 WebUI.mouseOver(findTestObject('CreateJobDevRepo/Page_Admin Utilities/span_Create Job'))
		 WebUI.mouseOver(findTestObject('CreateJobDevRepo/Page_Admin Utilities/select Create job from sideBar'))
		 WebUI.click(findTestObject('JobStateVerifyRepo/click_Jobs Dashboard'))
		 WebUI.click(findTestObject('JobStateVerifyRepo/button_Expand all'))
		 WebUI.scrollToElement(findTestObject('JobStateVerifyRepo/navigateToLevel'), 0)
		 WebUI.click(findTestObject('JobStateVerifyRepo/levelCheckboxSelect'))
		 WebUI.click(findTestObject('JobStateVerifyRepo/button_Apply'))
		 Thread.sleep(3000)
		 String JobCode = findTestData('TestData/DistaCreateJobData').getValue(3, 1)
		 String xpath = ('//td[contains(text(),"' + JobCode) + '")]//following::button[1]'
		 TestObject to = new TestObject('objectName')
		 to.addProperty('xpath', ConditionType.EQUALS, xpath)
		 WebUI.click(to)
		 Thread.sleep(3000)
		 WebUI.click(findTestObject('JobStateVerifyRepo/AssignOption'))
		 WebUI.click(findTestObject('JobStateVerifyRepo/SearchAssetField'))
		 WebUI.click(findTestObject('JobStateVerifyRepo/SelectAvailableAsset'))
		 String AssetNumber = findTestData('TestData/DistaAppLogin').getValue(3, 1)
		 String AssetNum = '//span[contains(text(),"'+AssetNumber+'")]'
		 TestObject assetNum = new TestObject('objectName')
		 assetNum.addProperty('xpath', ConditionType.EQUALS, AssetNum)
		 WebUI.scrollToElement(assetNum, 0)
		 WebUI.click(assetNum)
		 //To click OK button when asset is selected in the dropdown
		 WebUI.click(findTestObject('JobStateVerifyRepo/JobAssignPopUp_button_OK'))
		 */
		/*catch(Exception e){
		 WebUI.setText(findTestObject('JobStateVerifyRepo/SearchJobField'), JobCode)
		 }*/
	}
}



