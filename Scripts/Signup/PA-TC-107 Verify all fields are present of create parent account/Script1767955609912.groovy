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
TestObject createAccountBtn   = findTestObject('Object Repository/LandingScreen/CreateAccountButton')
TestObject titleText         = findTestObject('Object Repository/SignUpScreen/CreateParentAccount_text')
TestObject firstNameField   = findTestObject('Object Repository/SignUpScreen/FirstNameField')
TestObject lastNameField    = findTestObject('Object Repository/SignUpScreen/LastNameFiled')
TestObject emailField       = findTestObject('Object Repository/SignUpScreen/EmailField')
TestObject passwordField   = findTestObject('Object Repository/SignUpScreen/PasswordField')
TestObject confirmPassField= findTestObject('Object Repository/SignUpScreen/ConfirmPasswordField')
TestObject nextButton      = findTestObject('Object Repository/SignUpScreen/NextButton')

// Tap Create Account
Mobile.waitForElementPresent(createAccountBtn, 10)
Mobile.tap(createAccountBtn, 0)
println 'Tapped Create Account button'

// Verify Title
try {
	Mobile.waitForElementPresent(titleText, 10)
	Mobile.verifyElementVisible(titleText, 0)
	println 'Create Parent Account title verified'
} catch (Exception e) {
	println 'Title verification failed: ' + e.getMessage()
}

// Verify First Name field
try {
	Mobile.waitForElementPresent(firstNameField, 10)
	Mobile.verifyElementVisible(firstNameField, 0)
	println 'First Name field verified'
} catch (Exception e) {
	println 'First Name field not visible: ' + e.getMessage()
}

// Verify Last Name field
try {
	Mobile.waitForElementPresent(lastNameField, 10)
	Mobile.verifyElementVisible(lastNameField, 0)
	println 'Last Name field verified'
} catch (Exception e) {
	println 'Last Name field not visible: ' + e.getMessage()
}

// Verify Email field
try {
	Mobile.waitForElementPresent(emailField, 10)
	Mobile.verifyElementVisible(emailField, 0)
	println 'Email field verified'
} catch (Exception e) {
	println 'Email field not visible: ' + e.getMessage()
}

// Verify Password field
try {
	Mobile.waitForElementPresent(passwordField, 10)
	Mobile.verifyElementVisible(passwordField, 0)
	println 'Password field verified'
} catch (Exception e) {
	println 'Password field not visible: ' + e.getMessage()
}

// Verify Confirm Password field
try {
	Mobile.waitForElementPresent(confirmPassField, 10)
	Mobile.verifyElementVisible(confirmPassField, 0)
	println 'Confirm Password field verified'
} catch (Exception e) {
	println 'Confirm Password field not visible: ' + e.getMessage()
}

// Verify Next button
try {
	Mobile.waitForElementPresent(nextButton, 10)
	Mobile.verifyElementVisible(nextButton, 0)
	println 'Next button verified'
} catch (Exception e) {
	println 'Next button not visible: ' + e.getMessage()
}

// Navigate back
Mobile.pressBack()
println 'Navigated back to previous screen'
