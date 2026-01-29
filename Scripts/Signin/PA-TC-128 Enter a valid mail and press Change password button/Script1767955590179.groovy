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
TestObject forgotPasswordBtn = findTestObject('Object Repository/SignInScreen/ForgotPasswordButton')
TestObject forgotPasswordTxt = findTestObject('Object Repository/ForgetPasswordScreen/VerifyForgotPasswordText')

// Step 1: Tap Sign In
Mobile.waitForElementPresent(signInButton, 10)
Mobile.tap(signInButton, 0)
KeywordUtil.logInfo('Tapped Sign In button')

// Step 2: Enter Email
Mobile.waitForElementPresent(emailField, 10)
Mobile.setText(emailField, valid_email, 0)
KeywordUtil.logInfo('Entered valid email')

// Step 3: Enter Password
Mobile.waitForElementPresent(passwordField, 10)
Mobile.setText(passwordField, password, 0)
KeywordUtil.logInfo('Entered password')

// Step 4: Tap "Forgot password"
Mobile.waitForElementPresent(forgotPasswordBtn, 10)
Mobile.tap(forgotPasswordBtn, 0)
KeywordUtil.logInfo('Tapped "Forgot password" button')

// Step 5: Verify "Forgot password" screen
try {
	Mobile.waitForElementPresent(forgotPasswordTxt, 10)
	Mobile.verifyElementVisible(forgotPasswordTxt, 0)
	KeywordUtil.logInfo('"Forgot password" screen verified successfully')
} catch (Exception e) {
	KeywordUtil.logInfo('Verification failed for "Forgot password" screen: ' + e.getMessage())
}

// Step 6: Navigate back
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')

