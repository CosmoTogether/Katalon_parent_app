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
import com.kms.katalon.core.model.FailureHandling

// Test Objects
TestObject menuButton         = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject homeItem           = findTestObject('Object Repository/HamburgerMenu/HomeTab')
TestObject myDevicesItem      = findTestObject('Object Repository/HamburgerMenu/MydevicesTab')
TestObject allContactsItem    = findTestObject('Object Repository/HamburgerMenu/ContactTab')
TestObject safeZonesItem      = findTestObject('Object Repository/HamburgerMenu/SafeZonesTab')
TestObject messagesItem       = findTestObject('Object Repository/HamburgerMenu/MessagesTab')
TestObject activityCenterItem = findTestObject('Object Repository/HamburgerMenu/ActivityCenterTab')
TestObject myAccountItem      = findTestObject('Object Repository/HamburgerMenu/MyAccountTab')
TestObject parentPortalText   = findTestObject('Object Repository/HamburgerMenu/ParentPortalTab')
TestObject appSettingsItem    = findTestObject('Object Repository/HamburgerMenu/AppSettingsTab')
TestObject supportItem        = findTestObject('Object Repository/HamburgerMenu/SupportTab')
TestObject signOutText        = findTestObject('Object Repository/HamburgerMenu/SignoutTab')

// Tap menu button
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
println 'Tapped menu button'

// Verify Home
Mobile.waitForElementPresent(homeItem, 10)
try {
	Mobile.verifyElementVisible(homeItem, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified Home item'
} catch (Exception e) {
	println 'Home item verification failed: ' + e.getMessage()
}

// Verify My Devices
Mobile.waitForElementPresent(myDevicesItem, 10)
try {
	Mobile.verifyElementVisible(myDevicesItem, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified My Devices item'
} catch (Exception e) {
	println 'My Devices verification failed: ' + e.getMessage()
}

// Verify All Contacts
Mobile.waitForElementPresent(allContactsItem, 10)
try {
	Mobile.verifyElementVisible(allContactsItem, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified All Contacts item'
} catch (Exception e) {
	println 'All Contacts verification failed: ' + e.getMessage()
}

// Verify SafeZones
Mobile.waitForElementPresent(safeZonesItem, 10)
try {
	Mobile.verifyElementVisible(safeZonesItem, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified SafeZones item'
} catch (Exception e) {
	println 'SafeZones verification failed: ' + e.getMessage()
}

// Verify Messages
Mobile.waitForElementPresent(messagesItem, 10)
try {
	Mobile.verifyElementVisible(messagesItem, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified Messages item'
} catch (Exception e) {
	println 'Messages verification failed: ' + e.getMessage()
}

// Verify Activity Center
Mobile.waitForElementPresent(activityCenterItem, 10)
try {
	Mobile.verifyElementVisible(activityCenterItem, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified Activity Center item'
} catch (Exception e) {
	println 'Activity Center verification failed: ' + e.getMessage()
}

// Verify My Account
Mobile.waitForElementPresent(myAccountItem, 10)
try {
	Mobile.verifyElementVisible(myAccountItem, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified My Account item'
} catch (Exception e) {
	println 'My Account verification failed: ' + e.getMessage()
}

// Verify Parent Portal
Mobile.waitForElementPresent(parentPortalText, 10)
try {
	Mobile.verifyElementVisible(parentPortalText, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified Parent Portal text'
} catch (Exception e) {
	println 'Parent Portal verification failed: ' + e.getMessage()
}

// Verify App Settings
Mobile.waitForElementPresent(appSettingsItem, 10)
try {
	Mobile.verifyElementVisible(appSettingsItem, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified App Settings item'
} catch (Exception e) {
	println 'App Settings verification failed: ' + e.getMessage()
}

// Verify Support
Mobile.waitForElementPresent(supportItem, 10)
try {
	Mobile.verifyElementVisible(supportItem, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified Support item'
} catch (Exception e) {
	println 'Support verification failed: ' + e.getMessage()
}

// Verify Sign Out
Mobile.waitForElementPresent(signOutText, 10)
try {
	Mobile.verifyElementVisible(signOutText, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified Sign Out text'
} catch (Exception e) {
	println 'Sign Out verification failed: ' + e.getMessage()
}

Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
println 'Tapped menu button'
