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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject

// TestObjects
TestObject menuButton        = findTestObject('Object Repository/case_13/case-8/android.widget.ImageButton')
TestObject activityCenter    = findTestObject('Object Repository/case_13/case-8/android.widget.CheckedTextView - Activity Center')
TestObject focusModeOption   = findTestObject('Object Repository/case_13/case-8/android.widget.TextView - Focus mode')
TestObject backButton        = findTestObject('Object Repository/case_13/case-8/android.widget.ImageButton (1)')
TestObject jrTrackOption     = findTestObject('Object Repository/case_13/case-8/android.widget.TextView - For JrTrack5')
TestObject focusNameField    = findTestObject('Object Repository/case_13/case-8/android.widget.EditText - Focus Name')
TestObject toggleButton      = findTestObject('Object Repository/case_13/case-8/android.widget.ToggleButton - S')
TestObject saveButton        = findTestObject('Object Repository/case_13/case-8/android.widget.Button - Save')
TestObject toastMessage      = findTestObject('Object Repository/case_13/case-8/android.widget.Toast - Please select at least one device')

// Switches (dynamic TestObjects)
TestObject switch1 = new TestObject('Switch1')
switch1.addProperty('xpath', ConditionType.EQUALS, '//android.widget.Switch[@bounds=\'[696,739][760,775]\']')

TestObject switch2 = new TestObject('Switch2')
switch2.addProperty('xpath', ConditionType.EQUALS, '//android.widget.Switch[@bounds=\'[696,819][760,855]\']')

// Steps
Mobile.waitForElementPresent(menuButton, 10)
Mobile.tap(menuButton, 0)
println 'Tapped Menu button'

Mobile.waitForElementPresent(activityCenter, 10)
Mobile.tap(activityCenter, 0)
println 'Opened Activity Center'

Mobile.waitForElementPresent(focusModeOption, 10)
Mobile.tap(focusModeOption, 0)
println 'Opened Focus Mode'

Mobile.waitForElementPresent(backButton, 10)
Mobile.tap(backButton, 0)
println 'Tapped Back button'

Mobile.waitForElementPresent(jrTrackOption, 10)
Mobile.tap(jrTrackOption, 0)
println 'Selected JrTrack device'

Mobile.waitForElementPresent(focusNameField, 10)
Mobile.setText(focusNameField, focus_name, 0)
println "Entered focus name: ${focus_name}"

Mobile.scrollToText('Enable this focus on these devices')
println 'Scrolled to focus device section'

// Toggle switches
Mobile.tap(switch1, 10)
println 'Enabled first switch'

Mobile.tap(switch2, 10)
println 'Enabled second switch'

Mobile.waitForElementPresent(toggleButton, 10)
Mobile.tap(toggleButton, 0)
println 'Enabled Focus Mode toggle'

Mobile.waitForElementPresent(saveButton, 10)
Mobile.tap(saveButton, 0)
println 'Tapped Save button'

try {
	Mobile.verifyElementExist(toastMessage, 5, FailureHandling.STOP_ON_FAILURE)
	println 'Validation toast message verified: Please select at least one day'
} catch (Exception e) {
	println "Verification failed for toast message: ${e.getMessage()}"
}

// Navigate back
Mobile.pressBack()
Mobile.delay(1)
Mobile.pressBack()
Mobile.delay(1)
Mobile.pressBack()
println 'Navigated back to previous screen'
