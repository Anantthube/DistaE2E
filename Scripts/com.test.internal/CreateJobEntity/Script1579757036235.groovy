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
import com.kms.katalon.core.testdata.reader.CSVReader


CustomKeywords.'loginKeyword.AppLogin.getLogin'()

WebUI.mouseOver(findTestObject('CreateJobDevRepo/Page_Admin Utilities/span_Create Job'))

WebUI.click(findTestObject('CreateJobDevRepo/Page_Admin Utilities/span_Select_Create Job'))

WebUI.selectOptionByValue(findTestObject('CreateJobDevRepo/Page_Create Job/select_Select TemplateBuscar trabajoSearch _423792'),
	'object:164', true)

CustomKeywords.'entityBaseTemplate.EntityBaseforTest.createJobEntity'()

/*List <String> headers = findTestData('ForTesting/NewUpdatedTest').getColumnNames()
// get all header names
println("All headers are "+ headers)
println("Count of headers are "+ headers.get(0))


List <List<String>> values = findTestData('ForTesting/NewUpdatedTest').getAllData() 
// to get all data in sheet without headers
println("Rowvalue is " + values.get(0).get(0))

int headersCount = findTestData('ForTesting/NewUpdatedTest').getColumnNumbers()
//to get count of Headers
println("Headers count is -" + headersCount)

for(int j=0; j<values.size();j++){
	List<String> rowValues = values.get(j);
	for(int i=0;i<headersCount.SIZE;i++){

		try{
					String xpath = '//input[@id="'+ headers.get(i) + '" or @placeholder="'+ headers.get(i) + '" ]'
					//String xpath = '//input[@name="'+ headers.get(i) + '"]'
					TestObject to = new TestObject('objectName')
					to.addProperty('xpath', ConditionType.EQUALS, xpath)
					WebUI.scrollToElement(to, 0)
					WebUI.setText(to,rowValues.get(i))
			
			
		}
		catch (Exception e){
			String dynamicId = rowValues.get(i)
			println("This is the dropdown value "+dynamicId)
			String dropDownValue = '//div[contains(text(),"' + dynamicId + '")]'
			println("xapth is "+ dropDownValue)
			TestObject dropdown = new TestObject("objectNamedropdown")
			dropdown.addProperty('xpath', ConditionType.EQUALS, dropDownValue)
			WebUI.click(dropdown)
		}
		
	}
	
}*/

	

	
	




