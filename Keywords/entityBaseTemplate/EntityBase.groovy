package entityBaseTemplate

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

public class EntityBase {

	@Keyword
	public void createJobEntity(){
		List <String> headers = findTestData('TestData/DistaCreateJobData').getColumnNames()
		println("All headers are "+ headers)
		println("Count of headers are "+ headers.get(0))
		List <List<String>> values = findTestData('TestData/DistaCreateJobData').getAllData()   // to get all data in sheet without headers
		println("Rowvalue is " + values.get(0).get(0))

		int headersCount = findTestData('TestData/DistaCreateJobData').getColumnNumbers()
		println(headersCount)

		for(int j=0; j<values.size();j++){
			List<String> rowValues = values.get(j);
			for(int i=0;i<headersCount.SIZE;i++){

				try{

					String xpath = '//input[@name="'+ headers.get(i) + '"]'
					TestObject to = new TestObject('objectName')
					to.addProperty('xpath', ConditionType.EQUALS, xpath)
					WebUI.scrollToElement(to, 0)
					WebUI.setText(to,rowValues.get(i))
				}
				catch (Exception e){
					e.printStackTrace()
				}
			}
		}

	}

}
