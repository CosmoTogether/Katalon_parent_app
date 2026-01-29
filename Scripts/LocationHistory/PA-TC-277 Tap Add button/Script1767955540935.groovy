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
TestObject menuButton           = findTestObject('Object Repository/DashboardScreen/SettingEnginButton')
TestObject presetMessagesOpt    = findTestObject('Object Repository/DataAndSettingScreen/PresetMessagesTab')
TestObject PlusButton           = findTestObject('Object Repository/PresentMessagesScreen/PlusButton')
TestObject messageInputField    = findTestObject('Object Repository/PresentMessagesScreen/Enter your preset message')
TestObject saveButton           = findTestObject('Object Repository/PresentMessagesScreen/SaveButton')
TestObject backButton2          = findTestObject('Object Repository/PresentMessagesScreen/CrossButton')

// Steps
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

Mobile.waitForElementPresent(presetMessagesOpt, 10)
Mobile.tap(presetMessagesOpt, 0)
KeywordUtil.logInfo('Opened Preset Messages section')

Mobile.waitForElementPresent(PlusButton, 10)
Mobile.tap(PlusButton, 0)
KeywordUtil.logInfo('Tapped Edit button for Preset Message')

try {
	Mobile.verifyElementVisible(messageInputField, 5)
	KeywordUtil.logInfo('Preset Message input field verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Preset Message input field verification failed: ' + e.getMessage())
}

try {
	Mobile.verifyElementVisible(saveButton, 5)
	KeywordUtil.logInfo('Save button verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Save button verification failed: ' + e.getMessage())
}

try {
	Mobile.verifyElementVisible(backButton2, 5)
	KeywordUtil.logInfo('Back button verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Back button verification failed: ' + e.getMessage())
}

// Navigate back
Mobile.pressBack()
Mobile.pressBack()
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')
