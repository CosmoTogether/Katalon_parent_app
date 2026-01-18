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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// Optional: wait for app to load
Mobile.delay(10)
KeywordUtil.logInfo("*************** Starting Test ****************")

// --- Start the app ---
Mobile.startApplication('/root/Cosmo_App/Include/app/app_releaseCosmo_3.1.2.680.apk', false)
//Mobile.startExistingApplication("com.cosmo.missioncontrol")
Mobile.delay(20)
KeywordUtil.logInfo("*************** App Started ****************")

Mobile.scrollToText("COSMO device yet", FailureHandling.CONTINUE_ON_FAILURE)

// --- Create dynamic TestObject ---
TestObject dynamicText = new TestObject("dynamicText")
dynamicText.addProperty("xpath", ConditionType.EQUALS, "//*[@class='android.widget.TextView' and contains(@text,'COSMO device yet')]")

// --- Wait for the element to be visible (up to 60 seconds) ---
if(Mobile.waitForElementPresent(dynamicText, 60, FailureHandling.OPTIONAL)) {
	KeywordUtil.logInfo("✅ Element 'COSMO device yet' is visible")
} else {
	KeywordUtil.logInfo("❌ Element 'COSMO device yet' NOT found. Check XPath or screen visibility.")
	Mobile.takeScreenshot("/root/Cosmo_App/Screenshots/dynamicText_not_found.png") // Debug screenshot
	assert false : "Element 'COSMO device yet' not found"
}

Mobile.verifyElementVisible(dynamicText, 30)
KeywordUtil.logInfo("*************** Page verified ****************")


Mobile.tap(findTestObject('Object Repository/PA-TC-116/android.widget.Button - Sign in'), 40)

KeywordUtil.logInfo("*************** finally ****************")

Mobile.setText(findTestObject('Object Repository/PA-TC-116/android.widget.AutoCompleteTextView - Email'), username, 80)

Mobile.setText(findTestObject('Object Repository/PA-TC-116/android.widget.EditText - Password'), password, 60)

KeywordUtil.logInfo("*************** sucessfully againnn ****************")


Mobile.tap(findTestObject('Object Repository/PA-TC-116/android.widget.Button - Sign in (1)'), 60)

Mobile.verifyElementVisible(findTestObject('Object Repository/PA-TC-116/android.widget.TextView - This email address or password is invalid'), 60)

Mobile.closeApplication()

