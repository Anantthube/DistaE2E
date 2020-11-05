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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'mobileAppLoginKeyword.AppLogin.makeAppLogin'()

Mobile.tap(findTestObject('AssetLoginLogout/android.widget.ImageButton0'), 0)

Mobile.tap(findTestObject('AssetLoginLogout/android.widget.TextView0 - PERFIL'), 0)

Mobile.tap(findTestObject('AssetLoginLogout/android.widget.ImageView0'), 0)

Mobile.tap(findTestObject('AssetLoginLogout/android.widget.TextView0 - Salir del sistema'), 0)

Mobile.tap(findTestObject('AssetLoginLogout/android.widget.TextView0 - Select'), 0)

Mobile.tap(findTestObject('AssetLoginLogout/android.widget.TextView0 - dh'), 0)

Mobile.tap(findTestObject('AssetLoginLogout/android.widget.Button0 - ENVIAR'), 0)

//Mobile.getText(findTestObject('AssetLoginLogout/android.widget.TextView0 - Usuario'), 0)

Mobile.closeApplication()
