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

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject

TestObject menuBtn        = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject activityCenter = findTestObject('Object Repository/HamburgerMenu/ActivityCenterTab')
TestObject focusModeOpt   = findTestObject('Object Repository/ActivityCenterScreen/FocusModeButton')
TestObject focusModeTxt   = findTestObject('Object Repository/FocusModeScreen/VerifyFocusMode')
TestObject focusLayout    = findTestObject('Object Repository/FocusModeScreen/FirstFocusMode')
TestObject addBtn        = findTestObject('Object Repository/FocusModeScreen/PlusButton')

if (Mobile.waitForElementPresent(menuBtn, 5, FailureHandling.OPTIONAL)) {

	Mobile.tap(menuBtn, 0)
	println 'Menu button tapped successfully'

	if (Mobile.waitForElementPresent(activityCenter, 5, FailureHandling.OPTIONAL)) {

		Mobile.tap(activityCenter, 0)
		println 'Activity Center opened'

		if (Mobile.waitForElementPresent(focusModeOpt, 5, FailureHandling.OPTIONAL)) {

			Mobile.tap(focusModeOpt, 0)
			println 'Focus Mode option tapped'

			if (Mobile.waitForElementPresent(focusModeTxt, 5, FailureHandling.OPTIONAL)) {

				String focusText = Mobile.getText(focusModeTxt, 0)
				println "Navigated to screen: ${focusText}"

				if (Mobile.waitForElementPresent(focusLayout, 5, FailureHandling.STOP_ON_FAILURE)) {

					Mobile.verifyElementVisible(focusLayout, 0)
					println 'Focus mode layout is visible'

					String status = Mobile.getAttribute(focusLayout, 'enabled', 1)

					if (status == 'true') {
						println 'Focus mode is ENABLED'
					} else {
						println 'Focus mode is DISABLED'
					}
				}
			}
		}
	}
} else {

	println 'Menu button not visible. Unable to proceed.'
}

if (Mobile.waitForElementPresent(addBtn, 5, FailureHandling.STOP_ON_FAILURE)) {
	Mobile.verifyElementVisible(addBtn, 0)
	println 'Add button visible'
}

Mobile.pressBack()
Mobile.pressBack()
