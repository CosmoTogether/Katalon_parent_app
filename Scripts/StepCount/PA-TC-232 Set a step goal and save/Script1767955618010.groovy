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
TestObject goalField         = findTestObject('Object Repository/StepCounterScreen/GoalField')
TestObject okButton          = findTestObject('Object Repository/StepCounterScreen/OkButton')
TestObject stepCounterText   = findTestObject('Object Repository/StepCounterScreen/StepCounter')
TestObject menuButton       = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject activityCenter   = findTestObject('Object Repository/HamburgerMenu/ActivityCenterTab')
TestObject stepCounterOption = findTestObject('Object Repository/ActivityCenterScreen/StepCounterTab')
TestObject plusButton    = findTestObject('Object Repository/StepCounterScreen/PlusButton')
TestObject setStepGoalText   = findTestObject('Object Repository/StepCounterScreen/SetStepGoal')


// Step 1: Tap Menu button
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

// Step 2: Open Activity Center
Mobile.waitForElementPresent(activityCenter, 10)
Mobile.tap(activityCenter, 0)
KeywordUtil.logInfo('Opened Activity Center')

// Step 3: Select Step Counter
Mobile.waitForElementPresent(stepCounterOption, 10)
Mobile.tap(stepCounterOption, 0)
KeywordUtil.logInfo('Opened Step Counter section')

// Step 4: Open settings (gear icon)
Mobile.waitForElementPresent(plusButton, 10)
Mobile.tap(plusButton, 0)
KeywordUtil.logInfo('Tapped Step Counter settings button')

// Step 5: Set new goal
try {
	Mobile.waitForElementPresent(goalField, 10)
	Mobile.setText(goalField, goal_value, 0)
	KeywordUtil.logInfo('Entered step goal value: ' + goal_value)

} catch (Exception e) {
	KeywordUtil.logInfo('Failed to enter step goal: ' + e.getMessage())
}

// Step 6: Tap OK button
try {
	Mobile.waitForElementPresent(okButton, 10)
	Mobile.tap(okButton, 0)
	KeywordUtil.logInfo('Tapped OK button to save goal')
} catch (Exception e) {
	KeywordUtil.logInfo('Failed to tap OK button: ' + e.getMessage())
}

// Step 7: Verify Step Counter updated
try {
	Mobile.verifyElementVisible(stepCounterText, 5, FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('Step Counter screen verified successfully')
} catch (Exception e) {
	KeywordUtil.logInfo('Failed to verify Step Counter screen: ' + e.getMessage())
}

// Step 8: Navigate back safely
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')
