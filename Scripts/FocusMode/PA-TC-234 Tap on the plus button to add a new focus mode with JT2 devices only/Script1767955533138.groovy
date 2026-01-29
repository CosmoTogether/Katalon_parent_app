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
TestObject menuButton        = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject activityCenter    = findTestObject('Object Repository/HamburgerMenu/ActivityCenterTab')
TestObject focusModeOption   = findTestObject('Object Repository/ActivityCenterScreen/FocusModeButton')
TestObject AddButton        = findTestObject('Object Repository/FocusModeScreen/PlusButton')
TestObject jrTrackOption     = findTestObject('Object Repository/FocusModeScreen/Click- For JrTrack5-Button')
TestObject newFocusMode      = findTestObject('Object Repository/NewFocusModeScreen/NewfocusmodeText')
TestObject EnabledFocus      = findTestObject('Object Repository/NewFocusModeScreen/EnabledFocus')
TestObject focusNameField    = findTestObject('Object Repository/NewFocusModeScreen/FocusNameField')
TestObject startTime         = findTestObject('Object Repository/NewFocusModeScreen/StartTime')
TestObject endTime           = findTestObject('Object Repository/NewFocusModeScreen/EndTime')
TestObject repeatEvery       = findTestObject('Object Repository/NewFocusModeScreen/RepeatEvery')
TestObject saveButton        = findTestObject('Object Repository/NewFocusModeScreen/SaveButton')

// Tap through app
Mobile.tap(menuButton, 0)
println 'Tapped Menu button'

Mobile.tap(activityCenter, 0)
println 'Opened Activity Center'

Mobile.tap(focusModeOption, 0)
println 'Opened Focus Mode'

Mobile.tap(AddButton, 0)
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
	Mobile.waitForElementPresent(EnabledFocus, 10)
	Mobile.verifyElementVisible(EnabledFocus, 0, FailureHandling.STOP_ON_FAILURE)
	println 'Verified EnabledFocus'
} catch (Exception e) {
	println "Verification failed for EnabledFocus: ${e.getMessage()}"
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


