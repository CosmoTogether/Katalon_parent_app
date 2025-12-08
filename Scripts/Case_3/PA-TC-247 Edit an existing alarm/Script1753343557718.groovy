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

Mobile.startExistingApplication('com.cosmo.missioncontrol')

Mobile.tap(findTestObject('Object Repository/Test_3/android.widget.ImageButton'), 0)

Mobile.tap(findTestObject('Object Repository/Test_3/android.widget.LinearLayout'), 0)

Mobile.tap(findTestObject('Object Repository/Test_3/android.widget.LinearLayout (1)'), 0)

TestObject alarmLayout = findTestObject('Object Repository/Test_3/android.widget.LinearLayout- alarm')

boolean isVisible = false

try {
    isVisible = Mobile.verifyElementVisible(alarmLayout, 5)
} catch (Exception e) {
    isVisible = false
    println("Element not visible or not found: " + e.getMessage())
}

if (isVisible) {
    Mobile.tap(alarmLayout, 10)
    Mobile.tap(findTestObject('Object Repository/Test_3/android.widget.ToggleButton - T'), 0)
    Mobile.tap(findTestObject('Object Repository/Test_3/android.widget.Button - Save'), 0)
	
	Mobile.verifyElementVisible(findTestObject('Object Repository/Test_3/android.widget.TextView - Alarms'), 0)
	
} else {
    println('You currently have no alarms set up')
}


Mobile.closeApplication()