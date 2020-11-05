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
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.lang.String

CustomKeywords.'loginKeyword.AppLogin.getLogin'()

WebUI.mouseOver(findTestObject('CreateJobDevRepo/Page_Admin Utilities/span_Create Job'))

WebUI.click(findTestObject('CreateJobDevRepo/Page_Admin Utilities/span_Select_Create Job'))

WebUI.selectOptionByValue(findTestObject('CreateJobDevRepo/Page_Create Job/select_Select TemplateBuscar trabajoSearch _423792'),
	'object:164', true)

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

/*FileInputStream file = new FileInputStream (new File("C:\\Users\\Anant\\Desktop\\DishCreateJobData.xlsx"))
XSSFWorkbook workbook = new XSSFWorkbook(file);
XSSFSheet sheet = workbook.getSheetAt(0);
totalRows = sheet.getPhysicalNumberOfRows();

println (totalRows)


Map<String, Integer> map = new HashMap<String,Integer>();
HSSFRow row = sheet.getRow(0);*/

if (WebUI.verifyElementVisible(findTestObject('CreateJobDevRepo/Page_Create Job/input_Ubicacin del cliente_dropLocation'),0,FailureHandling.OPTIONAL)){
	WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input_Ubicacin del cliente_dropLocation'), 
    'Baner')
	Thread.sleep(3000L)
	WebUI.sendKeys(findTestObject('CreateJobDevRepo/Page_Create Job/input_Ubicacin del cliente_dropLocation'), Keys.chord(Keys.DOWN, 
        Keys.ENTER))
	}
	else{
		println("object not visible")
	}
	if (WebUI.verifyElementVisible(findTestObject('CreateJobDevRepo/Page_Create Job/div_SelectSkillset'),0,FailureHandling.OPTIONAL)){
	WebUI.click(findTestObject('CreateJobDevRepo/Page_Create Job/div_SelectSkillset'))

	WebUI.check(findTestObject('CreateJobDevRepo/Page_Create Job/div_Operaciones - Operaciones'))
	}
/*			
		
					//String xpath = '//input[@id="'+ headers.get(i) + '" or @placeholder="'+ headers.get(i) + '" ]'
					String xpath = '//select[@name="'+ headers.get(i) + '"]'
					//select[@name='priority']
					TestObject to = new TestObject('objectName')
					to.addProperty('xpath', ConditionType.EQUALS, xpath)
					WebUI.scrollToElement(to, 0)
					WebUI.click(to)
					
					String dynamicId = rowValues.get(i)
					println("This is the dropdown value "+dynamicId)
					String dropDownValue = '//option[contains(text(),"' + dynamicId + '")]'
					println("xapth is "+ dropDownValue)
					TestObject dropdown = new TestObject("objectNamedropdown")
					dropdown.addProperty('xpath', ConditionType.EQUALS, dropDownValue)
					WebUI.click(dropdown)
					
		}
		catch(Exception e){
			
		}
		
		try{
			//String xpath = '//input[@id="'+ headers.get(i) + '" or @placeholder="'+ headers.get(i) + '" ]'
			String xpath = '//input[@placeholder="'+ headers.get(i) + '"]'
			TestObject to = new TestObject('objectName')
			to.addProperty('xpath', ConditionType.EQUALS, xpath)
			WebUI.scrollToElement(to, 0)
			WebUI.click(to)
			
			String dynamicId = rowValues.get(i)
			println("This is the dropdown value "+dynamicId)
			String dropDownValue = '//div[contains(text(),"' + dynamicId + '")]'
			println("xapth is "+ dropDownValue)
			TestObject dropdown = new TestObject("objectNamedropdown")
			dropdown.addProperty('xpath', ConditionType.EQUALS, dropDownValue)
			WebUI.click(dropdown)
	
}
catch(Exception e){
	
}

}
}

*/