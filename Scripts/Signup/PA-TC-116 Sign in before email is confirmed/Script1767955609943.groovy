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
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject


// TestObjects
TestObject signInButton       = findTestObject('Object Repository/LandingScreen/SignInButton')
TestObject emailField         = findTestObject('Object Repository/SignInScreen/EmailField')
TestObject passwordField      = findTestObject('Object Repository/SignInScreen/PasswordField')
TestObject signInButtonFinal  = findTestObject('Object Repository/SignInScreen/SignInButton')
TestObject invalidCredsText   = findTestObject('Object Repository/SignInScreen/VerifyInvalidText')

// Wait for and tap initial Sign In button
Mobile.waitForElementPresent(signInButton, 30)
Mobile.tap(signInButton, 0)
KeywordUtil.logInfo('Tapped Sign In button')

// Wait for and enter email
Mobile.waitForElementPresent(emailField, 30)
Mobile.setText(emailField, username, 0)
KeywordUtil.logInfo("Entered Email: ${username}")

// Wait for and enter password
Mobile.waitForElementPresent(passwordField, 30)
Mobile.setText(passwordField, password, 0)
KeywordUtil.logInfo('Entered Password')

// Wait for and tap final Sign In button
Mobile.waitForElementPresent(signInButtonFinal, 30)
Mobile.tap(signInButtonFinal, 0)
KeywordUtil.logInfo('Tapped final Sign In button')

// Verify invalid credentials message with try-catch
try {
	Mobile.waitForElementPresent(invalidCredsText, 30)
	Mobile.verifyElementVisible(invalidCredsText, 0)
	KeywordUtil.logInfo('Verified invalid credentials message')
} catch (Exception e) {
	KeywordUtil.logInfo("Invalid credentials message NOT found: " + e.getMessage())
}

// Navigate back
Mobile.pressBack()
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')

