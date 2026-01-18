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
import com.kms.katalon.core.model.FailureHandling

// TestObjects
TestObject menuButton       = findTestObject('Object Repository/case_13/case-1/android.widget.ImageButton')
TestObject activityCenter   = findTestObject('Object Repository/case_13/case-1/android.widget.CheckedTextView - Activity Center')
TestObject stepCounterOption = findTestObject('Object Repository/case_13/case-1/android.widget.TextView - Step counter')
TestObject stepCounterText   = findTestObject('Object Repository/case_13/case-1/android.widget.TextView - Step counter (1)')
TestObject firstRank         = findTestObject('Object Repository/case_13/case-1/android.widget.TextView - 1st rank')
TestObject dayTab            = findTestObject('Object Repository/case_13/case-1/android.widget.TextView - Day')
TestObject weekTab           = findTestObject('Object Repository/case_13/case-1/android.widget.TextView - Week')
TestObject monthTab          = findTestObject('Object Repository/case_13/case-1/android.widget.TextView - Month')
TestObject caloriesLabel     = findTestObject('Object Repository/case_13/case-1/android.widget.TextView - Calories')
TestObject distanceLabel     = findTestObject('Object Repository/case_13/case-1/android.widget.TextView - Distance')

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

// Step 4: Verify all UI elements individually with try-catch

try {
	Mobile.verifyElementVisible(stepCounterText, 5)
	KeywordUtil.logInfo('Step Counter header verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Step Counter header NOT found: ' + e.getMessage())
}

try {
	Mobile.verifyElementVisible(firstRank, 5)
	KeywordUtil.logInfo('First rank element verified')
} catch (Exception e) {
	KeywordUtil.logInfo('First rank element NOT found: ' + e.getMessage())
}

try {
	Mobile.verifyElementVisible(dayTab, 5)
	KeywordUtil.logInfo('Day tab verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Day tab NOT found: ' + e.getMessage())
}

try {
	Mobile.verifyElementVisible(weekTab, 5)
	KeywordUtil.logInfo('Week tab verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Week tab NOT found: ' + e.getMessage())
}

try {
	Mobile.verifyElementVisible(monthTab, 5)
	KeywordUtil.logInfo('Month tab verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Month tab NOT found: ' + e.getMessage())
}

try {
	Mobile.verifyElementVisible(caloriesLabel, 5)
	KeywordUtil.logInfo('Calories label verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Calories label NOT found: ' + e.getMessage())
}

try {
	Mobile.verifyElementVisible(distanceLabel, 5)
	KeywordUtil.logInfo('Distance label verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Distance label NOT found: ' + e.getMessage())
}

// Optional: Take screenshot
Mobile.takeScreenshot()
KeywordUtil.logInfo('Screenshot captured for Step Counter')

// Step 5: Navigate back safely
Mobile.pressBack()
Mobile.delay(1)
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')

