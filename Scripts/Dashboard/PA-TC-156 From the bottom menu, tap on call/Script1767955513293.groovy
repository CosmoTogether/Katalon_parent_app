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
TestObject imageViewButton = findTestObject('Object Repository/DashboardScreen/Call')
TestObject allowButton    = findTestObject('Object Repository/DashboardScreen/AllowButton')
TestObject warningText    = findTestObject('Object Repository/DashboardScreen/VerifyText_ok')
TestObject okButton    = findTestObject('Object Repository/DashboardScreen/OkCallButton')

// Step 1: Tap on ImageView
Mobile.waitForElementPresent(imageViewButton, 10)
Mobile.tap(imageViewButton, 0)
println 'Tapped ImageView button to initiate call action'


// Step 2: Handle Allow permission popup (if shown)
if (Mobile.waitForElementPresent(allowButton, 5, FailureHandling.OPTIONAL)) {
	Mobile.tap(allowButton, 0)
	println 'Allow button was visible and tapped successfully'
} else {
	println 'Allow button not visible. Permission already granted or popup not shown'
}


// Step 3: Validate warning message (if shown)
if (Mobile.waitForElementPresent(warningText, 5, FailureHandling.OPTIONAL)) {
	Mobile.verifyElementVisible(warningText, 0, FailureHandling.OPTIONAL)
	println 'Warning message displayed: Call & text on other devices is OFF'
} else {
	println 'No warning message displayed'
}


// Step 4: Handle OK button (THIS IS WHAT YOU ASKED)
if (Mobile.waitForElementPresent(okButton, 5, FailureHandling.OPTIONAL)) {
	Mobile.tap(okButton, 0)
	println 'OK button was visible and tapped'
} else {
	println 'OK button not visible. Proceeding without clicking'
}


// Optional back navigation for cleanup
Mobile.pressBack()
println 'Navigated back after call validation'
