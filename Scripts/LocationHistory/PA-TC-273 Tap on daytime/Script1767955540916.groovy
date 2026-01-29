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

// TestObjects0
TestObject menuButton          = findTestObject('Object Repository/DashboardScreen/SettingEnginButton')
TestObject locationSettingsOpt    = findTestObject('Object Repository/DataAndSettingScreen/LocationSettingsTab')
TestObject daytimeUpdatesText   = findTestObject('Object Repository/LocationSettingScreen/DaytimeOnlyUpdates')
TestObject setDaytimeRangeText  = findTestObject('Object Repository/LocationSettingScreen/Set Daytime range')
TestObject okButton             = findTestObject('Object Repository/LocationSettingScreen/OkButton')

// Steps
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

Mobile.waitForElementPresent(locationSettingsOpt, 10)
Mobile.tap(locationSettingsOpt, 0)
KeywordUtil.logInfo('Opened Location Settings')

// Verify Daytime Only Updates text
try {
	Mobile.verifyElementVisible(daytimeUpdatesText, 5)
	KeywordUtil.logInfo('Daytime Only Updates section verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Daytime Only Updates verification failed: ' + e.getMessage())
}

Mobile.waitForElementPresent(daytimeUpdatesText, 10)
Mobile.tap(daytimeUpdatesText, 0)
KeywordUtil.logInfo('Tapped Daytime Only Updates')

// Verify Set Daytime Range screen
try {
	Mobile.verifyElementVisible(setDaytimeRangeText, 5)
	KeywordUtil.logInfo('Set Daytime Range screen verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Set Daytime Range verification failed: ' + e.getMessage())
}

Mobile.waitForElementPresent(okButton, 10)
Mobile.tap(okButton, 0)
KeywordUtil.logInfo('Tapped OK button')

// Navigate back
Mobile.pressBack()
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')
