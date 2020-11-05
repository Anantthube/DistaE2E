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
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement

CustomKeywords.'loginKeyword.AppLogin.getLogin'()

CustomKeywords.'levelKeyword.LevelSelectToCreateJob.selecLevel'()

String JobCode = findTestData('TestData/DistaCreateJobData').getValue("jobCode", 1)
String xpath = ('//td[contains(text(),"' + JobCode) + '")]//following::button[1]'
TestObject to = new TestObject('objectName')
to.addProperty('xpath', ConditionType.EQUALS, xpath)
WebUI.click(to)
/*WebUI.click(findTestObject('JobStateVerifyRepo/ViewOption'))
WebUI.click(findTestObject('JobStateVerifyRepo/ToggleViewCard'))
WebUI.click(findTestObject('JobStateVerifyRepo/EditOnCard'))*/

WebUI.click(findTestObject('JobStateVerifyRepo/EditJob'))

String testData = ""
List <String> headers = findTestData('TestData/VerifyJobData').getColumnNames()
println("All headers are "+ headers)
println("Count of headers are "+ headers.get(0))
List <List<String>> values = findTestData('TestData/VerifyJobData').getAllData()   // to get all data in sheet without headers
println("Rowvalue is " + values.get(0).get(0))

int headersCount = findTestData('TestData/VerifyJobData').getColumnNumbers()
println(headersCount)
WebDriver driver = DriverFactory.getWebDriver()


for(int j=0; j<values.size();j++){
	List<String> rowValues = values.get(j);
	for(int i=0;i<headersCount.SIZE;i++){
			/*boolean isPresent=driver.findElements(By.xpath('//input[@name="'+headers.get(i)+'"]')).size() !=0
			if(isPresent){*/
				Thread.sleep(4000)
				//WebElement elements = driver.findElement(By.xpath('//input[@name="'+headers.get(i)+'"]'))
				testData = driver.findElement(By.xpath('//input[@name="'+headers.get(i)+'"]')).getAttribute("value")
				elements = '//input[@name="'+headers.get(i)+'"]'
				TestObject TestDataObject = new TestObject('objectName')
				TestDataObject.addProperty('xpath', ConditionType.EQUALS, elements)
				WebUI.scrollToElement(TestDataObject, 0,FailureHandling.OPTIONAL)
				if(WebUI.verifyEqual(testData, rowValues.get(i))){
					Thread.sleep(2000)
					println("Job data verified successfully "+ testData )
				}
				else{
					println("Job data does not match" + testData,FailureHandling.OPTIONAL)
					
				}
			}
			/*try{
				
				dropDownTestData = driver.findElement(By.xpath('//span[contains(text(),"'+headers.get(i)+'")]')).getAttribute("value")
				TestObject TestDataObjectdd = new TestObject('objectName')
				TestDataObjectdd.addProperty('xpath', ConditionType.EQUALS, dropDownElements)
				if(WebUI.verifyEqual(dropDownTestData, rowValues.get(i))){
					Thread.sleep(2000)
					println("Job data verified successfully "+ testData )
				}
				else{
					println("Job data does not match" + testData,FailureHandling.OPTIONAL)
					
				}
			}
			catch(Exception e){
				
			}*/
		
	}		

					
			
			
			
			
			
			
			
	

//ul[@class='dropdown-menu jobs-dropdownCard']//span[@class='ng-binding'][contains(text(),'Edit')]

/*elems = "//div[@class='job-details-board pt-10 ng-scope open statusBgGreen max-height-closed']"
TestObject Dropdown = new TestObject('objectName')
Dropdown.addProperty('xpath', ConditionType.EQUALS, elems)*/



//h3[contains(text(),"1-5495432")]    			//
//h3[contains(text(),"V-55335")]				// virtual no
//div[contains(text(),'Fos1-Baner')]          //Area
//div[contains(text(),'Test1015')]            //cust Name




