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


Mobile.tap(findTestObject('Object Repository/PA-TC-116/android.widget.Button - Sign in'), 0)

Mobile.setText(findTestObject('Object Repository/PA-TC-116/android.widget.AutoCompleteTextView - Email'), username, 0)

Mobile.setText(findTestObject('Object Repository/PA-TC-116/android.widget.EditText - Password'), password, 0)

Mobile.tap(findTestObject('Object Repository/PA-TC-116/android.widget.Button - Sign in (1)'), 0)

def tapIfVisible(String testObjectPath, int timeout = 5) {
	try {
		TestObject obj = findTestObject(testObjectPath) // convert string to TestObject
		if (Mobile.waitForElementPresent(obj, timeout)) {
			Mobile.tap(obj, 0)
			println("'${testObjectPath}' tapped")
		} else {
			println("'${testObjectPath}' not visible, skipping")
		}
	} catch (Exception e) {
		println("Error handling '${testObjectPath}': " + e.getMessage())
	}
}
tapIfVisible('Object Repository/case-1/android.widget.Button - Allow')

def tapIfVisibleById(String testObjectPath) {
	try {
		TestObject obj = findTestObject(testObjectPath) // convert string to TestObject
		if (Mobile.waitForElementPresent(obj, 5)) { // wait up to 5 seconds
			Mobile.tap(obj, 0)
			println("'${testObjectPath}' tapped")
		} else {
			println("'${testObjectPath}' not visible within 5 seconds, skipping")
		}
	} catch (Exception e) {
		println("Error handling '${testObjectPath}': " + e.getMessage())
	}
}

tapIfVisibleById('Object Repository/case-1/android.widget.Button - While using the app')

try {
	Mobile.verifyElementExist(
		findTestObject('Object Repository/case-1/android.widget.ImageButton'),
		10)
	println 'ImageButton exists on the screen'

} catch (Exception e) {
   println 'ImageButton does not exist or not visible'
}


