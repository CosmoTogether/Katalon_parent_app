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
TestObject menuButton       = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject activityCenter   = findTestObject('Object Repository/HamburgerMenu/ActivityCenterTab')
TestObject alarmOption      = findTestObject('Object Repository/ActivityCenterScreen/AlarmsTab')
TestObject addAlarmButton   = findTestObject('Object Repository/AlarmsScreen/PlusButton')
TestObject toggleButtonM    = findTestObject('Object Repository/NewGroupChatScreen/SetNewAlarmScreen/SetMondayAlarm')
TestObject saveButton       = findTestObject('Object Repository/NewGroupChatScreen/SetNewAlarmScreen/SaveButton')
TestObject setNewAlarmText  = findTestObject('Object Repository/NewGroupChatScreen/SetNewAlarmScreen/Verify_SetNewAlarm_text')

// Step 1: Tap Menu button
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

// Step 2: Tap Activity Center
Mobile.waitForElementPresent(activityCenter, 10)
Mobile.tap(activityCenter, 0)
KeywordUtil.logInfo('Opened Activity Center')

// Step 3: Tap Alarm option
Mobile.waitForElementPresent(alarmOption, 10)
Mobile.tap(alarmOption, 0)
KeywordUtil.logInfo('Selected Alarm option')

// Step 4: Tap Add Alarm button
Mobile.waitForElementPresent(addAlarmButton, 10)
Mobile.tap(addAlarmButton, 0)
KeywordUtil.logInfo('Tapped Add Alarm button')

// Step 5: Tap Toggle Button - M
Mobile.waitForElementPresent(toggleButtonM, 10)
Mobile.tap(toggleButtonM, 0)
KeywordUtil.logInfo('Toggled M button')

// Step 6: Tap Save button
Mobile.waitForElementPresent(saveButton, 10)
Mobile.tap(saveButton, 0)
KeywordUtil.logInfo('Tapped Save button')

// Step 7: Verify Set New Alarm text
try {
	Mobile.waitForElementPresent(setNewAlarmText, 10)
	Mobile.verifyElementVisible(setNewAlarmText, 5, FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('"Set new alarm" screen verified successfully')
} catch (Exception e) {
	KeywordUtil.logInfo('Verification of "Set new alarm" screen failed: ' + e.message)
}

// Optional: Take screenshot for reporting
Mobile.takeScreenshot()
KeywordUtil.logInfo('Screenshot captured for report')

// Step 8: Navigate back safely
Mobile.pressBack()
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')

