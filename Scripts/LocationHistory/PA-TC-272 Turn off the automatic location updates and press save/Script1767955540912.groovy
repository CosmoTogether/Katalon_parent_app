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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil

// TestObjects
TestObject menuButton          = findTestObject('Object Repository/DashboardScreen/SettingEnginButton')
TestObject locationSettingsOpt    = findTestObject('Object Repository/DataAndSettingScreen/LocationSettingsTab')
TestObject autoUpdatesText   = findTestObject('Object Repository/LocationSettingScreen/AutomaticLocationUpdates')
TestObject switchObj1           = findTestObject('Object Repository/LocationSettingScreen/SwitchLocationUpdate')
TestObject switchObj2           = findTestObject('Object Repository/LocationSettingScreen/SwitchLocationOff')
TestObject saveButton          = findTestObject('Object Repository/LocationSettingScreen/SaveButton')


// Steps
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

Mobile.waitForElementPresent(locationSettingsOpt, 10)
Mobile.tap(locationSettingsOpt, 0)
KeywordUtil.logInfo('Opened Location Settings')

// Verify Automatic Location Updates text
try {
	Mobile.verifyElementVisible(autoUpdatesText, 5)
	KeywordUtil.logInfo('Automatic Location Updates section verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Automatic Location Updates verification failed: ' + e.getMessage())
}

Mobile.waitForElementPresent(switchObj1, 10)
Mobile.tap(switchObj1, 0)
KeywordUtil.logInfo('Toggled first switch')

// Check second switch state
Mobile.waitForElementPresent(switchObj2, 10)
String isEnabled = Mobile.getAttribute(switchObj2, 'enabled', 5)
if (isEnabled == 'true') {
	KeywordUtil.logInfo('Second switch is ENABLED')
} else {
	KeywordUtil.logInfo('Second switch is DISABLED')
}

Mobile.waitForElementPresent(saveButton, 10)
Mobile.tap(saveButton, 0)
KeywordUtil.logInfo('Tapped Save button')

// Navigate back
Mobile.pressBack()
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')
