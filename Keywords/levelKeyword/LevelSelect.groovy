package levelKeyword

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

import internal.GlobalVariable

public class LevelSelect {
	@Keyword
	public void selecLevel(){


		WebUI.click(findTestObject('JobStateVerifyRepo/button_Expand all'))

		String getAccessLevelValue = findTestData('TestData/LevelSelect').getValue("AccessLevel", 1)

		String AccessLevelElementXpath = '//span[contains(text(),"'+getAccessLevelValue+'")]'
		TestObject acceessLevelElem = new TestObject('objectName')
		acceessLevelElem.addProperty('xpath', ConditionType.EQUALS, AccessLevelElementXpath)

		WebUI.scrollToElement(acceessLevelElem, 0)

		String selectChildElements = '//span[contains(text(),"'+getAccessLevelValue+'")]//preceding::span[1]'
		TestObject childElementSelection = new TestObject('objectName')
		childElementSelection.addProperty('xpath', ConditionType.EQUALS, selectChildElements)
		WebUI.click(childElementSelection)       //for QA

		//WebUI.click(findTestObject('JobStateVerifyRepo/levelCheckboxSelect - dev'))		// for Dev

		WebUI.click(findTestObject('JobStateVerifyRepo/button_Apply'))
	}
}
