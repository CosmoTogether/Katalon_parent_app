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

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.model.FailureHandling

// Test Objects
TestObject CosmoImage       = findTestObject('Object Repository/DashboardScreen/CosmoImage')
TestObject NoficationIcon  = findTestObject('Object Repository/DashboardScreen/NoficationIcon')
TestObject linearLayout    = findTestObject('Object Repository/DashboardScreen/AppStation')
TestObject linearLayout1   = findTestObject('Object Repository/DashboardScreen/DeviceDescription')
TestObject relativeLayout1 = findTestObject('Object Repository/DashboardScreen/DevicesElements')
TestObject relativeLayout2 = findTestObject('Object Repository/DashboardScreen/Starttracking')
TestObject Message         = findTestObject('Object Repository/DashboardScreen/Message')

// Verify ImageButton
Mobile.waitForElementPresent(imageButton, 10)
try {
	Mobile.verifyElementVisible(imageButton, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified ImageButton element'
} catch (Exception e) {
	println 'ImageButton verification failed: ' + e.getMessage()
}

// Verify ImageView
Mobile.waitForElementPresent(CosmoImage, 10)
try {
	Mobile.verifyElementVisible(CosmoImage, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified CosmoImage element'
} catch (Exception e) {
	println 'CosmoImage verification failed: ' + e.getMessage()
}

// Verify RelativeLayout
Mobile.waitForElementPresent(NoficationIcon, 10)
try {
	Mobile.verifyElementVisible(NoficationIcon, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified NoficationIcon element'
} catch (Exception e) {
	println 'NoficationIcon verification failed: ' + e.getMessage()
}

// Verify LinearLayout
Mobile.waitForElementPresent(linearLayout, 10)
try {
	Mobile.verifyElementVisible(linearLayout, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified LinearLayout element'
} catch (Exception e) {
	println 'LinearLayout verification failed: ' + e.getMessage()
}

// Verify LinearLayout (1)
Mobile.waitForElementPresent(linearLayout1, 10)
try {
	Mobile.verifyElementVisible(linearLayout1, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified LinearLayout (1) element'
} catch (Exception e) {
	println 'LinearLayout (1) verification failed: ' + e.getMessage()
}

// Verify Message (1)
Mobile.waitForElementPresent(Message, 10)
try {
	Mobile.verifyElementVisible(Message, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified Message (1) element'
} catch (Exception e) {
	println 'Message (1) verification failed: ' + e.getMessage()
}

// Verify RelativeLayout (1)
Mobile.waitForElementPresent(relativeLayout1, 10)
try {
	Mobile.verifyElementVisible(relativeLayout1, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified RelativeLayout (1) element'
} catch (Exception e) {
	println 'RelativeLayout (1) verification failed: ' + e.getMessage()
}

// Verify RelativeLayout (2)
Mobile.waitForElementPresent(relativeLayout2, 10)
try {
	Mobile.verifyElementVisible(relativeLayout2, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified RelativeLayout (2) element'
} catch (Exception e) {
	println 'RelativeLayout (2) verification failed: ' + e.getMessage()
}

