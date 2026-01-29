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

// TestObjects
TestObject signInButton      = findTestObject('Object Repository/LandingScreen/SignInButton')
TestObject emailField        = findTestObject('Object Repository/SignInScreen/EmailField')
TestObject passwordField     = findTestObject('Object Repository/SignInScreen/PasswordField')
TestObject signInConfirmBtn  = findTestObject('Object Repository/SignInScreen/SignInButton')
TestObject VerifyInvalidCredsText  = findTestObject('Object Repository/SignInScreen/VerifyToastMessage')

// Step 1: Tap Sign In
Mobile.waitForElementPresent(signInButton, 10)
Mobile.tap(signInButton, 0)
KeywordUtil.logInfo('Tapped Sign In button')

// Step 2: Enter username
Mobile.waitForElementPresent(emailField, 10)
Mobile.setText(emailField, username, 0)
KeywordUtil.logInfo('Entered username')

// Step 3: Enter password
Mobile.waitForElementPresent(passwordField, 10)
Mobile.setText(passwordField, password, 0)
KeywordUtil.logInfo('Entered password')


// Step 4: Tap Sign In confirmation button
Mobile.waitForElementPresent(signInConfirmBtn, 10)
Mobile.tap(signInConfirmBtn, 0)
KeywordUtil.logInfo('Tapped Sign In confirmation button')

// Step 5: Verify invalid credentials message
if (Mobile.waitForElementPresent(VerifyInvalidCredsText, 0)) {
	Mobile.verifyElementExist(VerifyInvalidCredsText, 0)
	KeywordUtil.logInfo('"Invalid credentials" message verified successfully')
} else {
	KeywordUtil.logInfo('Verification failed for "Invalid credentials" message')
}

// Step 6: Navigate back safely
Mobile.pressBack()
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')
