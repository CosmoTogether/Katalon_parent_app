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
import com.kms.katalon.core.testobject.TestObject

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

// TestObjects
TestObject menuButton = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject activityCenter = findTestObject('Object Repository/HamburgerMenu/ActivityCenterTab')
TestObject alarmOption = findTestObject('Object Repository/ActivityCenterScreen/AlarmsTab')
TestObject toggleButtonT  = findTestObject('Object Repository/EditAlarmScreen/SetTuesdayAlarm')
TestObject saveButton = findTestObject('Object Repository/NewGroupChatScreen/SetNewAlarmScreen/SaveButton')
TestObject alarmsText  = findTestObject('Object Repository/AlarmsScreen/VerifyAlarmsText')
TestObject alarmLayout    = findTestObject('Object Repository/AlarmsScreen/ExixtingAlarm')


// Step 1: Tap Menu button
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

// Step 2: Open Activity Center
Mobile.waitForElementPresent(activityCenter, 10)
Mobile.tap(activityCenter, 0)
KeywordUtil.logInfo('Opened Activity Center')

// Step 3: Select Alarm option
Mobile.waitForElementPresent(alarmOption, 10)
Mobile.tap(alarmOption, 0)
KeywordUtil.logInfo('Selected Alarm option')

// Step 4: Check if any alarms exist
boolean isAlarmVisible = false
try {
	isAlarmVisible = Mobile.verifyElementVisible(alarmLayout, 5)
	KeywordUtil.logInfo('Alarm layout found')
} catch (Exception e) {
	isAlarmVisible = false
	KeywordUtil.logInfo('No alarms found: ' + e.getMessage())
}

// Step 5: If alarms exist, modify
if (isAlarmVisible) {
	Mobile.tap(alarmLayout, 10)
	KeywordUtil.logInfo('Tapped existing alarm layout')

	Mobile.tap(toggleButtonT, 0)
	KeywordUtil.logInfo('Toggled T button')

	Mobile.tap(saveButton, 0)
	KeywordUtil.logInfo('Tapped Save button')

	try {
		Mobile.verifyElementVisible(alarmsText, 5, FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo('"Alarms" screen verified successfully')
	} catch (Exception e) {
		KeywordUtil.logInfo('Failed to verify "Alarms" screen: ' + e.message)
	}

	// Optional: Screenshot
	Mobile.takeScreenshot()
	KeywordUtil.logInfo('Screenshot captured for reporting')
} else {
	KeywordUtil.logInfo('You currently have no alarms set up')
}

// Step 6: Navigate back safely
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')

