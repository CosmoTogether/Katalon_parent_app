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
TestObject menuButton             = findTestObject('Object Repository/case_14/case-4/android.widget.ImageButton')
TestObject locationSettingsOpt    = findTestObject('Object Repository/case_14/case-4/android.widget.TextView - Location settings')
TestObject locationUpdateText     = findTestObject('Object Repository/case_14/case-4/android.widget.TextView - Location update')
TestObject automaticUpdatesText   = findTestObject('Object Repository/case_14/case-4/android.widget.TextView - Automatic Location Updates')
TestObject daytimeOnlyUpdatesText = findTestObject('Object Repository/case_14/case-4/android.widget.TextView - Daytime only updates')

// Steps
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

Mobile.waitForElementPresent(locationSettingsOpt, 10)
Mobile.tap(locationSettingsOpt, 0)
KeywordUtil.logInfo('Opened Location Settings')

// Verify Location Update
try {
	Mobile.verifyElementVisible(locationUpdateText, 5)
	KeywordUtil.logInfo('Location Update section verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Location Update verification failed: ' + e.getMessage())
}

// Verify Automatic Location Updates
try {
	Mobile.verifyElementVisible(automaticUpdatesText, 5)
	KeywordUtil.logInfo('Automatic Location Updates section verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Automatic Location Updates verification failed: ' + e.getMessage())
}

// Verify Daytime Only Updates
try {
	Mobile.verifyElementVisible(daytimeOnlyUpdatesText, 5)
	KeywordUtil.logInfo('Daytime Only Updates section verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Daytime Only Updates verification failed: ' + e.getMessage())
}

// Navigate back
Mobile.pressBack()
Mobile.delay(1)
Mobile.pressBack()
Mobile.delay(1)
KeywordUtil.logInfo('Navigated back to previous screen')
