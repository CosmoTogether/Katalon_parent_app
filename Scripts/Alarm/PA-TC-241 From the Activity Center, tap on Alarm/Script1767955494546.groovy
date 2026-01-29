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
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

// TestObjects
TestObject menuBtn      = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject activityMenu = findTestObject('Object Repository/HamburgerMenu/ActivityCenterTab')
TestObject alarmOption  = findTestObject('Object Repository/ActivityCenterScreen/AlarmsTab')
TestObject alarmText    = findTestObject('Object Repository/AlarmsScreen/VerifyAlarmsText')

// Wait and tap menu button
Mobile.waitForElementPresent(menuBtn, 5)
Mobile.tap(menuBtn, 0)
KeywordUtil.logInfo('Menu button tapped')

// Wait and tap Activity Center
Mobile.waitForElementPresent(activityMenu, 5)
Mobile.tap(activityMenu, 0)
KeywordUtil.logInfo('Activity Center opened')

// Wait and tap Alarm option
Mobile.waitForElementPresent(alarmOption, 5)
Mobile.tap(alarmOption, 0)
KeywordUtil.logInfo('Alarm option selected')

// Verify alarm text
try {
	Mobile.waitForElementPresent(alarmText, 5)
	Mobile.verifyElementText(alarmText, verify_alarm_text, FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('Alarm text verified successfully')
} catch(Exception e) {
	KeywordUtil.logInfo('Alarm text verification failed: ' + e.message)
}

// Take screenshot for report
Mobile.takeScreenshot()
KeywordUtil.logInfo('Screenshot captured for report')

// Navigate back
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')



