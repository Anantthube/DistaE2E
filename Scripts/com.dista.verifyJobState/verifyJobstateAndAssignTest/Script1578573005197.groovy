import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.junit.After as After
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

WebUI.openBrowser('')

WebUI.navigateToUrl('https://dista-dish-qa.appspot.com/#!/login')

WebUI.setText(findTestObject('Object Repository/CreateUserRepo/input_Log In_userid'), 'anant.thube@mediaagility.com')

WebUI.setEncryptedText(findTestObject('Object Repository/CreateUserRepo/input_Log In_hide-password'), 'cvW8qx4B2o1WegCEDy41Xg==')

WebUI.click(findTestObject('Object Repository/CreateUserRepo/span_User dashboard'))

WebUI.click(findTestObject('Object Repository/CreateUserRepo/span_Collapse all_fancytree-checkbox fa fa-_bd3b53'))

WebUI.click(findTestObject('Object Repository/CreateUserRepo/button_Apply'))

WebUI.click(findTestObject('Object Repository/CreateUserRepo/button_ Create User'))

WebUI.setText(findTestObject('Object Repository/CreateUserRepo/input_First name_firstName'), 'TestUser')

WebUI.setText(findTestObject('Object Repository/CreateUserRepo/input_Last name_lastName'), 'Testuser')

WebUI.setText(findTestObject('Object Repository/CreateUserRepo/input_Email ID_emailId'), 'testuser@gmail.com')

WebUI.setText(findTestObject('Object Repository/CreateUserRepo/input_Mobile Number_mobileNumber'), '9860680121')

WebUI.setText(findTestObject('Object Repository/CreateUserRepo/input_User ID (Valid email ID)_userid'), 'testuser@gmail.com')

WebUI.click(findTestObject('Object Repository/CreateUserRepo/div'))

WebUI.click(findTestObject('Object Repository/CreateUserRepo/span_Admin'))

WebUI.click(findTestObject('Object Repository/CreateUserRepo/span_Field officer'))

WebUI.click(findTestObject('Object Repository/CreateUserRepo/i_Apply_jstree-icon jstree-checkbox'))

WebUI.click(findTestObject('Object Repository/CreateUserRepo/button_Apply (1)'))

WebUI.setEncryptedText(findTestObject('Object Repository/CreateUserRepo/input_Password_hide-password'), 'cvW8qx4B2o1WegCEDy41Xg==')

WebUI.click(findTestObject('Object Repository/CreateUserRepo/button_Update details'))

WebUI.click(findTestObject('Object Repository/CreateUserRepo/div_                  User successfully saved'))

WebUI.closeBrowser()

