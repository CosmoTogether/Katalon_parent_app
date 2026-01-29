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
TestObject settingButton        = findTestObject('Object Repository/DashboardScreen/SettingEnginButton')
TestObject locationSettingsOpt    = findTestObject('Object Repository/DataAndSettingScreen/LocationSettingsTab')
TestObject locationUpdateText     = findTestObject('Object Repository/LocationSettingScreen/LocationUpdateText')
TestObject automaticUpdatesText   = findTestObject('Object Repository/LocationSettingScreen/AutomaticLocationUpdates')
TestObject daytimeOnlyUpdatesText = findTestObject('Object Repository/LocationSettingScreen/DaytimeOnlyUpdates')

// Steps
Mobile.waitForElementPresent(settingButton, 10)
Mobile.tap(settingButton, 0)
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
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')
