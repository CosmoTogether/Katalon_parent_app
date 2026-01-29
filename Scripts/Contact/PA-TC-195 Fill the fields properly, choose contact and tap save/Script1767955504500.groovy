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
import com.kms.katalon.core.testobject.TestObject

// TestObjects
TestObject menuButton       = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject allContactsItem  = findTestObject('Object Repository/HamburgerMenu/ContactTab')
TestObject addButton        = findTestObject('Object Repository/AllContactScreen/PlusButton')
TestObject firstNameField   = findTestObject('Object Repository/AddContactScreen/FirstNameField')
TestObject lastNameField       = findTestObject('Object Repository/AddContactScreen/LastNameField')
TestObject phoneNumberField    = findTestObject('Object Repository/AddContactScreen/PhoneNumberField')
TestObject contactRadioButton  = findTestObject('Object Repository/AddContactScreen/ContactAccount')
TestObject saveButton       = findTestObject('Object Repository/AddContactScreen/SaveButton')
TestObject doneButton          = findTestObject('Object Repository/AllContactScreen/DoneButton')
TestObject allContactsText     = findTestObject('Object Repository/AllContactScreen/VerifyAllContactText')

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

Mobile.waitForElementPresent(lastNameField, 10)
Mobile.setText(lastNameField, last_name, 0)
println 'Entered Last Name'

Mobile.hideKeyboard()

// Generate random phone number
String randomPhone = '3' + Math.abs(new Random().nextInt() % 1000000000).toString().padLeft(9, '0')
Mobile.waitForElementPresent(phoneNumberField, 10)
Mobile.setText(phoneNumberField, randomPhone, 0)
println 'Entered Phone Number'

Mobile.hideKeyboard()

Mobile.waitForElementPresent(contactRadioButton, 10)
Mobile.tap(contactRadioButton, 0)
println 'Selected Contact radio button'

Mobile.waitForElementPresent(saveButton, 10)
Mobile.tap(saveButton, 0)
println 'Tapped Save button'

Mobile.waitForElementPresent(doneButton, 10)
Mobile.tap(doneButton, 0)
println 'Tapped DONE button'

// Verify All contacts text with try-catch
try {
    Mobile.waitForElementPresent(allContactsText, 10)
    Mobile.verifyElementText(allContactsText, verify_contact_text)
    KeywordUtil.logInfo('"All contacts" text verified successfully')
} catch (Exception e) {
    KeywordUtil.markFailedAndStop('Verification failed: "All contacts" text not found or mismatched - ' + e.getMessage())
}

// Navigate back
Mobile.pressBack()


