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
TestObject daytimeUpdatesText   = findTestObject('Object Repository/LocationSettingScreen/DaytimeOnlyUpdates')
TestObject okButton             = findTestObject('Object Repository/LocationSettingScreen/OkButton')
TestObject saveButton           = findTestObject('Object Repository/LocationSettingScreen/SaveButton')

// Steps
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

Mobile.waitForElementPresent(locationSettingsOpt, 10)
Mobile.tap(locationSettingsOpt, 0)
KeywordUtil.logInfo('Opened Location Settings')

Mobile.waitForElementPresent(daytimeUpdatesText, 10)
Mobile.tap(daytimeUpdatesText, 0)
KeywordUtil.logInfo('Opened Daytime Only Updates')

// Swipe to adjust daytime range
long endTime = System.currentTimeMillis() + 3000
Random rand = new Random()
while (System.currentTimeMillis() < endTime) {
	int startX = 251 + rand.nextInt(85)
	int startY = 478 + rand.nextInt(64)
	int endX = startX
	int endY = startY - (50 + rand.nextInt(50))
	Mobile.swipe(startX, startY, endX, endY)
}
KeywordUtil.logInfo('Performed swipe to adjust daytime range')

// Tap OK
Mobile.waitForElementPresent(okButton, 10)
Mobile.tap(okButton, 5)
KeywordUtil.logInfo('Tapped OK button')

// Verify Save button
try {
	Mobile.verifyElementVisible(saveButton, 5)
	KeywordUtil.logInfo('Save button visible')
} catch (Exception e) {
	KeywordUtil.logInfo('Save button verification failed: ' + e.getMessage())
}

// Tap Save
Mobile.waitForElementPresent(saveButton, 10)
Mobile.tap(saveButton, 0)
KeywordUtil.logInfo('Tapped Save button')

// Navigate back
Mobile.pressBack()
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')
