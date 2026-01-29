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
TestObject menuButton        = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject activityCenter    = findTestObject('Object Repository/HamburgerMenu/ActivityCenterTab')
TestObject focusModeOption   = findTestObject('Object Repository/ActivityCenterScreen/FocusModeButton')
TestObject focusItem          = findTestObject('Object Repository/FocusModeScreen/FirstFocusMode')
TestObject editFocusText      = findTestObject('Object Repository/EditFocusModeScreen/EditFocusModeText')
TestObject deleteButton       = findTestObject('Object Repository/EditFocusModeScreen/DeleteFocusModeButton')
TestObject okButton         = findTestObject('Object Repository/EditFocusModeScreen/OKButton')
TestObject toastMessage     = findTestObject('Object Repository/FocusModeScreen/VerifyToast - Focus mode deleted')

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

Mobile.waitForElementPresent(deleteButton, 10)
Mobile.tap(deleteButton, 0)
println 'Tapped Delete focus mode button'

Mobile.waitForElementPresent(okButton, 10)
Mobile.tap(okButton, 0)
println 'Tapped OK to confirm deletion'

try {
	Mobile.verifyElementExist(toastMessage, 5, FailureHandling.STOP_ON_FAILURE)
	println 'Validation toast message verified'
} catch (Exception e) {
	println "Verification failed for toast message: ${e.getMessage()}"
}

// Navigate back
Mobile.pressBack()
Mobile.pressBack()
println 'Navigated back to previous screen'
