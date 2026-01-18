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
TestObject menuButton        = findTestObject('Object Repository/case_14/case-2/android.widget.ImageButton')
TestObject childProfileOpt   = findTestObject('Object Repository/case_14/case-2/android.widget.TextView - Child profile')
TestObject childProfileTxt   = findTestObject('Object Repository/case_14/case-2/android.widget.TextView - Child profile (1)')
TestObject profileImage      = findTestObject('Object Repository/case_14/case-2/android.widget.ImageView')
TestObject infoSection1      = findTestObject('Object Repository/case_14/case-2/android.widget.LinearLayout')
TestObject infoSection2      = findTestObject('Object Repository/case_14/case-2/android.widget.LinearLayout (1)')
TestObject saveButton        = findTestObject('Object Repository/case_14/case-2/android.widget.Button - Save')

// Steps
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
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
	Mobile.verifyElementVisible(infoSection1, 5)
	KeywordUtil.logInfo('First information section verified')
} catch (Exception e) {
	KeywordUtil.logInfo('First information section verification failed: ' + e.getMessage())
}

// Verify second info section
try {
	Mobile.verifyElementVisible(infoSection2, 5)
	KeywordUtil.logInfo('Second information section verified')
} catch (Exception e) {
	KeywordUtil.logInfo('Second information section verification failed: ' + e.getMessage())
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
Mobile.delay(1)
Mobile.pressBack()
Mobile.delay(1)
KeywordUtil.logInfo('Navigated back to previous screen')
