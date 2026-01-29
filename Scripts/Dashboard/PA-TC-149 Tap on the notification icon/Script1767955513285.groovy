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
import com.kms.katalon.core.model.FailureHandling

// Test Objects
TestObject notificationsTab  = findTestObject('Object Repository/DashboardScreen/Notication')
TestObject notificationsText = findTestObject('Object Repository/NotificationScreen/NotificationsText (1)')
TestObject clearAllButton    = findTestObject('Object Repository/NotificationScreen/ClearAll')
TestObject okButton          = findTestObject('Object Repository/NotificationScreen/OkButton')
TestObject toastMessages     = findTestObject('Object Repository/NotificationScreen/VerifyToast - Messages Removed')


// Tap Notifications tab
Mobile.waitForElementPresent(notificationsTab, 10)
Mobile.tap(notificationsTab, 0)
println 'Opened Notifications tab'

// Get Notifications text
Mobile.waitForElementPresent(notificationsText, 10)
String notifText = Mobile.getText(notificationsText, 0)
println "Notifications text displayed: ${notifText}"

// Check if "Clear all" button is present
if (Mobile.waitForElementPresent(clearAllButton, 3, FailureHandling.OPTIONAL)) {
	Mobile.tap(clearAllButton, 0)
	println 'Tapped Clear All button'

	Mobile.waitForElementPresent(okButton, 5)
	Mobile.tap(okButton, 0)
	println 'Tapped OK button to confirm clearing messages'

	Mobile.waitForElementPresent(toastMessages, 5)
	Mobile.verifyElementExist(toastMessages, 0)
	println 'Messages cleared successfully'
} else {
	println 'No messages to clear'
}

// Navigate back
Mobile.pressBack()
println 'Returned to previous screen'

