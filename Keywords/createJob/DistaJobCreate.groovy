package createJob

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.codehaus.groovy.tools.shell.completion.KeywordSyntaxCompletor
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
import org.openqa.selenium.Keys as Keys

import internal.GlobalVariable


public class DistaJobCreate {
	@Keyword
	public void createJobEntity(){

		for (def rowNum = 1; rowNum >= findTestData('TestData/DistaCreateJobData').getRowNumbers(); rowNum++) {
			WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input_Nmero de ODT_jobCode'), findTestData('TestData/DistaCreateJobData').getValue(
					3, rowNum))

			WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input_Nmero de ODT virtual_secondoryUniqueId'), findTestData(
					'TestData/DishCreateJobData').getValue(1, rowNum))

			WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input_Fecha y hora programada_expectedTime'), findTestData(
					'TestData/DishCreateJobData').getValue(2, rowNum))

			/*   WebUI.click(findTestObject('CreateJobDevRepo/Page_Create Job/td_16'))
			 WebUI.click(findTestObject('CreateJobDevRepo/Page_Create Job/span_900 AM'))
			 WebUI.click(findTestObject('CreateJobDevRepo/Page_Create Job/span_900 AM'))*/
			WebUI.click(findTestObject('CreateJobDevRepo/Page_Create Job/div_SelectSkillset'))

			WebUI.check(findTestObject('CreateJobDevRepo/Page_Create Job/div_Operaciones - Operaciones'))

			WebUI.scrollToElement(findTestObject('CreateJobDevRepo/Page_Create Job/input__customerId'), 0)

			WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__customerId'), findTestData('TestData/DistaCreateJobData').getValue(
					5, rowNum))

			WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__customerName'), findTestData('TestData/DistaCreateJobData').getValue(
					6, rowNum))

			WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__streetName'), findTestData('TestData/DistaCreateJobData').getValue(
					7, rowNum))

			WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__buildingNumber'), findTestData('TestData/DistaCreateJobData').getValue(
					8, rowNum))

			WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__postCode'), findTestData('TestData/DistaCreateJobData').getValue(
					9, rowNum))

			WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__colony'), findTestData('TestData/DistaCreateJobData').getValue(
					10, rowNum))

			WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__municipality'), findTestData('TestData/DistaCreateJobData').getValue(
					11, rowNum))

			WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__city'), findTestData('TestData/DistaCreateJobData').getValue(
					12, rowNum))

			WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input__state'), findTestData('TestData/DistaCreateJobData').getValue(
					13, rowNum))

			WebUI.setText(findTestObject('CreateJobDevRepo/Page_Create Job/input_Ubicacin del cliente_dropLocation'), findTestData(
					'TestData/DishCreateJobData').getValue(14, rowNum))

			Thread.sleep(4000)

			WebUI.sendKeys(findTestObject('CreateJobDevRepo/Page_Create Job/input_Ubicacin del cliente_dropLocation'), Keys.chord(
					Keys.DOWN, Keys.ENTER))

			Thread.sleep(3000)

			WebUI.click(findTestObject('CreateJobDevRepo/CreateJobButton/CreateJobbutton'))


			Thread.sleep(9000)
		}
	}
}


