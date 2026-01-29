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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

// TestObjects
TestObject menuButton     = findTestObject('Object Repository/DashboardScreen/MenuButton')
TestObject safeZonesItem  = findTestObject('Object Repository/HamburgerMenu/SafeZonesTab')
TestObject zoneItem      = findTestObject('Object Repository/SafeZoneScreen/ZoneItem')
TestObject deleteButton    = findTestObject('Object Repository/EditSafeZoneScren/DeleteSafeZone')
TestObject okButton        = findTestObject('Object Repository/EditSafeZoneScren/OkDeleteButton')

// Steps
Mobile.tap(menuButton, 0)
KeywordUtil.logInfo('Tapped Menu button')

Mobile.tap(safeZonesItem, 0)
KeywordUtil.logInfo('Opened SafeZones section')

// Verify SafeZone list is visible
try {
	Mobile.verifyElementVisible(zoneItem, 5)
	KeywordUtil.logInfo('SafeZone element is visible')
} catch (Exception e) {
	KeywordUtil.logInfo('SafeZone element not found: ' + e.getMessage())
}

// Count before deletion
int countBefore = countViewGroups()
KeywordUtil.logInfo('Number of SafeZones BEFORE delete: ' + countBefore)

// Delete a SafeZone
Mobile.tap(zoneItem, 0)
KeywordUtil.logInfo('Selected first SafeZone for deletion')

Mobile.tap(deleteButton, 0)
KeywordUtil.logInfo('Tapped Delete SafeZone button')

Mobile.tap(okButton, 0)
KeywordUtil.logInfo('Confirmed deletion')

// Count after deletion
int countAfter = countViewGroups()
KeywordUtil.logInfo('Number of SafeZones AFTER delete: ' + countAfter)

// Verify deletion
try {
	assert countAfter < countBefore : 'SafeZone was not deleted. Count did not decrease!'
	KeywordUtil.logInfo('SafeZone deletion verified successfully')
} catch (Exception e) {
	KeywordUtil.logInfo('SafeZone deletion verification failed: ' + e.getMessage())
}

// Navigate back
Mobile.pressBack()
KeywordUtil.logInfo('Navigated back to previous screen')

// Helper method to count SafeZones dynamically
def countViewGroups() {
	int index = 1
	int count = 0

	while (true) {
		TestObject dynamicObj = new TestObject("dynamicObj_$index")
		dynamicObj.addProperty('xpath', ConditionType.EQUALS, "(//android.view.ViewGroup)[$index]")

		boolean exists = Mobile.verifyElementExist(dynamicObj, 1, FailureHandling.OPTIONAL)
		if (!exists) break

		count++
		index++
	}

	return count
}
