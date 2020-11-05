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
import io.appium.java_client.MobileElement as MobileElement

CustomKeywords.'mobileAppLoginKeyword.AppLogin.makeAppLogin'()




/*Mobile.startApplication('C:\\Users\\Anant\\Desktop\\Dista__DISH__Operation_v13__dista-dish-qa.appspot.com__dista-dish-qa-firestore.apk', 
    true)

Mobile.setText(findTestObject('MobileLoginRepo/android.widget.EditText0 (1)'), GlobalVariable.AssetID, 0)

Mobile.tap(findTestObject('MobileLoginRepo/android.widget.Button0 - SIGUIENTE (1)'), 0)

Mobile.setText(findTestObject('MobileLoginRepo/android.widget.EditText0 (2)'), GlobalVariable.AssetPassword, 0)

Mobile.tap(findTestObject('MobileLoginRepo/android.widget.Button0 - ENTRAR (1)'), 0)

Thread.sleep(3000)

if (Mobile.verifyElementVisible(findTestObject('NewMobileRepo/android.widget.Button0 - OK'),0,FailureHandling.OPTIONAL)) {
 Mobile.tap(findTestObject('MobileLoginRepo/android.widget.Button0 - OK'), 0)
} 
else{
	println("Element is not visible")
}
if(Mobile.verifyElementVisible(findTestObject('MobileLoginRepo/android.widget.ImageView0'), 0,FailureHandling.OPTIONAL)){
	Mobile.tap(findTestObject('MobileLoginRepo/android.widget.ImageView0'), 0)
}
else{
	println("Navigated to Dashboard")
}*/
