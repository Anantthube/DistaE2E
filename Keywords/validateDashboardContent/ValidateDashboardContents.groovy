package validateDashboardContent

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
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

public class ValidateDashboardContents {

	@Keyword
	public void verifyDashboardElements(){

		String navBarXpath = "//nav[@class='navbar navbar-static-top']"
		TestObject navBar = new TestObject('objectName')
		navBar.addProperty('xpath', ConditionType.EQUALS, navBarXpath)

		String sideBarXpath  = "//section[@class='left-side row-offcanvas-left collapse-left z-depth margin-content box-shadow section004 ng-scope']//div[@id='customBar']"
		TestObject sideBar = new TestObject('objectName')
		sideBar.addProperty('xpath', ConditionType.EQUALS, sideBarXpath)

		String clientLogoXpath = '//div[@class="main-logo text-center cursor-pointer ng-scope"]//img'
		TestObject clientLogo = new TestObject('objectName')
		clientLogo.addProperty('xpath', ConditionType.EQUALS, clientLogoXpath)

		if(WebUI.verifyElementVisible(navBar) && WebUI.verifyElementVisible(sideBar)
		&& WebUI.verifyElementVisible(clientLogo)){
			println ("Page is loaded")
			//logger.logInfo("Page is loaded")
		}
		else {
			println("Waiting till the page load")
			WebUI.waitForElementVisible(navBar, 0)
			WebUI.waitForElementVisible(sideBar, 0)
			WebUI.waitForElementVisible(clientLogo, 0)
		}
	}
}
