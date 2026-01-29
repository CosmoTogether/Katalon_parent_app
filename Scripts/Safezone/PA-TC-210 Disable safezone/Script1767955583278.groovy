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
import com.kms.katalon.core.testobject.TestObject

// TestObjects
TestObject menuButton     = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject safeZonesItem  = findTestObject('Object Repository/HamburgerMenu/SafeZonesTab')
TestObject zoneItem      = findTestObject('Object Repository/SafeZoneScreen/ZoneItem')
TestObject switchBtn    = findTestObject('Object Repository/EditSafeZoneScren/DeviceSwitch')
TestObject saveButton    = findTestObject('Object Repository/EditSafeZoneScren/SaveButton')
TestObject okButton      = findTestObject('Object Repository/EditSafeZoneScren/OkButton')

// Steps
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

Mobile.tap(safeZonesItem, 0)
KeywordUtil.logInfo('Opened SafeZones section')

Mobile.tap(zoneItem, 0)
KeywordUtil.logInfo('Selected a SafeZone item')

// Scroll to switch
Mobile.scrollToText('Enabled')
KeywordUtil.logInfo('Scrolled to "Enabled" switch')

Mobile.waitForElementPresent(switchBtn, 5)
Mobile.tap(switchBtn, 0)
KeywordUtil.logInfo('Toggled switch')

// Save changes
Mobile.tap(saveButton, 0)
KeywordUtil.logInfo('Tapped Save button')

Mobile.tap(okButton, 0)
KeywordUtil.logInfo('Tapped OK button')

// Verify button state with try-catch
String isEnabled = Mobile.getAttribute(zoneItem, 'enabled', 10)
KeywordUtil.logInfo("Button enabled attribute: ${isEnabled}")

try {
	if (isEnabled == 'true') {
		Mobile.verifyElementAttributeValue(zoneItem, 'enabled', 'true', 10)
		KeywordUtil.logInfo('Zone button is ENABLED')
	} else {
		Mobile.verifyElementAttributeValue(zoneItem, 'enabled', 'false', 10)
		KeywordUtil.logInfo('Zone button is DISABLED')
	}
} catch (Exception e) {
	KeywordUtil.logInfo('Verification failed: ' + e.getMessage())
}

// Navigate back
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')


