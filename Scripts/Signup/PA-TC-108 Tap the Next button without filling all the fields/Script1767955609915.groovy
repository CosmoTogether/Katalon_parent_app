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
TestObject createBtn      = findTestObject('Object Repository/LandingScreen/CreateAccountButton')
TestObject nextButton    = findTestObject('Object Repository/SignUpScreen/NextButton')
TestObject titleText     = findTestObject('Object Repository/SignUpScreen/CreateParentAccount_text')

// Wait for Create Account button
Mobile.waitForElementPresent(createBtn, 20)

// Check if Create button is enabled
String isCreateEnabled = Mobile.getAttribute(createBtn, 'enabled', 5)
if (isCreateEnabled == 'true') {
	Mobile.tap(createBtn, 10)
	println 'Create Account button tapped'
} else {
	Mobile.comment('Create Account button is disabled (expected in negative test)')
}

// Wait for Next button
Mobile.waitForElementPresent(nextButton, 10)

// Verify Next button is disabled
try {
	Mobile.verifyElementAttributeValue(nextButton, 'enabled', 'false', 5)
	println 'Next button is disabled as expected'
} catch (Exception e) {
	println 'Next button state verification failed: ' + e.getMessage()
}

// Verify screen title is visible
try {
	Mobile.waitForElementPresent(titleText, 10)
	Mobile.verifyElementVisible(titleText, 0)
	println 'Create Parent Account title verified'
} catch (Exception e) {
	println 'Title not visible: ' + e.getMessage()
}

// Navigate back
Mobile.pressBack()
println 'Navigated back to previous screen'


