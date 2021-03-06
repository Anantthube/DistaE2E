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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.MobileElement as MobileElement

CustomKeywords.'mobileAppLoginKeyword.AppLogin.makeAppLogin'()

String customerName = findTestData('TestData/AppJobStatus').getValue(5, 1)
//Add Test 1234
// few more jobs - TestJob0701, TestJob2020, TestJob1620
String currentJobState = findTestData('TestData/AppJobStatus').getValue(1, 1)

String startJob = findTestData('TestData/AppJobStatus').getValue(2, 1)

String arrivingJob = findTestData('TestData/AppJobStatus').getValue(3, 1)

String workingJob = findTestData('TestData/AppJobStatus').getValue(4, 1)


Mobile.scrollToText(('' + customerName) + '', FailureHandling.STOP_ON_FAILURE)

String jobStateElem = Mobile.getText(findTestObject('NewMobileRepo/android.widget.TextView0 - Asignado'), 0)

if (jobStateElem.equalsIgnoreCase(currentJobState)) {
	//Mobile.verifyElementText(findTestObject('MobileLoginRepo/android.widget.ImageView0'), '')
	Mobile.tap(findTestObject('AppJobStateChangeRepo/android.widget.Button0 - DETALLES'), 0)

	Mobile.scrollToText(('' + startJob) + '', FailureHandling.STOP_ON_FAILURE)

	Mobile.tap(findTestObject('AppJobStateChangeRepo/android.widget.Button0 - Comenzar'), 0)
	// updated code as per the latest behavior
	Thread.sleep(3000L)
	
	Mobile.tap(findTestObject('AppJobStateChangeRepo/android.widget.Button0 - DETALLES'), 0)

	Mobile.scrollToText(('' + arrivingJob) + '', FailureHandling.STOP_ON_FAILURE)

	Mobile.tap(findTestObject('AppJobStateChangeRepo/android.widget.Button0 - Llegando'), 0)

	Mobile.scrollToText(('' + workingJob) + '', FailureHandling.STOP_ON_FAILURE)

	Mobile.tap(findTestObject('AppJobStateChangeRepo/android.widget.Button0 - Trabajando'), 0)

	Mobile.waitForElementPresent(findTestObject('AppJobStateChangeRepo/android.widget.ImageButton0'), 10)

	Mobile.tap(findTestObject('AppJobStateChangeRepo/android.widget.ImageButton0'), 0)
} else {
   println("Job is not in assigned state, try with other job")
}

