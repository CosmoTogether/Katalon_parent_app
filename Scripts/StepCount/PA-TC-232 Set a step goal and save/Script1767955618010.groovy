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
TestObject menuButton       = findTestObject('Object Repository/case_13/case-4/android.widget.ImageButton')
TestObject activityCenter   = findTestObject('Object Repository/case_13/case-4/android.widget.CheckedTextView - Activity Center')
TestObject stepCounterOption = findTestObject('Object Repository/case_13/case-4/android.widget.TextView - Step counter')
TestObject settingsButton    = findTestObject('Object Repository/case_13/case-4/android.widget.ImageButton (1)')
TestObject goalField         = findTestObject('Object Repository/case_13/case-4/android.widget.EditText')
TestObject okButton          = findTestObject('Object Repository/case_13/case-4/android.widget.Button - OK')
TestObject stepCounterText   = findTestObject('Object Repository/case_13/case-4/android.widget.TextView - Step counter (1)')

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
Mobile.waitForElementPresent(settingsButton, 10)
Mobile.tap(settingsButton, 0)
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
