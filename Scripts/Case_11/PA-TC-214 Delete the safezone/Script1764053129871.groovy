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
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

Mobile.startExistingApplication('com.cosmo.missioncontrol')

Mobile.tap(findTestObject('Object Repository/case_11/case-9/android.widget.ImageButton'), 0)
Mobile.tap(findTestObject('Object Repository/case_11/case-9/android.widget.CheckedTextView - SafeZones'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/case_11/case-9/android.view.ViewGroup'), 0)

def countViewGroups() {
	int index = 1
	int count = 0
	while (true) {
		TestObject dynamicObj = new TestObject("dynamicObj_$index")
		dynamicObj.addProperty("xpath", ConditionType.EQUALS, "(//android.view.ViewGroup)[$index]")
		
		boolean exists = Mobile.verifyElementExist(dynamicObj, 1, FailureHandling.OPTIONAL)
		if (!exists) break
		
		count++
		index++
	}
	return count
}

// Count before deletion
int countBefore = countViewGroups()
println("Number of elements BEFORE delete: " + countBefore)

// Delete a SafeZone
Mobile.tap(findTestObject('Object Repository/case_11/case-9/android.view.ViewGroup'), 0)
Mobile.tap(findTestObject('Object Repository/case_11/case-9/android.widget.Button - Delete SafeZone'), 0)
Mobile.tap(findTestObject('Object Repository/case_11/case-9/android.widget.Button - OK'), 0)

// Count after deletion
int countAfter = countViewGroups()
println("Number of elements AFTER delete: " + countAfter)

assert countAfter < countBefore : "SafeZone was not deleted. Count did not decrease!"

Mobile.closeApplication()
