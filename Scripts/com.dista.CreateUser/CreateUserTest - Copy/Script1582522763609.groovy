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
import org.openqa.selenium.By
import org.openqa.selenium.By.ById
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

CustomKeywords.'loginKeyword.AppLogin.getLogin'()

WebUI.mouseOver(findTestObject('UserManagementRepo/SiderBar'))
WebUI.click(findTestObject('UserManagementRepo/span_User Management'))
WebUI.mouseOver(findTestObject('UserManagementRepo/returnToLevelbox'))

CustomKeywords.'levelKeyword.LevelSelect.selecLevel'()

Thread.sleep(2000)
WebUI.click(findTestObject('UserManagementRepo/button_ Create User'))
WebDriver driver = DriverFactory.getWebDriver()
Actions myAction = new Actions(driver)

String xpath = ""
String ddXpath = ""
List <String> headers = findTestData('TestData/CreateUserTestData').getColumnNames()
println("All headers are "+ headers)
println("Count of headers are "+ headers.get(0))
List <List<String>> values = findTestData('TestData/CreateUserTestData').getAllData()   // to get all data in sheet without headers
println("Rowvalue is " + values.get(0).get(0))

int headersCount = findTestData('TestData/CreateUserTestData').getColumnNumbers()
	
for(int j=0; j<values.size();j++){
	List<String> rowValues = values.get(j);
	for(int i=0;i<headersCount.SIZE;i++){
	boolean isPresent=driver.findElements(By.id(headers.get(i))).size() !=0
	boolean isPlaceholderElementPresent = driver.findElements(By.xpath('//input[@placeholder="'+ headers.get(i) +'" ]')).size()!=0							
	try{
	if(isPresent){
			xpath = '//input[@id="'+ headers.get(i) +'" ]'         ////input[@id='firstName']
			TestObject to = new TestObject('objectName')
			to.addProperty('xpath', ConditionType.EQUALS, xpath)
			WebUI.scrollToElement(to, 0)
			WebUI.setText(to,rowValues.get(i))
	}
			else if(isPlaceholderElementPresent){
				ddXpath = '//input[@placeholder="'+ headers.get(i) +'" ]'
				TestObject Dropdown = new TestObject('objectName')
				Dropdown.addProperty('xpath', ConditionType.EQUALS, ddXpath)
				WebUI.scrollToElement(Dropdown, 0)
				WebUI.click(Dropdown)
				
				String dynamicId = rowValues.get(i)
				String xpathdd = '//span[contains(text(),"' +dynamicId+ '")]'
				println(xpathdd)
			
				TestObject dd = new TestObject("objectName")
				dd.addProperty("xpath", ConditionType.EQUALS, xpathdd)
				WebUI.scrollToElement(dd, 0)
				WebUI.check(dd)
				}
				else{
				String accessValue = findTestData('TestData/CreateUserTestData').getValue("AccessLevelSelection", headers.get(i))
				println("from the sheet-"+ accessValue)
				String accessName = '//a[contains(text(),"' +accessValue+ '")]'
				println("actual xpath is"+accessName)
				TestObject accessLevelName = new TestObject('objectName')
				accessLevelName.addProperty('xpath', ConditionType.EQUALS, accessName)
				WebUI.click(accessLevelName)
				//FailureHandling.CONTINUE_ON_FAILURE
			}
			}
				catch(Exception e){
				
					println ("values entered")
					WebUI.click(findTestObject('UserManagementRepo/selectPrimaryAccessLevel'))
					WebUI.click(findTestObject('Object Repository/UserManagementRepo/button_Apply (1)'))
					//WebUI.click(findTestObject('UserManagementRepo/button_Update details'))
					 //To click on Update Details button to create user successfully
				}
				
	   }
}
				
				
 