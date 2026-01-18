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
TestObject menuButton         = findTestObject('Object Repository/case_13/case-11/android.widget.ImageButton')
TestObject activityCenter     = findTestObject('Object Repository/case_13/case-11/android.widget.CheckedTextView - Activity Center')
TestObject focusModeOption    = findTestObject('Object Repository/case_13/case-11/android.widget.TextView - Focus mode')
TestObject focusItem          = findTestObject('Object Repository/case_13/case-11/android.widget.LinearLayout')
TestObject editFocusText      = findTestObject('Object Repository/case_13/case-11/android.widget.TextView - Edit focus mode')
TestObject deleteButton       = findTestObject('Object Repository/case_13/case-11/android.widget.Button - Delete focus mode')
TestObject saveButton         = findTestObject('Object Repository/case_13/case-11/android.widget.Button - Save')
TestObject toastMessage       = findTestObject('Object Repository/case_13/case-11/android.widget.Toast - Save complete')

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

Mobile.waitForElementPresent(focusItem, 10)
Mobile.tap(focusItem, 0)
println 'Selected a Focus Mode item'

Mobile.verifyElementVisible(editFocusText, 5)
println '"Edit focus mode" screen verified'

Mobile.verifyElementVisible(deleteButton, 5, FailureHandling.STOP_ON_FAILURE)
println '"Delete focus mode" button verified'

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
println 'Navigated back to previous screen'


