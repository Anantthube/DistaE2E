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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.By.ById as ById
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory


CustomKeywords.'loginKeyword.AppLogin.getLogin'()

WebDriver driver = DriverFactory.getWebDriver()
WebUI.mouseOver(findTestObject('UserManagementRepo/SiderBar'))
WebUI.mouseOver(findTestObject('UserManagementRepo/span_User Management'))
WebUI.click(findTestObject('Object Repository/UserRole Repo/span_Client roles  operations'))

Thread.sleep(5000)
WebUI.click(findTestObject('Object Repository/UserRole Repo/button_ Add role'))

List <String> headers = findTestData('TestData/CreateUserRole').getColumnNames()
println("All headers are "+ headers)

List <List<String>> values = findTestData('TestData/CreateUserRole').getAllData()   // to get all data in sheet without headers
println("Rowvalue is " + values.get(0).get(0))

int headersCount = findTestData('TestData/CreateUserRole').getColumnNumbers()
println(headersCount)
	
for(int j=0; j<values.size();j++){
	List<String> rowValues = values.get(j);
	for(int i=0;i<headersCount.SIZE;i++){
	//boolean isPresent=driver.findElements(By.id(headers.get(i))).size() !=0
	//boolean isPlaceholderElementPresent = driver.findElements(By.xpath('//input[@placeholder="'+ headers.get(i) +'" ]')).size()!=0
		try{
			boolean isPresent=driver.findElements(By.id(headers.get(i))).size() !=0

			if(isPresent){
				xpath = '//input[@id="'+ headers.get(i) +'" ]'
				TestObject to = new TestObject('objectName')
				to.addProperty('xpath', ConditionType.EQUALS, xpath)
				WebUI.scrollToElement(to, 0)
				WebUI.setText(to,rowValues.get(i))
			}
			else{
				ddXpath = '//input[@placeholder="'+ headers.get(i) +'" ]'
				TestObject Dropdown = new TestObject('objectName')
				Dropdown.addProperty('xpath', ConditionType.EQUALS, ddXpath)
				WebUI.scrollToElement(Dropdown, 0)
				WebUI.click(Dropdown)

				String dynamicId = rowValues.get(i)
				String xpathdd = '//span[contains(text(),"'+dynamicId+'")]'
				println(xpathdd)

				TestObject dd = new TestObject("objectName")
				dd.addProperty("xpath", ConditionType.EQUALS, xpathdd)
				WebUI.scrollToElement(dd, 0)
				WebUI.check(dd)
			}

		}
		catch(Exception e){
			println ("Job Created Succssfully")
			ButtonToSave = "//button[contains(text(),'Save role')]"
			TestObject SaveButton = new TestObject('objectName')
			SaveButton.addProperty('xpath', ConditionType.EQUALS, ButtonToSave)
			WebUI.click(SaveButton)
			
		}
	}
}
