import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.object_return
import org.openqa.selenium.Keys as Keys
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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.concurrent.TimeUnit;

CustomKeywords.'loginKeyword.AppLogin.getLogin'()

String selectClient = "//input[@placeholder='Select client']"
TestObject client = new TestObject('objectName')
client.addProperty('xpath', ConditionType.EQUALS, selectClient)

String chooseClient = "//span[contains(text(),'Dista Test')]"
TestObject clientSelect = new TestObject('objectName')
clientSelect.addProperty('xpath', ConditionType.EQUALS, chooseClient)

String logo = "//div[@class='logo-position-login']//img"
TestObject distaLogo = new TestObject('objectName')
distaLogo.addProperty('xpath', ConditionType.EQUALS, logo)

WebUI.click(client)
WebUI.click(clientSelect)

WebUI.click(findTestObject('Dista-ai-dev/OK_button'))

/*boolean isDisplayed = WebUI.verifyElementVisible(distaLogo)

if(isDisplayed){
	WebUI.click(findTestObject('Dista-ai-dev/Login_button'))
	WebUI.click(client)
	WebUI.click(clientSelect)
	WebUI.click(findTestObject('Dista-ai-dev/OK_button'))
}*/

WebUI.click(findTestObject('Dista-ai-dev/India_level'))
WebUI.click(findTestObject('Dista-ai-dev/Apply'))

int rowNumbers = findTestData('AllTestData/Dista-ai-dev').getRowNumbers()
println(rowNumbers)

for(def rowNum = 1; rowNum<=rowNumbers ; rowNum++){
	
WebUI.mouseOver(findTestObject('CreateJobDevRepo/Page_Admin Utilities/span_Create Job'))
WebUI.mouseOver(findTestObject('CreateJobDevRepo/Page_Admin Utilities/select Create job from sideBar'))
WebUI.click(findTestObject('JobStateVerifyRepo/click_Jobs Dashboard'))

WebUI.selectOptionByLabel(findTestObject('NewDev/select_Select TemplateBuscar trabajoSearch _4ed098'),'Job Template',false)

WebUI.setText(findTestObject('Object Repository/Dista-ai-Dev/Page_Create Job/input__subject'), 
	findTestData('AllTestData/Dista-ai-dev').getValue('Subject', rowNum))

WebUI.setText(findTestObject('Object Repository/Dista-ai-Dev/Page_Create Job/input__ExpectedTime'),
	findTestData('AllTestData/Dista-ai-dev').getValue('ExpectedTime', rowNum))

WebUI.click(findTestObject('Object Repository/Dista-ai-Dev/Page_Create Job/input__SelectaccessLevel'))
WebUI.check(findTestObject('Object Repository/Dista-ai-Dev/Page_Create Job/input__accessLevel'))

String access = "//a[contains(text(),'Pune')]"
TestObject accessSelect = new TestObject('objectName')
accessSelect.addProperty('xpath', ConditionType.EQUALS, access)

WebUI.scrollToElement(accessSelect, 0)
WebUI.click(accessSelect)
WebUI.click(findTestObject('Object Repository/Dista-ai-Dev/Page_Create Job/button_Apply'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Dista-ai-Dev/Page_Create Job/select_priority'),
	'1',false)

String scrolltoJobCode = "//input[@id='jobcodetextFieldId']"          
TestObject jobcodefield = new TestObject('objectName')
jobcodefield.addProperty('xpath', ConditionType.EQUALS, scrolltoJobCode)

WebUI.scrollToElement(jobcodefield, 0)

String actualJobCode = findTestData('AllTestData/Dista-ai-dev').getValue('JobCode', rowNum)


WebUI.setText(findTestObject('Object Repository/Dista-ai-Dev/Page_Create Job/input__jobcode'),
	findTestData('AllTestData/Dista-ai-dev').getValue('JobCode', rowNum))

WebUI.setText(findTestObject('Object Repository/Dista-ai-Dev/Page_Create Job/input__dropAddress'),
	findTestData('AllTestData/Dista-ai-dev').getValue('dropAddress', rowNum))

WebUI.setText(findTestObject('Object Repository/Dista-ai-Dev/Page_Create Job/input__MapdropLocation'),
	findTestData('AllTestData/Dista-ai-dev').getValue('mapLocation', rowNum))

Thread.sleep(3000)

WebUI.sendKeys(findTestObject('Object Repository/Dista-ai-Dev/Page_Create Job/input__MapdropLocation'), Keys.chord(
	Keys.DOWN, Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Dista-ai-Dev/Page_Create Job/input__Selectskillset'))

WebUI.check(findTestObject('Object Repository/Dista-ai-Dev/Page_Create Job/input__skillset'))

Thread.sleep(2000)


int Beforetime = System.currentTimeMillis()
String BeforeJobTime = Beforetime.toString()
println("before Time in miliseconds "+BeforeJobTime)

WebUI.click(findTestObject('Object Repository/Dista-ai-Dev/Page_Create Job/button_Save'))

String jobIDinSummary = '//b[contains(text(),"'+actualJobCode+'")]'
TestObject jobCode = new TestObject('objectName')
jobCode.addProperty('xpath', ConditionType.EQUALS, jobIDinSummary)

boolean isDisplayed = WebUI.verifyElementVisible(jobCode)
if(isDisplayed){
	int afterTime = System.currentTimeMillis()
	String afterJobTime = afterTime.toString()
	println("after Time in miliseconds "+afterJobTime)
	
	int timeDiff = afterTime-Beforetime
	int getActualTime = timeDiff/1000
	
	println("Actual time is "+getActualTime)
	
	long ActualSeconds = TimeUnit.MILLISECONDS.toSeconds(getActualTime)
	println("Actual Seconds are: "+ActualSeconds)
	
	FileInputStream file = new FileInputStream (new File("C:\\Users\\Anant\\Desktop\\DistaAutomationData\\JobsTimeStamp.xlsx"))
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheetAt(0);
	
	sheet.createRow(rowNum)
	//println("Jobcode is "+jobCode)
	//sheet.getRow(rowNum).createCell(rowNum).setCellValue(jobCode)
	sheet.getRow(rowNum).createCell(rowNum).setCellValue(ActualSeconds)
	
	file.close()
	FileOutputStream outFile = new FileOutputStream (new File("C:\\Users\\Anant\\Desktop\\DistaAutomationData\\JobsTimeStamp.xlsx"))
	workbook.write(outFile)
	outFile.close()
	
	Thread.sleep(16000)
}


} 
