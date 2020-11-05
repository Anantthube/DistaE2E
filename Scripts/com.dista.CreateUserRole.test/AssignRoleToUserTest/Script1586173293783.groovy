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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

CustomKeywords.'loginKeyword.AppLogin.getLogin'()

WebDriver driver = DriverFactory.getWebDriver()
WebUI.mouseOver(findTestObject('UserManagementRepo/SiderBar'))
WebUI.click(findTestObject('UserManagementRepo/span_User Management'))

CustomKeywords.'levelKeyword.LevelSelect.selecLevel'()
	
String userName = findTestData('TestData/AddRollToUser').getValue("userName", 1)
WebUI.setText(findTestObject('Object Repository/AssingRoleToExistingUserRepo/input_Actions_form-control input-sm input-field'),userName)
String RolltoEdit = findTestData('TestData/AddRollToUser').getValue("RollToAdd", 1)

actions = "//button[@uib-tooltip='Actions']"
TestObject actionsButton = new TestObject('objectName')
actionsButton.addProperty('xpath', ConditionType.EQUALS, actions)

boolean isVisible = WebUI.verifyElementVisible(actionsButton)
	
if(isVisible){
	
WebUI.click(actionsButton)
//WebUI.click(findTestObject('Object Repository/AssingRoleToExistingUserRepo/button_fos1-baner_btn icon-btn pull-right d_b63ebb'))

WebUI.click(findTestObject('Object Repository/AssingRoleToExistingUserRepo/a_Edit'))

addRole = "//input[@aria-label='Assign role']"
TestObject roleAdd = new TestObject('objectName')
roleAdd.addProperty('xpath', ConditionType.EQUALS, addRole)

WebUI.setText(roleAdd, RolltoEdit)

chooseRole = "//span[@class='ui-select-highlight']"
TestObject selectRole = new TestObject('objectName')
selectRole.addProperty('xpath', ConditionType.EQUALS, chooseRole)

WebUI.click(selectRole)
WebUI.click(findTestObject('Object Repository/AssingRoleToExistingUserRepo/button_Submit'))

}
else{
	println("User Not Found, Try with other User")
}

