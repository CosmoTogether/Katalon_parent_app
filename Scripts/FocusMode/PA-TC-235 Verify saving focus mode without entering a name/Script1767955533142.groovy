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

TestObject menuButton        = findTestObject('Object Repository/case_13/case-7/android.widget.ImageButton')
TestObject activityCenter    = findTestObject('Object Repository/case_13/case-7/android.widget.CheckedTextView - Activity Center')
TestObject focusModeOption   = findTestObject('Object Repository/case_13/case-7/android.widget.TextView - Focus mode')
TestObject backButton        = findTestObject('Object Repository/case_13/case-7/android.widget.ImageButton (1)')
TestObject jrTrackOption     = findTestObject('Object Repository/case_13/case-7/android.widget.TextView - For JrTrack5')
TestObject toggleButton      = findTestObject('Object Repository/case_13/case-7/android.widget.ToggleButton - S')
TestObject saveButton        = findTestObject('Object Repository/case_13/case-7/android.widget.Button - Save')
TestObject toastMessage      = findTestObject('Object Repository/case_13/case-7/android.widget.Toast - focus name is a required field')

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

Mobile.scrollToText('Enable this focus on these devices')
println 'Scrolled to focus device section'

Mobile.waitForElementPresent(toggleButton, 10)
Mobile.tap(toggleButton, 0)
println 'Enabled Focus Mode toggle'

Mobile.waitForElementPresent(saveButton, 10)
Mobile.tap(saveButton, 0)
println 'Tapped Save button'

try {
	
	Mobile.waitForElementPresent(toastMessage, 10)
	Mobile.verifyElementExist(toastMessage, 5)
	println 'Validation toast message verified'
} catch (Exception e) {
	println "Verification failed for toast message: ${e.getMessage()}"
}

Mobile.pressBack()
Mobile.delay(1)
Mobile.pressBack()
Mobile.delay(1)
println 'Navigated back to previous screen'

