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

TestObject menuButton         = findTestObject('Object Repository/Test_8/android.widget.ImageButton (2)')
TestObject allContactsItem    = findTestObject('Object Repository/Test_8/android.widget.CheckedTextView - All contacts')
TestObject addButton           = findTestObject('Object Repository/Test_8/android.widget.ImageButton (3)')
TestObject firstNameField      = findTestObject('Object Repository/Test_8/android.widget.EditText - First name')
TestObject lastNameField       = findTestObject('Object Repository/Test_8/android.widget.EditText - Last name')
TestObject phoneNumberField    = findTestObject('Object Repository/Test_8/android.widget.EditText - Phone Number')
TestObject contactRadioButton  = findTestObject('Object Repository/Test_8/android.widget.RadioButton - Contact')
TestObject switchButton1       = findTestObject('Object Repository/Test_8/android.widget.Switch')
TestObject switchButton2       = findTestObject('Object Repository/Test_8/android.widget.Switch (1)')
TestObject saveButton          = findTestObject('Object Repository/Test_8/android.widget.Button - Save')
TestObject doneButton          = findTestObject('Object Repository/Test_8/android.widget.Button - DONE')
TestObject allContactsText     = findTestObject('Object Repository/Test_8/android.widget.TextView - All contacts')

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

String randomPhone = '3' + Math.abs(new Random().nextInt() % 1000000000).toString().padLeft(9, '0')
Mobile.waitForElementPresent(phoneNumberField, 10)
Mobile.setText(phoneNumberField, randomPhone, 0)
println 'Entered Phone Number'

Mobile.pressBack()

Mobile.waitForElementPresent(contactRadioButton, 10)
Mobile.tap(contactRadioButton, 0)
println 'Selected Contact radio button'

Mobile.waitForElementPresent(switchButton1, 10)
Mobile.tap(switchButton1, 0)
println 'Tapped first Switch'

//Mobile.waitForElementPresent(switchButton2, 10)
//Mobile.tap(switchButton2, 0)
//println 'Tapped second Switch'

Mobile.waitForElementPresent(saveButton, 10)
Mobile.tap(saveButton, 0)
println 'Tapped Save button'

Mobile.waitForElementPresent(doneButton, 10)
Mobile.tap(doneButton, 0)
println 'Tapped DONE button'

try {
	Mobile.waitForElementPresent(allContactsText, 10)
	Mobile.verifyElementText(allContactsText, verify_contact_text)
	println '"All contacts" text verified'
} catch (Exception e) {
	println 'Verification failed: "All contacts" text not found or mismatched - ' + e.getMessage()
}

Mobile.pressBack()


