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


WebUI.callTestCase(findTestCase('com.dista.Login.test/LoginTest'), [('URL') : '', ('Username') : '', ('Password') : ''], 
    FailureHandling.STOP_ON_FAILURE)

Thread.sleep(3000)

WebUI.mouseOver(findTestObject('CreateJobDevRepo/Page_Admin Utilities/span_Create Job'))

WebUI.click(findTestObject('CreateJobDevRepo/Page_Admin Utilities/span_Select_Create Job'))

WebUI.selectOptionByValue(findTestObject('CreateJobDevRepo/Page_Create Job/select_Select TemplateBuscar trabajoSearch _423792'), 
    'object:171', true)

WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input_Nmero de ODT_jobCode'), '1-092131')

WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input_Nmero de ODT virtual_secondoryUniqueId'), 
    'V-037211')

WebUI.click(findTestObject('CreateJobDevRepo/Page_Create Job/input_Fecha y hora programada_expectedTime'))

WebUI.click(findTestObject('CreateJobDevRepo/Page_Create Job/td_16'))

WebUI.click(findTestObject('CreateJobDevRepo/Page_Create Job/span_900 AM'))

WebUI.click(findTestObject('CreateJobDevRepo/Page_Create Job/span_900 AM'))

WebUI.click(findTestObject('CreateJobDevRepo/Page_Create Job/div_SelectSkillset'))

WebUI.check(findTestObject('CreateJobDevRepo/Page_Create Job/div_Operaciones - Operaciones'))

WebUI.scrollToElement(findTestObject('CreateJobDevRepo/Page_Create Job/input__jobCode'), 0)

WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__jobCode'), '56372')

WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__customerName'), 'Test1612')

WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__streetName'), 'Baner')

WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__buildingNumber'), 'Baner')

WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__postCode'), '411014')

WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__colony'), 'Baner')

WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__municipality'), 'Baner')

WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__city'), 'Baner')

WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__state'), 'Baner')

WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input_Ubicacin del cliente_dropLocation'), 
    'Baner')

Thread.sleep(4000L);

WebUI.sendKeys(findTestObject('CreateJobDevRepo/Page_Create Job/input_Ubicacin del cliente_dropLocation'), Keys.chord(Keys.DOWN, 
        Keys.ENTER))


