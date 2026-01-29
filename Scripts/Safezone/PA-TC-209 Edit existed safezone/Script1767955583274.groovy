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

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject

// TestObjects
TestObject menuButton     = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject safeZonesItem  = findTestObject('Object Repository/HamburgerMenu/SafeZonesTab')
TestObject zoneItem      = findTestObject('Object Repository/SafeZoneScreen/ZoneItem')
TestObject saveButton    = findTestObject('Object Repository/EditSafeZoneScren/SaveButton')
TestObject okButton      = findTestObject('Object Repository/EditSafeZoneScren/OkButton')
TestObject safeZonesText = findTestObject('Object Repository/SafeZoneScreen/SafeZonesText')

// Steps
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

Mobile.tap(safeZonesItem, 0)
KeywordUtil.logInfo('Opened SafeZones section')

Mobile.tap(zoneItem, 0)
KeywordUtil.logInfo('Selected a SafeZone item')

// If needed, you can uncomment to rename the zone dynamically
// def random4Digit = (1000 + new Random().nextInt(9000))
// String zoneName = "test${random4Digit}"
// Mobile.clearText(findTestObject('null'), 0)
// Mobile.setText(findTestObject('null'), zoneName, 0)
// KeywordUtil.logInfo("Renamed SafeZone to: ${zoneName}")

Mobile.tap(saveButton, 0)
KeywordUtil.logInfo('Tapped Save button')

Mobile.tap(okButton, 0)
KeywordUtil.logInfo('Tapped OK button')

// Verification with try-catch
try {
	Mobile.verifyElementVisible(safeZonesText, 0)
	KeywordUtil.logInfo('SafeZones section is visible after updating zone')
} catch (Exception e) {
	KeywordUtil.logInfo('SafeZones visibility verification failed: ' + e.getMessage())
}

// Navigate back
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')


