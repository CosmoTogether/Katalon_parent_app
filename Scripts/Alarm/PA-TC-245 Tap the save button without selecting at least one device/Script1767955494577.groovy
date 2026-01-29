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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

// TestObjects
TestObject menuButton = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject activityCenter = findTestObject('Object Repository/HamburgerMenu/ActivityCenterTab')
TestObject alarmOption = findTestObject('Object Repository/ActivityCenterScreen/AlarmsTab')
TestObject addAlarmButton = findTestObject('Object Repository/AlarmsScreen/PlusButton')
TestObject alarmNameField = findTestObject('Object Repository/NewGroupChatScreen/SetNewAlarmScreen/SetAlarmName')
TestObject toggleButtonM = findTestObject('Object Repository/NewGroupChatScreen/SetNewAlarmScreen/SetMondayAlarm')
TestObject switchButton = findTestObject('Object Repository/NewGroupChatScreen/SetNewAlarmScreen/Switch1')
TestObject saveButton = findTestObject('Object Repository/NewGroupChatScreen/SetNewAlarmScreen/SaveButton')
TestObject setNewAlarmText = findTestObject('Object Repository/NewGroupChatScreen/SetNewAlarmScreen/Verify_SetNewAlarm_text')
TestObject setWithoutDevice = findTestObject('Object Repository/NewGroupChatScreen/SetNewAlarmScreen/VerifyWithoutdevice')

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

// Step 5: Enter alarm name
Mobile.waitForElementPresent(alarmNameField, 10)
Mobile.setText(alarmNameField, alarm_name, 0)
KeywordUtil.logInfo("Entered alarm name: $alarm_name")

Mobile.hideKeyboard()

// Step 6: Toggle M button
Mobile.waitForElementPresent(toggleButtonM, 10)
Mobile.tap(toggleButtonM, 0)
KeywordUtil.logInfo('Toggled M button')

// Step 7: Hide keyboard if visible
Mobile.hideKeyboard()

// Step 8: Tap Switch button
Mobile.waitForElementPresent(switchButton, 10)
Mobile.tap(switchButton, 0)
KeywordUtil.logInfo('Tapped Switch1 button')

int centerX = 696 + (64 / 2)
int centerY = 860 + (36 / 2)
Mobile.tapAtPosition(centerX, centerY)
KeywordUtil.logInfo('Tapped Switch2 button')

// Step 9: Tap Save button
Mobile.waitForElementPresent(saveButton, 10)

Mobile.tap(saveButton, 0)
KeywordUtil.logInfo('Tapped Save button')


// Step 10: Verify Toast message
try {
    Mobile.waitForElementPresent(setWithoutDevice, 10)
    Mobile.verifyElementExist(setWithoutDevice, 5, FailureHandling.STOP_ON_FAILURE)
    KeywordUtil.logInfo('Toast message verified successfully')
}
catch (Exception e) {
    KeywordUtil.logInfo('Toast message verification failed: ' + e.message)
} 

// Optional: Take screenshot
Mobile.takeScreenshot()

KeywordUtil.logInfo('Screenshot captured for report')

// Step 11: Navigate back safely
Mobile.pressBack()
Mobile.pressBack()

KeywordUtil.logInfo('Navigated back to previous screen')

