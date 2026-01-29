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

TestObject menuBtn      = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject myDevicesOpt = findTestObject('Object Repository/HamburgerMenu/MydevicesTab')
TestObject myDevicesTxt = findTestObject('Object Repository/MyDevicesScreen/MydevicesText')
TestObject deviceImg    = findTestObject('Object Repository/MyDevicesScreen/VisibleDevice1')
TestObject DeviceDescription = findTestObject('Object Repository/DashboardScreen/DeviceDescription')

if (Mobile.waitForElementPresent(menuBtn, 5, FailureHandling.OPTIONAL)) {

	Mobile.tap(menuBtn, 0)
	println 'Menu button tapped'

	if (Mobile.waitForElementPresent(myDevicesOpt, 5, FailureHandling.OPTIONAL)) {

		Mobile.tap(myDevicesOpt, 0)
		println 'My Devices option selected'

		if (Mobile.waitForElementPresent(myDevicesTxt, 5, FailureHandling.OPTIONAL)) {

			Mobile.verifyElementVisible(myDevicesTxt, 0)
			println 'My Devices screen opened successfully'

			if (Mobile.waitForElementPresent(deviceImg, 5, FailureHandling.OPTIONAL)) {

				Mobile.tap(deviceImg, 0)
				println 'Device image tapped'

				if (Mobile.waitForElementPresent(DeviceDescription, 5, FailureHandling.STOP_ON_FAILURE)) {

					Mobile.verifyElementVisible(DeviceDescription, 0)
					println 'Device details layout is visible'

				}
			}
		}
	}
} else {

	println 'Menu button not visible. Test cannot continue.'
}

Mobile.pressBack()
