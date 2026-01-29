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


// TestObjects
TestObject startTrackingBtn = findTestObject('Object Repository/DashboardScreen/Starttracking')
TestObject activeLiveTracking = findTestObject('Object Repository/DashboardScreen/ActiveLiveTracking')
TestObject confirmBtn = findTestObject('Object Repository/DashboardScreen/ConfirmTracking')
TestObject trackingTab = findTestObject('Object Repository/DashboardScreen/TrackingStarted')


// Start tracking and handle confirm button
Mobile.tap(startTrackingBtn, 0)

if (Mobile.waitForElementPresent(activeLiveTracking, 3, FailureHandling.OPTIONAL)) {
	Mobile.tap(confirmBtn, 0)
	println('Confirm button appeared')
} else {
	println('Confirm button does not appear')
}

// Tap on Tracking tab
if (Mobile.waitForElementPresent(trackingTab, 5)) {
	Mobile.verifyElementVisible(trackingTab, 0)
	println('Tracking tab is visible')

	Mobile.tap(trackingTab, 0)
	println('Tracking tab tapped successfully')
} else {
	println('Tracking tab is not visible. Cannot proceed.')
}


