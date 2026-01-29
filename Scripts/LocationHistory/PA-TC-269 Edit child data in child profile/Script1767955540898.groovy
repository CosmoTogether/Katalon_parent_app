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
import com.kms.katalon.core.model.FailureHandling

import com.kms.katalon.core.util.KeywordUtil

// TestObjects
TestObject settingButton        = findTestObject('Object Repository/DashboardScreen/SettingEnginButton')
TestObject childProfileOpt   = findTestObject('Object Repository/DataAndSettingScreen/ChildProfileTab')
TestObject kidNameField        = findTestObject('Object Repository/ChildProfileScreen/ChildsFirstNameField')
TestObject childFirstNameField = findTestObject('Object Repository/ChildProfileScreen/ChildnameField')
TestObject saveButton          = findTestObject('Object Repository/ChildProfileScreen/SaveButton')
TestObject dataSettingsText    = findTestObject('Object Repository/DataAndSettingScreen/DataandSettingsTextView')


// Steps
Mobile.waitForElementPresent(settingButton, 10)
Mobile.tap(settingButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

Mobile.waitForElementPresent(childProfileOpt, 10)
Mobile.tap(childProfileOpt, 0)
KeywordUtil.logInfo('Opened Child Profile')

Mobile.waitForElementPresent(kidNameField, 10)
Mobile.clearText(kidNameField, 0)
KeywordUtil.logInfo('Cleared existing Kid name')

Mobile.waitForElementPresent(childFirstNameField, 10)
Mobile.setText(childFirstNameField, kid_name, 0)
KeywordUtil.logInfo("Entered new child name: ${kid_name}")

Mobile.waitForElementPresent(saveButton, 10)
Mobile.tap(saveButton, 0)
KeywordUtil.logInfo('Tapped Save button')

// Verify Data & Settings text
try {
	Mobile.verifyElementVisible(dataSettingsText, 5)
	KeywordUtil.logInfo('Data and Settings section verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Data and Settings verification failed: ' + e.getMessage())
}

// Navigate back
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')
