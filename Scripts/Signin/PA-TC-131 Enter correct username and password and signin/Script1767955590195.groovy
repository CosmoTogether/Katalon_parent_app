import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.util.KeywordUtil
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
TestObject signInBtn           = findTestObject('Object Repository/LandingScreen/SignInButton')
TestObject emailField          = findTestObject('Object Repository/SignInScreen/EmailField')
TestObject passwordField       = findTestObject('Object Repository/SignInScreen/PasswordField')
TestObject signInBtn2          = findTestObject('Object Repository/SignInScreen/SignInButton')
TestObject allowBtn            = findTestObject('Object Repository/DashboardScreen/AllowButton')
TestObject whileUsingAppBtn    = findTestObject('Object Repository/DashboardScreen/WhileUsingTheApp_Button')
TestObject VerifyImageButton         = findTestObject('Object Repository/DashboardScreen/MenuButton')

// Step 1: Tap Sign In
Mobile.waitForElementPresent(signInBtn, 10)
Mobile.tap(signInBtn, 0)
KeywordUtil.logInfo('Tapped Sign In button')

// Step 2: Enter Email
if (Mobile.waitForElementPresent(emailField, 5)) {
	Mobile.setText(emailField, username, 0)
	KeywordUtil.logInfo('Entered username/email')
} else {
	KeywordUtil.logInfo('Email field not visible')
}

// Step 3: Enter Password
if (Mobile.waitForElementPresent(passwordField, 5)) {
	Mobile.setText(passwordField, password, 0)
	KeywordUtil.logInfo('Entered password')
} else {
	KeywordUtil.logInfo('Password field not visible')
}

// Step 4: Tap Sign In again
Mobile.waitForElementPresent(signInBtn2, 10)
Mobile.tap(signInBtn2, 0)
KeywordUtil.logInfo('Tapped Sign In button again')

// Step 5: Tap Allow if visible
if (Mobile.waitForElementPresent(allowBtn, 5)) {
	Mobile.tap(allowBtn, 0)
	KeywordUtil.logInfo('Tapped Allow button')
} else {
	KeywordUtil.logInfo('Allow button not visible, skipping')
}

// Step 6: Tap "While using the app" if visible
if (Mobile.waitForElementPresent(whileUsingAppBtn, 5)) {
	Mobile.tap(whileUsingAppBtn, 0)
	KeywordUtil.logInfo('Tapped "While using the app" button')
} else {
	KeywordUtil.logInfo('"While using the app" button not visible, skipping')
}

// Step 7: Verify ImageButton exists
if (Mobile.waitForElementPresent(VerifyImageButton, 10)) {
	KeywordUtil.logInfo('ImageButton exists on the screen')
} else {
	KeywordUtil.logInfo('ImageButton does not exist or not visible')
}


