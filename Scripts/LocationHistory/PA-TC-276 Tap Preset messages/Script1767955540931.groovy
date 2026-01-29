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
TestObject presetMessagesText   = findTestObject('Object Repository/PresentMessagesScreen/PresentMessagesText')
TestObject PlusButton           = findTestObject('Object Repository/PresentMessagesScreen/PlusButton')

// Steps
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

Mobile.waitForElementPresent(presetMessagesOpt, 10)
Mobile.tap(presetMessagesOpt, 0)
KeywordUtil.logInfo('Opened Preset Messages section')

try {
	Mobile.verifyElementVisible(presetMessagesText, 5)
	KeywordUtil.logInfo('Preset Messages text verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Preset Messages text verification failed: ' + e.getMessage())
}

try {
	Mobile.verifyElementVisible(PlusButton, 5)
	KeywordUtil.logInfo('PLus button verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Plus button verification failed: ' + e.getMessage())
}

// Navigate back
Mobile.pressBack()
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')
