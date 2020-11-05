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

String toolTip = WebUI.getAttribute(findTestObject('Object Repository/ProfilePageRepo/UserNameButton'), 'uib-tooltip')
String userFirstName = findTestData('TestData/ProfilePageData').getValue("userFirstName", 1)           

//boolean istoolTipDisplayed = WebUI.verifyEqual(toolTip, userFirstName)    

if(toolTip.equalsIgnoreCase(userFirstName))           // to validate tooltip
{
	WebUI.click(findTestObject('Object Repository/ProfilePageRepo/UserNameButton'))
	WebUI.click(findTestObject('Object Repository/ProfilePageRepo/ViewProfile'))
	WebUI.waitForElementVisible(findTestObject('Object Repository/ProfilePageRepo/ProfilePageDetails'), 0)
	
	int headerCount = findTestData('TestData/ProfilePageData').getColumnNumbers()
	List<String> headers = findTestData('TestData/ProfilePageData').getColumnNames()
	println(headers)
	List <List<String>> dataValues = findTestData('TestData/ProfilePageData').getAllData()
	
	for(int j=0; j<dataValues.size();j++){
		List<String> rowValues = dataValues.get(j);
	for(int i=0;i<headerCount;i++){
	//testData = driver.findElement(By.xpath('//input[@name="'+headers.get(i)+'"]')).getAttribute("value")
		userData = '//input[@id="'+headers.get(i)+'"]'
		TestObject tObj = new TestObject('objectName')
		tObj.addProperty('xpath', ConditionType.EQUALS, userData)
		//println("userdata is: "+userData)
		WebElementValue = WebUI.getAttribute(tObj, "value")
		
		/*println("value is: "+WebElementValue)
		println("datavalues are: "+rowValues.get(i))*/
		if(WebUI.verifyEqual(WebElementValue, rowValues.get(i))){
		println("User details verified successfully "+WebElementValue)
		}
		else{
			println("No data found")
	  }
	}
  }
}