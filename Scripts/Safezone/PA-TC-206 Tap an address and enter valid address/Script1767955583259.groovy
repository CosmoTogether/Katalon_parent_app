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
TestObject addButton        = findTestObject('Object Repository/SafeZoneScreen/plusButton')
TestObject addressFieldOld  = findTestObject('Object Repository/NewSafeZoneScreen/Address - MXWF92F Street 101A, Islamabad')
TestObject addressFieldNew  = findTestObject('Object Repository/NewSafeZoneScreen/Enter Address')

// Steps
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

Mobile.tap(safeZonesItem, 0)
KeywordUtil.logInfo('Opened SafeZones')

Mobile.tap(addButton, 0)
KeywordUtil.logInfo('Tapped Add button to update SafeZone')

try {
	Mobile.clearText(addressFieldOld, 0)
	KeywordUtil.logInfo('Cleared old address')
} catch (Exception e) {
	KeywordUtil.logInfo('Could not clear old address: ' + e.getMessage())
}

try {
	Mobile.setText(addressFieldNew, address, 0)
	KeywordUtil.logInfo("Entered new address: ${address}")
} catch (Exception e) {
	KeywordUtil.logInfo('Could not set new address: ' + e.getMessage())
}

// Navigate back
Mobile.pressBack()
Mobile.pressBack()
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')

