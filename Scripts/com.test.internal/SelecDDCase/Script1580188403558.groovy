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
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'loginKeyword.AppLogin.getLogin'()

WebUI.mouseOver(findTestObject('UserManagementRepo/SiderBar'))

WebUI.mouseOver(findTestObject('Object Repository/CreateAssetRepo/SelectAssetManagementFromSideBar'))

WebUI.click(findTestObject('Object Repository/CreateAssetRepo/span_All assets'))

//li[@id='ui-id-3']//span[@class='fancytree-checkbox fancytree-radio fa fa-circle-thin']

CustomKeywords.'levelKeyword.LevelSelectToCreateAsset.selecLevel'()

WebUI.click(findTestObject('Object Repository/CreateAssetRepo/button_ Create New Asset'))

List <String> headers = findTestData('ForTesting/NewUpdatedTest').getColumnNames()
println("All headers are "+ headers)
println("Count of headers are "+ headers.get(0))
List <List<String>> values = findTestData('ForTesting/NewUpdatedTest').getAllData()   // to get all data in sheet without headers
println("Rowvalue is " + values.get(0).get(0))

int headersCount = findTestData('ForTesting/NewUpdatedTest').getColumnNumbers()
println(headersCount)

for(int j=0; j<values.size();j++){
	List<String> rowValues = values.get(j);
	for(int i=0;i<headersCount.SIZE;i++){
		String xpath = '//input[@name="'+ headers.get(i) +'" or @placeholder ="'+ headers.get(i) +'" ]'
		TestObject to = new TestObject('objectName')
		to.addProperty('xpath', ConditionType.EQUALS, xpath)
		WebUI.scrollToElement(to, 0)
		String dropDownLoc = '//span[contains(text(),"' + rowValues.get(i) + '")]'
		TestObject dropDownElement = new TestObject('objectName')
		dropDownElement.addProperty('xpath', ConditionType.EQUALS, dropDownLoc)
	
					try{
						WebUI.click(to)
						WebUI.setText(to,rowValues.get(i))
					}
					finally{
							WebUI.click(dropDownElement)
						
							/*String dropDownLocType = '//div[contains(text(),"' + rowValues.get(i) + '")]'
							TestObject dropDownElementType = new TestObject('objectName')
							dropDownElementType.addProperty('xpath', ConditionType.EQUALS, dropDownLocType)
							WebUI.click(dropDownElementType)*/
						
				}
		}
			
}
