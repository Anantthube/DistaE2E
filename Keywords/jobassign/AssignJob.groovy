package jobassign

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

public class AssignJob {
	@Keyword
	public void assignJob(){

		WebUI.mouseOver(findTestObject('CreateJobDevRepo/Page_Admin Utilities/span_Create Job'))

		WebUI.mouseOver(findTestObject('CreateJobDevRepo/Page_Admin Utilities/select Create job from sideBar'))

		WebUI.click(findTestObject('JobStateVerifyRepo/click_Jobs Dashboard'))

		WebUI.click(findTestObject('JobStateVerifyRepo/button_Expand all'))

		WebUI.scrollToElement(findTestObject('JobStateVerifyRepo/navigateToLevel'), 0)

		WebUI.click(findTestObject('JobStateVerifyRepo/levelCheckboxSelect'))

		WebUI.click(findTestObject('JobStateVerifyRepo/button_Apply'))

		Thread.sleep(3000)

		String JobCode = findTestData('TestData/DistaCreateJobData').getValue(1, 1)

		String xpath = ('//td[contains(text(),"' + JobCode) + '")]//following::button[1]'
		TestObject to = new TestObject('objectName')
		to.addProperty('xpath', ConditionType.EQUALS, xpath)
		WebUI.click(to)
		Thread.sleep(3000)
		WebUI.click(findTestObject('JobStateVerifyRepo/AssignOption'))

		WebUI.click(findTestObject('JobStateVerifyRepo/SearchAssetField'))

		//WebUI.click(findTestObject('JobStateVerifyRepo/SelectAvailableAsset'))

		String AssetNumber = findTestData('TestData/DistaAppLogin').getValue(3, 1)
		String AssetNum = '//span[contains(text(),"'+AssetNumber+'")]'
		TestObject assetNum = new TestObject('objectName')
		assetNum.addProperty('xpath', ConditionType.EQUALS, AssetNum)
		WebUI.scrollToElement(assetNum, 0)
		WebUI.click(assetNum)

		//To click OK button when asset is selected in the dropdown
		WebUI.click(findTestObject('JobStateVerifyRepo/JobAssignPopUp_button_OK'))
	}
}