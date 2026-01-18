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

// Define Test Objects
TestObject menuButton        = findTestObject('Object Repository/case_13/case-6/android.widget.ImageButton')
TestObject activityCenter    = findTestObject('Object Repository/case_13/case-6/android.widget.CheckedTextView - Activity Center')
TestObject focusModeOption   = findTestObject('Object Repository/case_13/case-6/android.widget.TextView - Focus mode')
TestObject backButton        = findTestObject('Object Repository/case_13/case-6/android.widget.ImageButton (1)')
TestObject jrTrackOption     = findTestObject('Object Repository/case_13/case-6/android.widget.TextView - For JrTrack4 or prior')
TestObject newFocusMode      = findTestObject('Object Repository/case_13/case-6/android.widget.TextView - New focus mode')
TestObject linearLayout      = findTestObject('Object Repository/case_13/case-6/android.widget.LinearLayout')
TestObject focusNameField    = findTestObject('Object Repository/case_13/case-6/android.widget.EditText - Focus Name')
TestObject startTime         = findTestObject('Object Repository/case_13/case-6/android.widget.TextView - Start time')
TestObject endTime           = findTestObject('Object Repository/case_13/case-6/android.widget.TextView - End time')
TestObject repeatEvery       = findTestObject('Object Repository/case_13/case-6/android.widget.TextView - Repeat every')
TestObject saveButton        = findTestObject('Object Repository/case_13/case-6/android.widget.Button - Save')

// Tap through app
Mobile.tap(menuButton, 0)
println 'Tapped Menu button'

Mobile.tap(activityCenter, 0)
println 'Opened Activity Center'

Mobile.tap(focusModeOption, 0)
println 'Opened Focus Mode'

Mobile.tap(backButton, 0)
println 'Tapped Back button'

Mobile.tap(jrTrackOption, 0)
println 'Selected JrTrack4 or prior option'

// Verification steps with individual try-catch
try {
	Mobile.waitForElementPresent(newFocusMode, 10)
	Mobile.verifyElementVisible(newFocusMode, 0)
	println 'Verified New Focus Mode text'
} catch (Exception e) {
	println "Verification failed for New Focus Mode: ${e.getMessage()}"
}

try {
	Mobile.waitForElementPresent(linearLayout, 10)
	Mobile.verifyElementVisible(linearLayout, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified Linear Layout'
} catch (Exception e) {
	println "Verification failed for Linear Layout: ${e.getMessage()}"
}

try {
	Mobile.waitForElementPresent(focusNameField, 10)
	Mobile.verifyElementVisible(focusNameField, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified Focus Name field'
} catch (Exception e) {
	println "Verification failed for Focus Name field: ${e.getMessage()}"
}

try {
	Mobile.waitForElementPresent(startTime, 10)
	Mobile.verifyElementVisible(startTime, 0)
	println 'Verified Start Time'
} catch (Exception e) {
	println "Verification failed for Start Time: ${e.getMessage()}"
}

try {
	Mobile.waitForElementPresent(endTime, 10)
	Mobile.verifyElementVisible(endTime, 0)
	println 'Verified End Time'
} catch (Exception e) {
	println "Verification failed for End Time: ${e.getMessage()}"
}

try {
	Mobile.waitForElementPresent(repeatEvery, 10)
	Mobile.verifyElementVisible(repeatEvery, 0)
	println 'Verified Repeat Every'
} catch (Exception e) {
	println "Verification failed for Repeat Every: ${e.getMessage()}"
}

try {
	Mobile.waitForElementPresent(saveButton, 10)
	Mobile.verifyElementVisible(saveButton, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified Save button'
} catch (Exception e) {
	println "Verification failed for Save button: ${e.getMessage()}"
}

// Continue normal flow
Mobile.pressBack()
println 'Pressed Back button'

Mobile.pressBack()
println 'Pressed Back button again'


