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

// TestObjects
TestObject menuButton       = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject allContactsItem  = findTestObject('Object Repository/HamburgerMenu/ContactTab')
TestObject addButton        = findTestObject('Object Repository/AllContactScreen/PlusButton')
TestObject firstNameField   = findTestObject('Object Repository/AddContactScreen/FirstNameField')
TestObject saveButton       = findTestObject('Object Repository/AddContactScreen/SaveButton')
TestObject addContactText   = findTestObject('Object Repository/AddContactScreen/VerifyAddContactText')

// Steps
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
println 'Tapped Menu button'

Mobile.waitForElementPresent(allContactsItem, 10)
Mobile.tap(allContactsItem, 0)
println 'Opened All contacts'

Mobile.waitForElementPresent(addButton, 10)
Mobile.tap(addButton, 0)
println 'Tapped Add Contact button'

Mobile.waitForElementPresent(firstNameField, 10)
Mobile.setText(firstNameField, first_name, 0)
println 'Entered First Name'

Mobile.waitForElementPresent(saveButton, 10)
Mobile.tap(saveButton, 0)
println 'Tapped Save button'

// Verify Add Contact screen with try-catch
try {
	Mobile.waitForElementPresent(addContactText, 10)
	Mobile.verifyElementVisible(addContactText, 0)
	println 'Success! Contact not saved'
} catch (Exception e) {
	println 'Verification failed: "Add Contact" screen not found - ' + e.getMessage()
}

// Navigate back
Mobile.pressBack()

