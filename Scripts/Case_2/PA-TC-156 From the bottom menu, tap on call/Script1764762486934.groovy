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

Mobile.tap(findTestObject('Object Repository/case_2/case-5/android.widget.ImageView'), 0)

if (Mobile.waitForElementPresent(findTestObject('Object Repository/case_2/case-5/android.widget.Button - Allow'), 3, FailureHandling.OPTIONAL)) {
	
    Mobile.tap(findTestObject('Object Repository/case_2/case-5/android.widget.Button - Allow'), 0)

    println("Allow button was visible and tapped.")

} else {
    println("Allow button not visible. Skipping tap.")
}

if (Mobile.verifyElementVisible(
		findTestObject('Object Repository/case_2/case-5/android.widget.TextView - Check your phone and this tablet to make sure Call  text on other devices is turned on'),
		0,
		FailureHandling.OPTIONAL)) {
	println("Call cannot be made because the device setting is OFF.")

} else {
	println("Call can be made.")
}

Mobile.verifyElementVisible(findTestObject('Object Repository/case_2/case-5/android.widget.TextView - Check your phone and this tablet to make sure Call  text on other devices is turned on'), 0)


Mobile.closeApplication()

