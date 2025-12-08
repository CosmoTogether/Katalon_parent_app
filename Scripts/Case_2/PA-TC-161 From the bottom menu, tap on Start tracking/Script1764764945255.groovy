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

Mobile.tap(findTestObject('Object Repository/case_2/case-6/android.widget.TextView - Starttracking'), 0)

if (Mobile.waitForElementPresent(findTestObject('Object Repository/case_2/case-6/android.widget.TextView - Active Live Tracking'), 
    3, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Object Repository/case_2/case-6/android.widget.Button - Confirm'), 0)

    println('confirm buttom appear')
} else {
    println('confirm button doesnot appear')
}

Mobile.verifyElementVisible(findTestObject('Object Repository/case_2/case-6/android.widget.TextView - Tracking'), 0)

Mobile.tap(findTestObject('Object Repository/case_2/case-6/android.widget.TextView - Tracking'), 0)

Mobile.closeApplication()

