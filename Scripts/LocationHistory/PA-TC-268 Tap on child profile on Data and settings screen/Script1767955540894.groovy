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

def tapAndLog(TestObject obj, String message, int timeout = 10) {
	Mobile.waitForElementPresent(obj, timeout)
	Mobile.tap(obj, 0)
	KeywordUtil.logInfo(message)
}

def verifyVisibleAndLog(TestObject obj, String message, int timeout = 5) {
	Mobile.verifyElementVisible(obj, timeout, FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo(message)
}

def getTextAndLog(TestObject obj, String label, int timeout = 5) {
	String text = Mobile.getText(obj, timeout)
	KeywordUtil.logInfo("${label}: ${text}")
	return text
}

TestObject menuButton        = findTestObject('Object Repository/case_14/case-2/android.widget.ImageButton')
TestObject childProfileOpt   = findTestObject('Object Repository/case_14/case-2/android.widget.TextView - Child profile')
TestObject childProfileTxt   = findTestObject('Object Repository/case_14/case-2/android.widget.TextView - Child profile (1)')
TestObject profileImage      = findTestObject('Object Repository/case_14/case-2/android.widget.ImageView')
TestObject infoSection1      = findTestObject('Object Repository/case_14/case-2/android.widget.LinearLayout')
TestObject infoSection2      = findTestObject('Object Repository/case_14/case-2/android.widget.LinearLayout (1)')
TestObject saveButton        = findTestObject('Object Repository/case_14/case-2/android.widget.Button - Save')

tapAndLog(menuButton, 'Tapped Menu button')

tapAndLog(childProfileOpt, 'Opened Child Profile')

getTextAndLog(childProfileTxt, 'Child Profile title verified')

verifyVisibleAndLog(profileImage, 'Profile image is visible')

verifyVisibleAndLog(infoSection1, 'First information section is visible')

verifyVisibleAndLog(infoSection2, 'Second information section is visible')

verifyVisibleAndLog(saveButton, 'Save button is visible')

Mobile.pressBack()
Mobile.delay(1)
Mobile.pressBack()
Mobile.delay(1)
KeywordUtil.logInfo('Navigated back to previous screen')

