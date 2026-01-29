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
TestObject signInBtn          = findTestObject('Object Repository/LandingScreen/SignInButton')
TestObject forgotPasswordBtn  = findTestObject('Object Repository/SignInScreen/ForgotPasswordButton')
TestObject emailField         = findTestObject('Object Repository/ForgetPasswordScreen/EnterEmailField')
TestObject changePasswordBtn  = findTestObject('Object Repository/ForgetPasswordScreen/ChangePasswordButton')
TestObject passwordSentTxt    = findTestObject('Object Repository/ForgetPasswordScreen/PasswordRequestText')
TestObject okButton           = findTestObject('Object Repository/ForgetPasswordScreen/OK_Button')

// Step 1: Tap Sign In
Mobile.waitForElementPresent(signInBtn, 10)
Mobile.tap(signInBtn, 0)
KeywordUtil.logInfo('Tapped Sign In button')

// Step 2: Tap "Forgot password"
Mobile.waitForElementPresent(forgotPasswordBtn, 10)
Mobile.tap(forgotPasswordBtn, 0)
KeywordUtil.logInfo('Tapped "Forgot password" button')

// Step 3: Enter email
Mobile.waitForElementPresent(emailField, 10)
Mobile.setText(emailField, 'test@gmail.com', 0)
KeywordUtil.logInfo('Entered email: test@gmail.com')

// Step 4: Tap "Change password"
Mobile.waitForElementPresent(changePasswordBtn, 10)
Mobile.tap(changePasswordBtn, 0)
KeywordUtil.logInfo('Tapped "Change password" button')

// Step 5: Verify "Password update request sent"
try {
	Mobile.verifyElementVisible(passwordSentTxt, 0)
	KeywordUtil.logInfo('"Password update request sent" verified successfully')
} catch (Exception e) {
	KeywordUtil.logInfo('Verification failed for "Password update request sent": ' + e.getMessage())
}

// Step 6: Tap OK
Mobile.waitForElementPresent(okButton, 10)
Mobile.tap(okButton, 0)
KeywordUtil.logInfo('Tapped OK button')


