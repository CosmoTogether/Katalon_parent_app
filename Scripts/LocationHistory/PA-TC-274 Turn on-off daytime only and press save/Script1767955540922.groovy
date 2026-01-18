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

// TestObjects
TestObject menuButton           = findTestObject('Object Repository/case_14/case-8/android.widget.ImageButton')
TestObject locationSettingsOpt  = findTestObject('Object Repository/case_14/case-8/android.widget.TextView - Location settings')
TestObject switchObj            = findTestObject('Object Repository/case_14/case-8/android.widget.Switch')
TestObject saveButton           = findTestObject('Object Repository/case_14/case-8/android.widget.Button - Save')

// Steps
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

Mobile.waitForElementPresent(locationSettingsOpt, 10)
Mobile.tap(locationSettingsOpt, 0)
KeywordUtil.logInfo('Opened Location Settings')

Mobile.waitForElementPresent(switchObj, 10)
Mobile.tap(switchObj, 5)
KeywordUtil.logInfo('Tapped switch once')

Mobile.tap(switchObj, 5)
KeywordUtil.logInfo('Tapped switch twice to ensure toggle')

// Check switch state
String isEnabled = Mobile.getAttribute(switchObj, 'enabled', 5)
if (isEnabled == 'true') {
	KeywordUtil.logInfo('Switch is ENABLED already')
} else {
	KeywordUtil.logInfo('Switch is DISABLED — enabling now')
	Mobile.tap(switchObj, 5)
	String updated = Mobile.getAttribute(switchObj, 'enabled', 5)
	if (updated == 'true') {
		KeywordUtil.logInfo('Switch successfully ENABLED')
	} else {
		KeywordUtil.logInfo('Switch is still DISABLED')
	}
}

Mobile.waitForElementPresent(saveButton, 10)
Mobile.tap(saveButton, 0)
KeywordUtil.logInfo('Tapped Save button')

// Navigate back
Mobile.pressBack()
Mobile.delay(1)
Mobile.pressBack()
Mobile.delay(1)
KeywordUtil.logInfo('Navigated back to previous screen')
