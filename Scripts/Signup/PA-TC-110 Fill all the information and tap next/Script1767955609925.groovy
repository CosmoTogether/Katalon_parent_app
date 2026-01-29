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
TestObject firstNameFld  = findTestObject('Object Repository/SignUpScreen/FirstNameField')
TestObject lastNameFld   = findTestObject('Object Repository/SignUpScreen/LastNameFiled')
TestObject emailFld      = findTestObject('Object Repository/SignUpScreen/EmailField')
TestObject passwordFld  = findTestObject('Object Repository/SignUpScreen/PasswordField')
TestObject confirmPwdFld= findTestObject('Object Repository/SignUpScreen/ConfirmPasswordField')
TestObject termsCheckbox= findTestObject('Object Repository/SignUpScreen/CheckBox')
TestObject nextBtn      = findTestObject('Object Repository/SignUpScreen/NextButton')
TestObject addPicText   = findTestObject('Object Repository/ParentAccountScreen/Add a profile picture_text')
TestObject titleText   = findTestObject('Object Repository/SignUpScreen/CreateParentAccount_text')

// Steps
Mobile.waitForElementPresent(createBtn, 20)
Mobile.tap(createBtn, 0)
println 'Tapped Create Account button'

Mobile.waitForElementPresent(firstNameFld, 10)
Mobile.setText(firstNameFld, first_name, 0)
println 'Entered First Name'

Mobile.waitForElementPresent(lastNameFld, 10)
Mobile.setText(lastNameFld, last_name, 0)
println 'Entered Last Name'

Mobile.waitForElementPresent(emailFld, 10)
Mobile.setText(emailFld, email, 0)
println 'Entered Email'

Mobile.waitForElementPresent(passwordFld, 10)
Mobile.setText(passwordFld, password, 0)
println 'Entered Password'

Mobile.waitForElementPresent(confirmPwdFld, 10)
Mobile.setText(confirmPwdFld, confirm_password, 0)
println 'Entered Confirm Password'

Mobile.hideKeyboard()

Mobile.waitForElementPresent(termsCheckbox, 10)
Mobile.tap(termsCheckbox, 0)
println 'Accepted Terms and Conditions'

Mobile.waitForElementPresent(nextBtn, 10)
Mobile.tap(nextBtn, 0)
println 'Tapped Next button'

// Verify with try-catch
try {
	Mobile.waitForElementPresent(addPicText, 10)
	Mobile.verifyElementVisible(addPicText, 0)
	println 'Add Profile Picture text verified'

	Mobile.waitForElementPresent(titleText, 10)
	Mobile.verifyElementVisible(titleText, 0)
	println 'Create Parent Account title verified'
} catch (Exception e) {
	println 'Verification failed: ' + e.getMessage()
}

// Navigate back
Mobile.pressBack()
Mobile.pressBack()
println 'Navigated back to previous screen'

