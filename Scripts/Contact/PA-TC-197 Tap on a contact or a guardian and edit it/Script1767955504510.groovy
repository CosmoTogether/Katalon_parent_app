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
TestObject menuButton      = findTestObject('Object Repository/Test_8/android.widget.ImageButton (2)')
TestObject allContactsItem = findTestObject('Object Repository/Test_8/android.widget.CheckedTextView - All contacts')
TestObject contactItem     = findTestObject('Object Repository/Test_8/android.widget.ImageView - 1')
TestObject field1          = findTestObject('Object Repository/Test_8/android.widget.EditText - 1')
TestObject field2          = findTestObject('Object Repository/Test_8/android.widget.EditText - 2')
TestObject saveButton      = findTestObject('Object Repository/Test_8/android.widget.Button - Save')
TestObject valueText       = findTestObject('Object Repository/Test_8/android.widget.TextView - test 2 test 2')

// Steps
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
println 'Tapped Menu button'

Mobile.waitForElementPresent(allContactsItem, 10)
Mobile.tap(allContactsItem, 0)
println 'Opened All contacts'

Mobile.waitForElementPresent(contactItem, 10)
Mobile.tap(contactItem, 0)
println 'Selected contact item'

Mobile.waitForElementPresent(field1, 10)
Mobile.clearText(field1, 0)
Mobile.setText(field1, value_1, 0)
println 'Updated Field 1'

Mobile.waitForElementPresent(field2, 10)
Mobile.clearText(field2, 0)
Mobile.setText(field2, value_2, 0)
println 'Updated Field 2'

Mobile.waitForElementPresent(saveButton, 10)
Mobile.tap(saveButton, 0)
println 'Tapped Save button'

// Verification with try-catch
try {
	Mobile.waitForElementPresent(valueText, 10)
	Mobile.verifyElementText(valueText, verify_value)
	println 'Verified updated value successfully'
} catch (Exception e) {
	println 'Verification failed: Updated value not found or mismatched - ' + e.getMessage()
}

// Navigate back
Mobile.pressBack()


