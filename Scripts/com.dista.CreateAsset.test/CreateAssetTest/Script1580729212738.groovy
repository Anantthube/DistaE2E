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

WebUI.mouseOver(findTestObject('UserManagementRepo/SiderBar'))

WebUI.mouseOver(findTestObject('Object Repository/CreateAssetRepo/SelectAssetManagementFromSideBar'))

WebUI.click(findTestObject('Object Repository/CreateAssetRepo/span_All assets'))

//li[@id='ui-id-3']//span[@class='fancytree-checkbox fancytree-radio fa fa-circle-thin']

CustomKeywords.'levelKeyword.LevelSelectToCreateAsset.selecLevel'()

WebUI.click(findTestObject('Object Repository/CreateAssetRepo/button_ Create New Asset'))

List <String> headers = findTestData('TestData/CreateAssetTestData').getColumnNames()
println("All headers are "+ headers)
println("Count of headers are "+ headers.get(0))
List <List<String>> values = findTestData('TestData/CreateAssetTestData').getAllData()   // to get all data in sheet without headers
println("Rowvalue is " + values.get(0).get(0))

int headersCount = findTestData('TestData/CreateAssetTestData').getColumnNumbers()
println(headersCount)

for(int j=0; j<values.size();j++){
	List<String> rowValues = values.get(j);
	for(int i=0;i<headersCount.SIZE;i++){

		try{
			//String xpath = '//input[@id="'+ headers.get(i) + '" or @placeholder="'+ headers.get(i) + '" ]'
			String xpath = '//input[@name="'+ headers.get(i) +'" ]'
			TestObject to = new TestObject('objectName')
			to.addProperty('xpath', ConditionType.EQUALS, xpath)
			WebUI.scrollToElement(to, 0)
			WebUI.setText(to,rowValues.get(i))
			
		}
		catch (Exception e){
			break;
		}
		
	}
}
			//WebUI.scrollToElement(findTestObject('CreateAssetRepo/SelectSkillsets',0))
			
			WebUI.click(findTestObject('CreateAssetRepo/SelectSkillsets'))
			WebUI.check(findTestObject('CreateAssetRepo/SelectSkillsetsEntries'))
			
			WebUI.click(findTestObject('UserManagementRepo/SelectAccessLevel'))
			WebUI.check(findTestObject('CreateAssetRepo/selectLevelindropDown'))
			
			//pending to select FOS2 baner from the list 
			
			WebUI.click(findTestObject('CreateAssetRepo/selectAccessDDValue'))
			WebUI.click(findTestObject('Object Repository/CreateAssetRepo/button_Apply'))

					//To click save button on the template
			//WebUI.click(findTestObject('Object Repository/CreateAssetRepo/SaevAssetButton'))	