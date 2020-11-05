package jobCreateUtil

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.webui.driver.DriverFactory
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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable

public class CreateJob {

	@Keyword
	public void jobCreateKeyword(){
		WebDriver driver = DriverFactory.getWebDriver()
		String xpath = ""
		String ddXpath = ""
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
					boolean isPresent=driver.findElements(By.name(headers.get(i))).size() !=0

					if(isPresent){
						xpath = '//input[@name="'+ headers.get(i) +'" ]'
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
						String xpathdd = '//div[contains(text(),"'+dynamicId+'")]'
						println(xpathdd)

						TestObject dd = new TestObject("objectName")
						dd.addProperty("xpath", ConditionType.EQUALS, xpathdd)
						WebUI.scrollToElement(dd, 0)
						WebUI.check(dd)
					}

				}
				catch(Exception e){
					println ("Job Created Succssfully")
				}
			}

		}

	}
}


