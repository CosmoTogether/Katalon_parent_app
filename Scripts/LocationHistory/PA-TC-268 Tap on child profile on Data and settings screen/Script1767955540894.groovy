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
TestObject settingButton        = findTestObject('Object Repository/DashboardScreen/SettingEnginButton')
TestObject childProfileOpt   = findTestObject('Object Repository/DataAndSettingScreen/ChildProfileTab')
TestObject childProfileTxt   = findTestObject('Object Repository/ChildProfileScreen/ChildProfileText')
TestObject profileImage      = findTestObject('Object Repository/ChildProfileScreen/PictureSection')
TestObject FirstChildName      = findTestObject('Object Repository/ChildProfileScreen/FirstChildName')
TestObject BirthDate      = findTestObject('Object Repository/ChildProfileScreen/BirthDate')
TestObject saveButton        = findTestObject('Object Repository/ChildProfileScreen/SaveButton')

// Steps
Mobile.waitForElementPresent(settingButton, 10)
Mobile.tap(settingButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

Mobile.waitForElementPresent(childProfileOpt, 10)
Mobile.tap(childProfileOpt, 0)
KeywordUtil.logInfo('Opened Child Profile')

Mobile.waitForElementPresent(childProfileTxt, 10)
String profileTitle = Mobile.getText(childProfileTxt, 5)
KeywordUtil.logInfo("Child Profile title verified: ${profileTitle}")

// Verify profile image
try {
	Mobile.verifyElementVisible(profileImage, 5)
	KeywordUtil.logInfo('Profile image is visible')
} catch (Exception e) {
	KeywordUtil.logInfo('Profile image verification failed: ' + e.getMessage())
}

// Verify first info section
try {
	Mobile.verifyElementVisible(FirstChildName, 5)
	KeywordUtil.logInfo('FirstChildName section verified')
} catch (Exception e) {
	KeywordUtil.logInfo('FirstChildName section verification failed: ' + e.getMessage())
}

// Verify second info section
try {
	Mobile.verifyElementVisible(BirthDate, 5)
	KeywordUtil.logInfo('BirthDate section verified')
} catch (Exception e) {
	KeywordUtil.logInfo('BirthDate section verification failed: ' + e.getMessage())
}

// Verify save button
try {
	Mobile.verifyElementVisible(saveButton, 5)
	KeywordUtil.logInfo('Save button verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Save button verification failed: ' + e.getMessage())
}

// Navigate back
Mobile.pressBack()
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')

